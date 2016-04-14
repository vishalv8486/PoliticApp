package com.karma.politic;

import android.graphics.drawable.Drawable;

public class MinistryItem {

	String Name;
	String Constituency;
	String Duration;
	String dateTime;
	String Party;
	Drawable Image;

	public MinistryItem(String Name, String Constituency, String Duration,
			String dateTime, Drawable Image, String Party) {

		this.Name=Name;
		this.Constituency=Constituency;
		this.Duration=Duration;
		this. dateTime=dateTime;
		this.Party=Party;
		this. Image=Image;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getConstituency() {
		return Constituency;
	}

	public void setConstituency(String constituency) {
		Constituency = constituency;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getParty() {
		return Party;
	}

	public void setParty(String party) {
		Party = party;
	}

	public Drawable getImage() {
		return Image;
	}

	public void setImage(Drawable image) {
		Image = image;
	}

}
