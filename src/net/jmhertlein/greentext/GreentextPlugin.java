package net.jmhertlein.greentext;

import org.bukkit.plugin.java.JavaPlugin;

public class GreentextPlugin extends JavaPlugin {
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this); //greentext
        this.getServer().getPluginManager().registerEvents(new BookListener(), this); //anti book ban
        this.getServer().getPluginManager().registerEvents(new MoCrafting(this), this); //add crafting recipes for gapples and ender stars
    }
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
    //I ❤ BOILERPLATE
}
