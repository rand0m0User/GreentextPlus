package net.jmhertlein.greentext;

import org.bukkit.plugin.java.JavaPlugin;

public class GreentextPlugin extends JavaPlugin {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }
}
