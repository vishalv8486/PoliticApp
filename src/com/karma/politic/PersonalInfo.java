package com.karma.politic;

import java.util.ArrayList;
import java.util.List;

import com.karma.politic.adapter.PersonalInfoGridAdapter;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class PersonalInfo extends Activity {
	ImageView iv;
	LinearLayout relativeLayout;
	private List<PersonalInfoGridItem> personalInfoGridItems;
	RoundImage roundedImage;

	@SuppressWarnings("deprecation")
	public void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.person_info_layout);
		relativeLayout = (LinearLayout) findViewById(R.id.rl);
		iv = (ImageView) findViewById(R.id.imageView1);

		Bundle b = getIntent().getExtras();
		String candidate = b.getString("candidate");
		if (candidate.equals("devendra")) {
			iv.setImageResource(R.drawable.devendra);
			Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.devendra);
			roundedImage = new RoundImage(bm);
			iv.setImageDrawable(roundedImage);
		} else if (candidate.equals("vinod")) {
			iv.setImageResource(R.drawable.vtavade);
			Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.vtavade);
			roundedImage = new RoundImage(bm);
			iv.setImageDrawable(roundedImage);
		}

		personalInfoGridItems = new ArrayList<PersonalInfoGridItem>();
		Resources resources = getResources();

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.PersonalInfo),
				(resources.getDrawable(R.drawable.personal))));

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.PoliticalCareer),
				(resources.getDrawable(R.drawable.politicalprofile))));
		// chk msgs bro

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.Suggestion),
				(resources.getDrawable(R.drawable.suggestion))));
		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.WorkDetail),
				(resources.getDrawable(R.drawable.workdetailsicon))));

		GridView gridView = (GridView) findViewById(R.id.gridView);
		// ListView listView = (ListView) findViewById(R.id.grid);
		PersonalInfoGridAdapter adapter = new PersonalInfoGridAdapter(this, personalInfoGridItems);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				switch (position) {
				case 0:
					showCustomWindow(1); // personalInfo
					break;

				case 1:
					showCustomWindow(2); // politicalCareer
					break;

				case 2:
					showCustomWindow(3); // suggestion
					break;

				case 3:
					showCustomWindow(5); // workdetails
					break;

				}
			}

		});

	}

	LinearLayout viewGroup;
	LayoutInflater layoutInflater;
	View layout;
	PopupWindow popupWindow;

	public void showCustomWindow(int window) {

		int popupWidth = 700;
		int popupHeight = 990;

		// int popupWidth = WindowManager.LayoutParams.MATCH_PARENT;
		// int popupHeight = WindowManager.LayoutParams.MATCH_PARENT;

		switch (window) {
		case 1:

			layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = layoutInflater.inflate(R.layout.devendra_personal_details_layout, null);

			break;
		case 2:

			layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = layoutInflater.inflate(R.layout.devendra_political_details_layout, null);

			break;
		case 3:

			layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = layoutInflater.inflate(R.layout.submit_suggestion_layout, null);

			break;
		case 5:

			layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = layoutInflater.inflate(R.layout.work_details_piece, null);

			break;
			
		case 6:

			layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = layoutInflater.inflate(R.layout.work_details_layout, null);

			break;
		}
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
	
	public void showDetailsButton(View v) {
		showCustomWindow(6);
		// startActivity(new Intent(this, WorkDetailsInfoActivity.class));
	}
}
