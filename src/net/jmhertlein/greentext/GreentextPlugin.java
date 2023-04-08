package net.jmhertlein.greentext;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class GreentextPlugin extends JavaPlugin {
   public void onEnable() {
      this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
   }
}
