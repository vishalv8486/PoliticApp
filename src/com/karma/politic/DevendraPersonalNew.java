package com.karma.politic;

import java.util.ArrayList;
import java.util.List;

import com.karma.politic.adapter.PersonalInfoGridAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class DevendraPersonalNew extends Activity {
	ImageView iv;
	LinearLayout relativeLayout;
	private List<PersonalInfoGridItem> personalInfoGridItems;
	RoundImage roundedImage;
	int currentWindowNumber;
	String currentWindowName;
	//int popupWidthTemp = 700;
	//int popupHeightTemp = 990;
	int popupWidthTemp ;
	int popupHeightTemp ;
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.devendra_person_info_layout);
		relativeLayout = (LinearLayout) findViewById(R.id.rl);
		iv = (ImageView) findViewById(R.id.imageView1);

		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		int width = displaymetrics.widthPixels;
		
		popupWidthTemp = width - 50;
		popupHeightTemp = height - 50 ;
		
		iv.setImageResource(R.drawable.devendra);
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.devendra);
		roundedImage = new RoundImage(bm);
		iv.setImageDrawable(roundedImage);

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
					// personalInfo
					currentWindowNumber = 1;
					universalPopup(R.layout.devendra_personal_details_layout);
					break;

				case 1:
					// politicalCareer
					currentWindowNumber = 2;
					universalPopup(R.layout.devendra_political_details_layout);
					break;

				case 2:
					// suggestion
					currentWindowNumber = 3;
					universalPopup(R.layout.submit_suggestion_layout);
					break;

				case 3:
					// workdetails
					currentWindowNumber = 4;
					universalPopup(R.layout.work_details_piece);
					break;

				}
			}

		});

	}

	public void universalPopup(int toPopupWindow) {

		LayoutInflater layoutInflaterTemp;

		layoutInflaterTemp = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		final View layoutTemp = layoutInflaterTemp.inflate(toPopupWindow, null);

		final PopupWindow popupTemp = new PopupWindow(DevendraPersonalNew.this);
		popupTemp.setContentView(layoutTemp);
		popupTemp.setWidth(popupWidthTemp);

		popupTemp.setHeight(popupHeightTemp);
		popupTemp.setFocusable(true);

		// popupTemp.showAtLocation(layoutTemp, Gravity.CENTER_HORIZONTAL, 0,
		// 0);
		new Handler().postDelayed(new Runnable() {

			public void run() {
				popupTemp.showAtLocation(layoutTemp, Gravity.CENTER_VERTICAL, 10,10);
			}

		}, 100L);

		if (currentWindowNumber == 3) {
			Button submitButton = (Button) layoutTemp.findViewById(R.id.submitButtonA);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Suggestion Submitted", Toast.LENGTH_LONG).show();
					popupTemp.dismiss();
				}
			});
		}

		if (currentWindowNumber == 4) {
			ImageView submitButton = (ImageView) layoutTemp.findViewById(R.id.textView5);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});
			
			ImageView submitButton2 = (ImageView) layoutTemp.findViewById(R.id.textView51);
			submitButton2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});
			
			ImageView submitButton6 = (ImageView) layoutTemp.findViewById(R.id.textView52);
			submitButton6.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});
			
			ImageView submitButton3 = (ImageView) layoutTemp.findViewById(R.id.textView54);
			submitButton3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});
			
			ImageView submitButton4 = (ImageView) layoutTemp.findViewById(R.id.textView53);
			submitButton4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});

		}

		if (currentWindowNumber == 5) {

			Button submitButton = (Button) layoutTemp.findViewById(R.id.feedbackButton);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 6;
					universalPopup(R.layout.submit_work_feedback_layout);
				}
			});

			Button submitButton2 = (Button) layoutTemp.findViewById(R.id.ratingButton);
			submitButton2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 7;
					universalPopup(R.layout.get_rating_solo);
				}
			});
		}

		if (currentWindowNumber == 6) {
			Button submitButton = (Button) layoutTemp.findViewById(R.id.feedButton2);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Feedback Submitted", Toast.LENGTH_LONG).show();
					popupTemp.dismiss();
				}
			});
		}

		if (currentWindowNumber == 7) {
			Button submitButton = (Button) layoutTemp.findViewById(R.id.ratingSubmit);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Rating Submitted", Toast.LENGTH_LONG).show();
					popupTemp.dismiss();
				}
			});
		}
	}

}
