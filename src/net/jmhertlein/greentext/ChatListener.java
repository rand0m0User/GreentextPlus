package net.jmhertlein.greentext;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    String RED = "==";
    String CALM = "--";
    String DATAMINING = "%%";
    String CROSSOUT = "~~";

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        if (message.startsWith(">")) {
            e.setMessage(ChatColor.GREEN + message);
        } else if (message.startsWith("<")) {
            e.setMessage(ChatColor.GOLD + message); //KUUUUUUUZ ADD ChatColor.ORANGE
        } else if (msg.startsWith("^")) {
            e.setMessage(ChatColor.DARK_PURPLE + msg);
        } else if (message.startsWith(RED)
                && message.endsWith(RED)
                && message.replace(RED, "").length() != 0) { //fixed bug where "====" would result in an empty message
            e.setMessage(ChatColor.RED + message.replace(RED, ""));
        } else if (message.startsWith(CALM)
                && message.endsWith(CALM)
                && message.replace(CALM, "").length() != 0) {
            e.setMessage(ChatColor.BLUE + message.replace(CALM, ""));
        } else if (message.startsWith(DATAMINING)
                && message.endsWith(DATAMINING)
                && message.replace(DATAMINING, "").length() != 0) {
            e.setMessage(ChatColor.DARK_GREEN + message.replace(DATAMINING, ""));
        } else if (message.startsWith(CROSSOUT)
                && message.endsWith(CROSSOUT)
                && message.replace(CROSSOUT, "").length() != 0) {
            e.setMessage(ChatColor.STRIKETHROUGH + message.replace(CROSSOUT, ""));
        }
    }
}
