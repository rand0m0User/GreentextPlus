package net.jmhertlein.greentext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class ChatListener implements Listener {

	private final List<Attribute> formattingAttribute = new ArrayList<>(Arrays.asList(
			new Attribute(false, ">", NamedTextColor.GREEN, null),
			new Attribute(false, "<", NamedTextColor.GOLD, null),
			new Attribute(false, "^", NamedTextColor.DARK_PURPLE, null),
			new Attribute(true, "===", NamedTextColor.DARK_RED, null),
			new Attribute(true, "==", NamedTextColor.RED, null),
			new Attribute(true, "=", NamedTextColor.LIGHT_PURPLE, null),
			new Attribute(true, "---", NamedTextColor.DARK_BLUE, null),
			new Attribute(true, "--", NamedTextColor.BLUE, null),
			new Attribute(true, "-", NamedTextColor.AQUA, null),
			new Attribute(true, "+++", NamedTextColor.BLACK, null),
			new Attribute(true, "++", NamedTextColor.DARK_GRAY, null),
			new Attribute(true, "+", NamedTextColor.GRAY, null), 
			new Attribute(true, "||", NamedTextColor.YELLOW, null),
			new Attribute(true, "::", NamedTextColor.GOLD, TextDecoration.BOLD),
			new Attribute(true, "%%", NamedTextColor.DARK_GREEN, TextDecoration.BOLD),
			new Attribute(true, "~~", null, TextDecoration.STRIKETHROUGH),
			new Attribute(true, "__", null, TextDecoration.UNDERLINED),
			new Attribute(true, "''", null, TextDecoration.ITALIC),
			new Attribute(true, "'", null, TextDecoration.BOLD)));


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat(AsyncChatEvent e) {
		// setup
		Component message = e.message();
		String msg = PlainTextComponentSerializer.plainText().serialize(message);
		Attribute selected = null;

		for (Attribute a : formattingAttribute) {
			if ((a.wrap && test(a.chars, msg)) || (!a.wrap && msg.startsWith(a.chars))) {
				selected = a;
				break;
			}
		}
		if (selected != null) {
			String chars = selected.chars;
			NamedTextColor col = selected.color;
			// apply color (if present)
			if (selected.color != null) {
				if (selected.wrap) {
					message = TextComponent.ofChildren(replaceMagicChars(message, chars)).color(col);
				} else {
					message = TextComponent.ofChildren(message).color(col);
				}
			}
			// apply deco (if present)
			if (selected.Deco != null) {
				message = TextComponent.ofChildren(replaceMagicChars(message, chars)).decorate(selected.Deco);
			}
		}
		e.message(message);
	}

	private Component replaceMagicChars(Component in, String chars) {
		return in.replaceText(TextReplacementConfig.builder().replacement("").match(Pattern.quote(chars)).build());
	}

	private boolean test(String seq, String msg) {
		return msg.startsWith(seq) && msg.endsWith(seq) && msg.replace(seq, "").length() != 0;
	}

	// wrap: Whether or not this attribute needs to be ===surrounded=== or >alone
	// chars: the magic chars that need to exist for the color/style to get applied
	private static class Attribute {
		public boolean wrap = false;
		public String chars = "";
		public NamedTextColor color = null;
		public TextDecoration Deco = null;

		Attribute(boolean wrap, String chars, NamedTextColor color, TextDecoration Deco) {
			this.wrap = wrap;
			this.chars = chars;
			this.color = color;
			this.Deco = Deco;
		}
	}
}
