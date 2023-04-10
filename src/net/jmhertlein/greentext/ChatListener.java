package net.jmhertlein.greentext;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        if (message.startsWith(">")) {
            e.setMessage(ChatColor.GREEN + message);
        } else if (message.startsWith("<")) {
            e.setMessage(ChatColor.GOLD + message);
        } else if (message.startsWith("==")
                && message.endsWith("==")
                && message.replace("==", "").length() != 0) {
            e.setMessage(ChatColor.RED + message.replace("==", ""));
        } else if (message.startsWith("--")
                && message.endsWith("--")
                && message.replace("--", "").length() != 0) {
            e.setMessage(ChatColor.BLUE + message.replace("--", ""));
        } else if (message.startsWith("%%")
                && message.endsWith("%%")
                && message.replace("--", "").length() != 0) {
            e.setMessage(ChatColor.BOLD + "" + ChatColor.GREEN + message.replace("%%", ""));
        }
    }
}
