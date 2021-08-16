package fr.acore.bungeecord.listener;


import fr.acore.bungeecord.manager.ACustomPingerManager;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ACustomPingerListener implements Listener{

	private ACustomPingerManager manager;
	
	public ACustomPingerListener(ACustomPingerManager manager) {
		this.manager = manager;
	}
	
	@EventHandler
	public void onPingServer(ProxyPingEvent event) {
		ServerPing ping = event.getResponse();

		if(manager.getOnlinePlayer() != -1) ping.getPlayers().setOnline(manager.getOnlinePlayer());
		if(manager.getMaxOnlinePlayer() != -1) ping.getPlayers().setMax(manager.getMaxOnlinePlayer());
		if(manager.getHoverMessage().length > 0) ping.getPlayers().setSample(manager.getHoverMessage());
		if(manager.getProtocolVersion() != -1) ping.getVersion().setProtocol(manager.getProtocolVersion());
		if(!manager.getProtocolVersionName().equals("-1")) ping.getVersion().setName(manager.getProtocolVersionName());
		if(!manager.getFormatedMotd().isEmpty()) ping.setDescriptionComponent(new TextComponent(manager.getFormatedMotd()));
		event.setResponse(ping);
	}
	
}
