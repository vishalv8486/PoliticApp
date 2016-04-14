package com.karma.politic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class WorkDetailsPieceActivity extends Activity {
	LinearLayout viewGroup;
	LayoutInflater layoutInflater;
	View layout;
	PopupWindow popupWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.work_details_piece);
	}

	public void showDetailsButton(View v) {
		showCustomWindow();
		// startActivity(new Intent(this, WorkDetailsInfoActivity.class));
	}

	public void showCustomWindow() {

		int popupWidth = 700;
		int popupHeight = 990;

		// int popupWidth = WindowManager.LayoutParams.MATCH_PARENT;
		// int popupHeight = WindowManager.LayoutParams.MATCH_PARENT;

		layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layout = layoutInflater.inflate(R.layout.work_details_layout, null);

		// Inflate the popup_layout.xml

		// Creating the PopupWindow
		final PopupWindow popup = new PopupWindow(this);
		popup.setContentView(layout);
		popup.setWidth(popupWidth);

		popup.setHeight(popupHeight);
		popup.setFocusable(true);

		// Some offset to align the popup a bit to the right, and a bit down,
		// relative to button's position.

		// Displaying the popup at the specified location, + offsets.
		// popup.showAtLocation(parent, gravity, x, y);
		popup.showAtLocation(layout, Gravity.CENTER_HORIZONTAL, 0, 0);

	}

}
