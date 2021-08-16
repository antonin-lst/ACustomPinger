package fr.acore.bungeecord.manager;

import java.util.ArrayList;
import java.util.List;

import fr.acore.bungeecord.ACustomPinger;
import fr.acore.bungeecord.listener.ACustomPingerListener;
import fr.acore.bungeecord.module.AManager;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.config.Configuration;

public class ACustomPingerManager extends AManager {
	
	private List<String> hoverMessage;
	private String protocolVersionName;
	private List<String> motd;
	private int protocolVersion;
	private int onlinePlayer;
	private int maxOnlinePlayer;
	
	public ACustomPingerManager(ACustomPinger plugin) {
		super(plugin, true);
		registerListener(new ACustomPingerListener(this));
	}
	
	@Override
	public void setup(Configuration config) {
		hoverMessage = convertColor(config.getStringList("hoverMessage"));
		protocolVersionName = convertColor(config.getString("protocolVersionName"));
		motd = convertColor(config.getStringList("motd"));
		protocolVersion = config.getInt("protocolVersion");
		onlinePlayer = config.getInt("onlinePlayer");
		maxOnlinePlayer = config.getInt("maxOnlinePlayer");
	}
	
	
	public PlayerInfo[] getHoverMessage() {
		List<PlayerInfo> pinf = new ArrayList<>();
		for(String hm : hoverMessage) {
			pinf.add(new PlayerInfo(hm, "ii"+hm));
		}
		//PlayerInfo pinf[] = {new PlayerInfo("�5�lHezia V1.0", "�6Launcher Modd�e �e1.8.8"), new PlayerInfo("�6Pour plus d'information �ewyraah.fr", "")};
		return pinf.toArray(new PlayerInfo[pinf.size()]);
	}
	
	public String getProtocolVersionName() {
		return this.protocolVersionName;
	}
	
	public String getFormatedMotd() {
		if(motd.isEmpty()) return "";
		
		return this.motd.get(0) + "\n" + (this.motd.get(1) != null ? this.motd.get(1) : "");
	}
	
	public int getProtocolVersion() {
		return this.protocolVersion;
	}
	
	public int getOnlinePlayer() {
		return this.onlinePlayer;
	}
	
	public int getMaxOnlinePlayer() {
		return this.maxOnlinePlayer;
	}

}
