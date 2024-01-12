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
	String SNEED = "::";
    String CROSSOUT = "~~";
    String UNDERLINE = "__";
    String BOLD = "'";
    String ITALIC = "''";

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String msg = e.getMessage();
        //msg.replaceAll(":skull:", "\u2620"); //i will NOT learn regex!
        
		String ret = "";
		switch (msg.charAt(0)) { // attempt at optimizing out if else spam by using a switch jumptable
		case '>':
			ret = ChatColor.GREEN + msg;
			break;
		case '<':
			ret = ChatColor.GOLD + msg; // KUUUUUUUZ ADD ChatColor.ORANGE
			break;
		case '^':
			ret = ChatColor.DARK_PURPLE + msg;
		case '=':
			if (test(RED2, msg)) {// be carefull of order of operations next time retard
				ret = ChatColor.DARK_RED + msg.replace(RED2, "");
			} else if (test(RED, msg)) { // fixed bug where "====" would result in an empty message
				ret = ChatColor.RED + msg.replace(RED, "");
			} else if (test(PINK, msg)) {
				ret = ChatColor.LIGHT_PURPLE + msg.replace(PINK, "");
			}
			break;
		case '-':
			if (test(CALM3, msg)) { // 3 '-' 's
				ret = ChatColor.DARK_BLUE + msg.replace(CALM3, "");
			} else if (test(CALM, msg)) { // 2 '-' 's
				ret = ChatColor.BLUE + msg.replace(CALM, "");
			} else if (test(CALM1, msg)) { // 1 '-' 's
				ret = ChatColor.AQUA + msg.replace(CALM1, "");
			}
			break;
		case '+':
			if (test(COAL3, msg)) { // 3 '-' 's
				ret = ChatColor.BLACK + msg.replace(COAL3, "");
			} else if (test(COAL, msg)) { // 2 '-' 's
				ret = ChatColor.DARK_GRAY + msg.replace(COAL, "");
			} else if (test(COAL1, msg)) { // 1 '-' 's
				ret = ChatColor.GRAY + msg.replace(COAL1, "");
			}
			break;
		case '|':
			if (test(YELLOW, msg)) {
				ret = ChatColor.YELLOW + msg.replace(YELLOW, "");
			}
			break;
		case ':':
			if (test(SNEED, msg)) {
				ret = ChatColor.GOLD + msg.replace(SNEED, "");
			}
			break;
		case '%':
			if (test(DATAMINING, msg)) {
				ret = ChatColor.DARK_GREEN + msg.replace(DATAMINING, "");
			}
			break;
		case '~':
			if (test(CROSSOUT, msg)) {
				ret = ChatColor.STRIKETHROUGH + msg.replace(CROSSOUT, "");
			}
			break;
		case '_':
			if (test(UNDERLINE, msg)) {
				ret = ChatColor.UNDERLINE + msg.replace(UNDERLINE, "");
			}
			break;
		case '\'':
			if (test(ITALIC, msg)) {
				ret = ChatColor.ITALIC + msg.replace(ITALIC, "");
			} else if (test(BOLD, msg)) {
				ret = ChatColor.BOLD + msg.replace(BOLD, "");
			}
			break;
		default:
		}
		if (ret.length() > 0) {
			e.setMessage(ret);
		}
	}

	private boolean test(String seq, String msg) {
		return msg.startsWith(seq) && msg.endsWith(seq) && msg.replace(seq, "").length() != 0;
	}
}
