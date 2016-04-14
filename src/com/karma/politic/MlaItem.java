package com.karma.politic;

import android.graphics.drawable.Drawable;

public class MlaItem {

	String mlaName;
	String mlaConstituency;
	String mlaDuration;
	String dateTime;
	String mlaParty;
	Drawable mlaImage;

	public MlaItem(String mlaName, String mlaConstituency, String mlaDuration,
			String dateTime, Drawable mlaImage,String mlaParty) {

		this.mlaName = mlaName;
		this.mlaImage = mlaImage;
		this.mlaConstituency = mlaConstituency;
		this.mlaDuration = mlaDuration;
		this.dateTime = dateTime;
		this.mlaParty=mlaParty;

	}

	public String getMlaParty() {
		return mlaParty;
	}

	public void setMlaParty(String mlaParty) {
		this.mlaParty = mlaParty;
	}

	public String getMlaName() {
		return mlaName;
	}

	public void setMlaName(String mlaName) {
		this.mlaName = mlaName;
	}

	public String getMlaConstituency() {
		return mlaConstituency;
	}

	public void setMlaConstituency(String mlaConstituency) {
		this.mlaConstituency = mlaConstituency;
	}

	public String getMlaDuration() {
		return mlaDuration;
	}

	public void setMlaDuration(String mlaDuration) {
		this.mlaDuration = mlaDuration;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Drawable getImageMlaIcon() {
		return mlaImage;
	}

	public void setImageMlaIcon(Drawable imageMlaIcon) {
		this.mlaImage = imageMlaIcon;
	}

}
