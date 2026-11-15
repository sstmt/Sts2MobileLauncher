package com.godot.game.llm;

import java.util.Locale;

/**
 * Picks the Japanese variant of a message that is built outside Android resources
 * (no Context available) when the device language is Japanese; otherwise keeps the original text.
 */
public final class Ja {
	private Ja() {}

	public static boolean active() {
		return "ja".equals(Locale.getDefault().getLanguage());
	}

	public static String t(String original, String japanese) {
		return active() ? japanese : original;
	}

	/** True when {@code text} starts with either language variant of a locally generated prefix. */
	public static boolean startsWith(String text, String original, String japanese) {
		return text != null && (text.startsWith(original) || text.startsWith(japanese));
	}
}
