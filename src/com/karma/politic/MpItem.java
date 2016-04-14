package com.karma.politic;

import android.graphics.drawable.Drawable;

public class MpItem {

	String mpName;
	String mpConstituency;
	String mpDuration;
	String dateTime;
	String mpParty;
	Drawable mpImage;

	public MpItem(String mpName, String mpConstituency, String mpDuration,
			String dateTime, Drawable mpImage, String mpParty) {

		this.mpName = mpName;
		this.mpImage = mpImage;
		this.mpConstituency = mpConstituency;
		this.mpDuration = mpDuration;
		this.dateTime = dateTime;
		this.mpParty = mpParty;
	}

	public String getMpName() {
		return mpName;
	}

	public void setMpName(String mpName) {
		this.mpName = mpName;
	}

	public String getMpConstituency() {
		return mpConstituency;
	}

	public void setMpConstituency(String mpConstituency) {
		this.mpConstituency = mpConstituency;
	}

	public String getMpDuration() {
		return mpDuration;
	}

	public void setMpDuration(String mpDuration) {
		this.mpDuration = mpDuration;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getMpParty() {
		return mpParty;
	}

	public void setMpParty(String mpParty) {
		this.mpParty = mpParty;
	}

	public Drawable getMpImage() {
		return mpImage;
	}

	public void setMpImage(Drawable mpImage) {
		this.mpImage = mpImage;
	}

}
