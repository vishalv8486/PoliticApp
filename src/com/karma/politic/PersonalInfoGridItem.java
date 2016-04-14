package com.karma.politic;

import android.graphics.drawable.Drawable;

public class PersonalInfoGridItem {

	String text;
	Drawable image;

	public PersonalInfoGridItem(String text, Drawable image) {
		this.image = image;
		this.text = text;

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Drawable getImage() {
		return image;
	}

	public void setImage(Drawable image) {
		this.image = image;
	}

}
