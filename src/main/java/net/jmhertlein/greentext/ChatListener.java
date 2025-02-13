package net.jmhertlein.greentext;

import java.awt.Color;
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
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class ChatListener implements Listener {

	private final List<Attribute> formattingAttribute = new ArrayList<>(Arrays.asList(
			new Attribute(true, "~-~", -1, null), // color text
			new Attribute(true, "-~-", -1, null), // tranny text
			new Attribute(false, ">", NamedTextColor.GREEN, null),
			new Attribute(false, "<", NamedTextColor.GOLD, null),
			new Attribute(false, "^", NamedTextColor.DARK_PURPLE, null),
			new Attribute(true, "!!", NamedTextColor.DARK_RED, TextDecoration.BOLD), // red "glow" text
			new Attribute(true, "===", NamedTextColor.DARK_RED, null),
			new Attribute(true, "==", NamedTextColor.RED, null),
			new Attribute(true, "=", NamedTextColor.LIGHT_PURPLE, null), // doll text
			new Attribute(true, "----", NamedTextColor.DARK_BLUE, TextDecoration.BOLD), // blue "glow" text
			new Attribute(true, "---", NamedTextColor.DARK_BLUE, null),
			new Attribute(true, "--", NamedTextColor.BLUE, null), 
			new Attribute(true, "-", NamedTextColor.AQUA, null),
			new Attribute(true, "+++", NamedTextColor.BLACK, null),
			new Attribute(true, "++", NamedTextColor.DARK_GRAY, null), // soot text
			new Attribute(true, "+", NamedTextColor.GRAY, null), 
			new Attribute(true, "||", NamedTextColor.YELLOW, null),
			new Attribute(true, "::", NamedTextColor.GOLD, TextDecoration.BOLD),
			new Attribute(true, "%%", NamedTextColor.DARK_GREEN, TextDecoration.BOLD),
			new Attribute(true, "~~", -1, TextDecoration.STRIKETHROUGH),
			new Attribute(true, "__", -1, TextDecoration.UNDERLINED),
			new Attribute(true, "'''", -1, TextDecoration.BOLD), 
			new Attribute(true, "''", -1, TextDecoration.ITALIC),
			new Attribute(true, "&&", 9127187, null) // caca text
	));

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerChat(AsyncChatEvent e) {
		// setup
		Component message = e.message();
		String msg = PlainTextComponentSerializer.plainText().serialize(message);
		Attribute selected = null;

		// the actual meat and potatoes of the entire class
		for (Attribute a : formattingAttribute) {
			if ((a.wrap && test(a.chars, msg)) || (!a.wrap && msg.startsWith(a.chars))) {
				selected = a;
				break;
			}
		}

		// if no text attribute applies, don't do anything else
		if (selected == null) {
			e.message(message);
			return;
		}

		String chars = selected.chars;
		int col = selected.color;

		// apply color (if present)
		if (selected.wrap) {
			message = TextComponent.ofChildren(replaceMagicChars(message, chars)).color(TextColor.color(col));
		} else {
			message = TextComponent.ofChildren(message).color(TextColor.color(col));
		}
		// apply deco (if present)
		if (selected.deco != null) {
			message = TextComponent.ofChildren(replaceMagicChars(message, chars)).decorate(selected.deco);
		}

		// get the string and be accepting of UTF8+ emojis 
		String[] c = PlainTextComponentSerializer.plainText().serialize(message).codePoints()
			    .mapToObj(cp -> new String(Character.toChars(cp)))
			    .toArray(size -> new String[size]);
		
		// do rainbow text
		if (selected.chars.equals("~-~")) {
			TextComponent.Builder builder = Component.text();
			// replace chars
			message = TextComponent.ofChildren(replaceMagicChars(message, selected.chars));
		
			// C O L O R!
			for (int j = 0; j < c.length; j++) {
				float hue = (0.8f - ((float) j / (float) c.length) * 0.8f) % 1.0f;
				TextColor color = TextColor.color(Color.HSBtoRGB(hue, 1.0f, 1.0f));
				builder.append(Component.text(c[j], color));
			}
			message = builder.build();
		}

		// do tranny text
		if ("-~-".equals(selected.chars)) {
			TextComponent.Builder builder = Component.text();
			// replace chars
			message = TextComponent.ofChildren(replaceMagicChars(message, selected.chars));
			
			for (int j = 0; j < c.length; j++) {

				// this was real GLSL at one point
				float uv = (float) j / (float) c.length;
				int ret = -1; // white
				if (uv < 0.4 || uv > 0.6) {
					ret = 16690887;
				}
				if (uv < 0.2 || uv > 0.8) {
					ret = 9240313;
				}
				TextColor color = TextColor.color(ret);
				builder.append(Component.text(c[j], color));
			}
			message = builder.build();
		}
		e.message(message);
	}

	// code relating to Attribute selection logic

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
		public int color = 0;
		public TextDecoration deco = null;

		Attribute(boolean wrap, String chars, NamedTextColor color, TextDecoration deco) {
			this.wrap = wrap;
			this.chars = chars;
			this.color = color.value();
			this.deco = deco;
		}

		// second constructor to allow arbitrary color codes
		Attribute(boolean wrap, String chars, int color, TextDecoration deco) {
			this.wrap = wrap;
			this.chars = chars;
			this.color = color;
			this.deco = deco;
		}
	}
}
