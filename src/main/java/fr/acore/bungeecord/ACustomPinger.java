package fr.acore.bungeecord;


import fr.acore.bungeecord.manager.ACustomPingerManager;
import fr.acore.bungeecord.module.AModule;

public class ACustomPinger extends AModule {
	
	@Override
	public void onEnable() {
		super.onEnable();
		//logAPluginLink(this);
		registerManager(new ACustomPingerManager(this));
		log("ACommons Enabled");
	}
	/*
	private void loadConfig() throws IOException{
		
		if(!getDataFolder().exists()) getDataFolder().mkdir();
		File configFile = new File(getDataFolder(), "config.yml");
		
		if (!configFile.exists()) {
            InputStream in = getResourceAsStream("config.yml");
            Files.copy(in, configFile.toPath());
        }
		configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
	}
	
	public void reloadConfig() throws IOException{
		File configFile = new File(getDataFolder(), "config.yml");
		configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
	}*/

}
