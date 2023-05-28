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
    String COAL1 = "+";
    String COAL = "++";
    String COAL3 = "+++";
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
        
       switch (msg.charAt(0)) { //attempt at optomizing out if else spam by using a switch jumptable
            case '>':
                e.setMessage(ChatColor.GREEN + msg);
                break;
            case '<':
                e.setMessage(ChatColor.GOLD + msg); //KUUUUUUUZ ADD ChatColor.ORANGE
                break;
            case '^':
                e.setMessage(ChatColor.DARK_PURPLE + msg);
            case '=':
                if (msg.startsWith(RED2) //be carefull of order of operations next time retard
                        && msg.endsWith(RED2)
                        && msg.replace(RED2, "").length() != 0) {
                    e.setMessage(ChatColor.DARK_RED + msg.replace(RED2, ""));
                } else if (msg.startsWith(RED)
                        && msg.endsWith(RED)
                        && msg.replace(RED, "").length() != 0) { //fixed bug where "====" would result in an empty message
                    e.setMessage(ChatColor.RED + msg.replace(RED, ""));
                } else if (msg.startsWith(PINK)
                        && msg.endsWith(PINK)
                        && msg.replace(PINK, "").length() != 0) {
                    e.setMessage(ChatColor.LIGHT_PURPLE + msg.replace(PINK, ""));
                }
                break;
            case '-':
                if (msg.startsWith(CALM3) //3 '-' 's
                        && msg.endsWith(CALM3)
                        && msg.replace(CALM3, "").length() != 0) {
                    e.setMessage(ChatColor.DARK_BLUE + msg.replace(CALM3, ""));
                } else if (msg.startsWith(CALM) //2 '-' 's
                        && msg.endsWith(CALM)
                        && msg.replace(CALM, "").length() != 0) {
                    e.setMessage(ChatColor.BLUE + msg.replace(CALM, ""));
                } else if (msg.startsWith(CALM1) //1 '-' 's
                        && msg.endsWith(CALM1)
                        && msg.replace(CALM1, "").length() != 0) {
                    e.setMessage(ChatColor.AQUA + msg.replace(CALM1, ""));
                }
                break;
            case '+':
                if (msg.startsWith(COAL3) //3 '-' 's
                        && msg.endsWith(COAL3)
                        && msg.replace(COAL3, "").length() != 0) {
                    e.setMessage(ChatColor.BLACK + msg.replace(COAL3, ""));
                } else if (msg.startsWith(COAL) //2 '-' 's
                        && msg.endsWith(COAL)
                        && msg.replace(COAL, "").length() != 0) {
                    e.setMessage(ChatColor.DARK_GRAY + msg.replace(COAL, ""));
                } else if (msg.startsWith(COAL1) //1 '-' 's
                        && msg.endsWith(COAL1)
                        && msg.replace(COAL1, "").length() != 0) {
                    e.setMessage(ChatColor.GRAY + msg.replace(COAL1, ""));
                }
                break;
            case '|':
                if (msg.startsWith(YELLOW)
                        && msg.endsWith(YELLOW)
                        && msg.replace(YELLOW, "").length() != 0) {
                    e.setMessage(ChatColor.YELLOW + msg.replace(YELLOW, ""));
                }
                break;
            case '%':
                if (msg.startsWith(DATAMINING)
                        && msg.endsWith(DATAMINING)
                        && msg.replace(DATAMINING, "").length() != 0) {
                    e.setMessage(ChatColor.DARK_GREEN + msg.replace(DATAMINING, ""));
                }
                break;
            case '~':
                if (msg.startsWith(CROSSOUT)
                        && msg.endsWith(CROSSOUT)
                        && msg.replace(CROSSOUT, "").length() != 0) {
                    e.setMessage(ChatColor.STRIKETHROUGH + msg.replace(CROSSOUT, ""));
                }
                break;
            case '_':
                if (msg.startsWith(UNDERLINE)
                        && msg.endsWith(UNDERLINE)
                        && msg.replace(UNDERLINE, "").length() != 0) {
                    e.setMessage(ChatColor.UNDERLINE + msg.replace(UNDERLINE, ""));
                }
                break;
            case '\'':
                if (msg.startsWith(ITALIC)
                        && msg.endsWith(ITALIC)
                        && msg.replace(ITALIC, "").length() != 0) {
                    e.setMessage(ChatColor.ITALIC + msg.replace(ITALIC, ""));
                } else if (msg.startsWith(BOLD)
                        && msg.endsWith(BOLD)
                        && msg.replace(BOLD, "").length() != 0) {
                    e.setMessage(ChatColor.BOLD + msg.replace(BOLD, ""));
                }
                break;
            default:
        }
    }
}
