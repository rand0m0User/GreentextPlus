package net.jmhertlein.greentext;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import java.nio.charset.StandardCharsets;
import static org.bukkit.Bukkit.getServer;

public class BookListener implements Listener {

    @EventHandler
    public void onBookEdit(PlayerEditBookEvent e) {
        for (String bookPage : e.getNewBookMeta().getPages()) {
            if (!StandardCharsets.US_ASCII.newEncoder().canEncode(bookPage)) {
                e.setCancelled(true);
                getServer().broadcastMessage(e.getPlayer().getDisplayName()
                        + " tried to write non ascii characters into a book!");
                e.getPlayer().kickPlayer("kill yourself frognigger");
                return;
            }
        }
    }
}
