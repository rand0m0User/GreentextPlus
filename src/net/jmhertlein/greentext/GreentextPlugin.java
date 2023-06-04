package net.jmhertlein.greentext;

import org.bukkit.plugin.java.JavaPlugin;

public class GreentextPlugin extends JavaPlugin {
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this); //greentext
        this.getServer().getPluginManager().registerEvents(new BookListener(), this); //anti book ban
    }
}
