package net.jmhertlein.greentext;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    String PINK = "=";
    String RED = "==";
    String RED2 = "===";
    String CALM1 = "-";
    String CALM = "--";
    String CALM3 = "---";
    String DATAMINING = "%%";
    String YELLOW = "||";
    String CROSSOUT = "~~";
    String UNDERLINE = "__";
    String BOLD = "'";
    String ITALIC = "''";

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        //msg.replaceAll(":skull:", "\u2620"); //i will NOT learn regex!

        if (msg.startsWith(">")) {
            e.setMessage(ChatColor.GREEN + msg);
        } else if (msg.startsWith("<")) {
            e.setMessage(ChatColor.GOLD + msg); //KUUUUUUUZ ADD ChatColor.ORANGE
        } else if (msg.startsWith("^")) {
            e.setMessage(ChatColor.DARK_PURPLE + msg);
        } else if (msg.startsWith(PINK)
                && msg.endsWith(PINK)
                && msg.replace(PINK, "").length() != 0) {
            e.setMessage(ChatColor.LIGHT_PURPLE + msg.replace(PINK, ""));
        } else if (msg.startsWith(RED)
                && msg.endsWith(RED)
                && msg.replace(RED, "").length() != 0) { //fixed bug where "====" would result in an empty message
            e.setMessage(ChatColor.RED + msg.replace(RED, ""));
        } else if (msg.startsWith(RED2)
                && msg.endsWith(RED2)
                && msg.replace(RED2, "").length() != 0) {
            e.setMessage(ChatColor.DARK_RED + msg.replace(RED2, ""));
        } else if (msg.startsWith(CALM1)
                && msg.endsWith(CALM1)
                && msg.replace(CALM1, "").length() != 0) {
            e.setMessage(ChatColor.AQUA + msg.replace(CALM1, ""));
        } else if (msg.startsWith(CALM)
                && msg.endsWith(CALM)
                && msg.replace(CALM, "").length() != 0) {
            e.setMessage(ChatColor.BLUE + msg.replace(CALM, ""));
        } else if (msg.startsWith(CALM3)
                && msg.endsWith(CALM3)
                && msg.replace(CALM3, "").length() != 0) {
            e.setMessage(ChatColor.DARK_BLUE + msg.replace(CALM3, ""));
        } else if (msg.startsWith(YELLOW)
                && msg.endsWith(YELLOW)
                && msg.replace(YELLOW, "").length() != 0) {
            e.setMessage(ChatColor.YELLOW + msg.replace(YELLOW, ""));
        } else if (msg.startsWith(DATAMINING)
                && msg.endsWith(DATAMINING)
                && msg.replace(DATAMINING, "").length() != 0) {
            e.setMessage(ChatColor.DARK_GREEN + msg.replace(DATAMINING, ""));
        } else if (msg.startsWith(CROSSOUT)
                && msg.endsWith(CROSSOUT)
                && msg.replace(CROSSOUT, "").length() != 0) {
            e.setMessage(ChatColor.STRIKETHROUGH + msg.replace(CROSSOUT, ""));
        } else if (msg.startsWith(UNDERLINE)
                && msg.endsWith(UNDERLINE)
                && msg.replace(UNDERLINE, "").length() != 0) {
            e.setMessage(ChatColor.UNDERLINE + msg.replace(UNDERLINE, ""));
        } else if (msg.startsWith(BOLD)
                && msg.endsWith(BOLD)
                && msg.replace(BOLD, "").length() != 0) {
            e.setMessage(ChatColor.BOLD + msg.replace(BOLD, ""));
        } else if (msg.startsWith(ITALIC)
                && msg.endsWith(ITALIC)
                && msg.replace(ITALIC, "").length() != 0) {
            e.setMessage(ChatColor.ITALIC + msg.replace(ITALIC, ""));
        }
    }
}
