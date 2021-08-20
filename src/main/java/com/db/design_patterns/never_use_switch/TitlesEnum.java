package com.db.design_patterns.never_use_switch;

/**
 * TODO Class Description
 *
 * @author IrinaTsekhanovich
 * @since 20.08.2021
 */
public enum TitlesEnum {
	WELCOME(1, "Welcome mail was sent"), HAPPY_BIRTHDAY(2,"Happy Birthday mail was sent");

	private final int type;
	private final String title;

	TitlesEnum(int type, String title) {
		this.type = type;
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public static String getTitleByType(int type) {
		TitlesEnum[] titlesEnum = values();
		for (TitlesEnum title : titlesEnum) {
			if (title.getType()==type) {
				return title.getTitle();
			}
		}
		throw new IllegalStateException(type + " not supported");
	}
}
