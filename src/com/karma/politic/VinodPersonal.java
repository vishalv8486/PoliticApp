package com.karma.politic;

import java.util.ArrayList;
import java.util.List;

import com.karma.politic.adapter.PersonalInfoGridAdapter;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class VinodPersonal extends Activity {
	ImageView iv, iv_fbcircle, iv_twitcircle, iv_gpluscircle;
	LinearLayout relativeLayout;
	private List<PersonalInfoGridItem> personalInfoGridItems;
	RoundImage roundedImage, roundedImage1, roundedImage2, roundedImage3;
	int currentWindowNumber;
	String currentWindowName;
	// int popupWidthTemp = 700;
	// int popupHeightTemp = 990;
	int popupWidthTemp;
	int popupHeightTemp;

	@SuppressWarnings("deprecation")
	public void onCreate(Bundle bundle) {

		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.vinod_person_info_layout2);

		relativeLayout = (LinearLayout) findViewById(R.id.rl);
		iv = (ImageView) findViewById(R.id.imageView1);
		iv_fbcircle = (ImageView) findViewById(R.id.imageView2);
		iv_twitcircle = (ImageView) findViewById(R.id.ImageView011);
		iv_gpluscircle = (ImageView) findViewById(R.id.imageView3);

		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int height = displaymetrics.heightPixels;
		int width = displaymetrics.widthPixels;

		popupWidthTemp = width - 50;
		popupHeightTemp = height - 50;

		iv.setImageResource(R.drawable.vtavade);
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.vtavade);
		roundedImage = new RoundImage(bm);
		iv.setImageDrawable(roundedImage);

		iv_fbcircle.setImageResource(R.drawable.fbcircle);
		Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.fbcircle);
		roundedImage1 = new RoundImage(bm1);
		iv_fbcircle.setImageDrawable(roundedImage1);

		iv_twitcircle.setImageResource(R.drawable.twicircle);
		Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.twicircle);
		roundedImage2 = new RoundImage(bm2);
		iv_twitcircle.setImageDrawable(roundedImage2);

		iv_gpluscircle.setImageResource(R.drawable.gcircletwo);
		Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.gcircletwo);
		roundedImage3 = new RoundImage(bm3);
		iv_gpluscircle.setImageDrawable(roundedImage3);

		iv_fbcircle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				currentWindowNumber = 107;
				universalPopup(R.layout.webview_layout);
			}
		});

		iv_twitcircle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				currentWindowNumber = 108;
				universalPopup(R.layout.webview_layout);
			}
		});

		personalInfoGridItems = new ArrayList<PersonalInfoGridItem>();
		Resources resources = getResources();

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.PersonalInfo),
				(resources.getDrawable(R.drawable.personal))));

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.PoliticalCareer),
				(resources.getDrawable(R.drawable.politicalprofile))));

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.Suggestion),
				(resources.getDrawable(R.drawable.suggestion))));

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.WorkDetail),
				(resources.getDrawable(R.drawable.work_details))));

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.Appointments),
				(resources.getDrawable(R.drawable.appoientmets_three))));

		personalInfoGridItems.add(new PersonalInfoGridItem(getString(R.string.Complaints),
				(resources.getDrawable(R.drawable.compaints))));

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
					universalPopup(R.layout.vinod_personal_details_layout2);
					break;

				case 1:
					// politicalCareer
					currentWindowNumber = 2;
					universalPopup(R.layout.vinod_political_details_layout2);
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

				case 4:
					// appointment
					currentWindowNumber = 105;
					universalPopup(R.layout.appointment_layout);
					break;

				case 5:
					// complaints
					currentWindowNumber = 106;
					universalPopup(R.layout.submit_complaint_details);
					break;
				}
			}

		});

	}

	public void universalPopup(int toPopupWindow) {

		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

		lp.width = popupWidthTemp;
		lp.height = popupHeightTemp;

		final Dialog dialog = new Dialog(VinodPersonal.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		dialog.setContentView(toPopupWindow);
		dialog.getWindow().setAttributes(lp);
		dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

		dialog.show();

		if (currentWindowNumber == 3) {
			Button submitButton = (Button) dialog.findViewById(R.id.submitButtonA);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Suggestion Submitted", Toast.LENGTH_LONG).show();
					dialog.dismiss();
				}
			});
		}

		if (currentWindowNumber == 4) {

			ImageView submitButton = (ImageView) dialog.findViewById(R.id.textView5);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});

			ImageView submitButton53 = (ImageView) dialog.findViewById(R.id.textView53);
			submitButton53.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});

			ImageView submitButton54 = (ImageView) dialog.findViewById(R.id.textView54);
			submitButton54.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});

			ImageView submitButton55 = (ImageView) dialog.findViewById(R.id.textView55);
			submitButton55.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});

			ImageView submitButton56 = (ImageView) dialog.findViewById(R.id.textView56);
			submitButton56.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 5;
					universalPopup(R.layout.work_details_layout);
				}
			});

		}

		if (currentWindowNumber == 5) {

			Button submitButton = (Button) dialog.findViewById(R.id.feedbackButton);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 6;
					universalPopup(R.layout.submit_work_feedback_layout);
				}
			});

			Button submitButton2 = (Button) dialog.findViewById(R.id.ratingButton);
			submitButton2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					currentWindowNumber = 7;
					universalPopup(R.layout.get_rating_solo);
				}
			});
		}

		if (currentWindowNumber == 6) {
			Button submitButton = (Button) dialog.findViewById(R.id.feedButton2);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Feedback Submitted", Toast.LENGTH_LONG).show();
					dialog.dismiss();
				}
			});
		}

		if (currentWindowNumber == 7) {
			Button submitButton = (Button) dialog.findViewById(R.id.ratingSubmit);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Rating Submitted", Toast.LENGTH_LONG).show();
					dialog.dismiss();
				}
			});
		}

		if (currentWindowNumber == 105) {
			Button submitButton = (Button) dialog.findViewById(R.id.submitButtonA);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(),
							"Appointment Submitted , \n  We Will reach to you shortly to confirm Appointment Schedule",
							Toast.LENGTH_LONG).show();
					dialog.dismiss();
				}
			});
		}

		if (currentWindowNumber == 106) {
			Button submitButton = (Button) dialog.findViewById(R.id.submitButtonA);
			submitButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Complaint Submitted", Toast.LENGTH_LONG).show();
					dialog.dismiss();
				}
			});
		}

		if (currentWindowNumber == 107) {
			WebView mWebview = (WebView) dialog.findViewById(R.id.webView1);
			mWebview.getSettings().setLoadsImagesAutomatically(true);
			mWebview.getSettings().setJavaScriptEnabled(true);
			mWebview.setWebViewClient(new WebViewClient());
			mWebview.loadUrl("https://www.facebook.com/tawdevinod");

		}

		if (currentWindowNumber == 108) {
			WebView mWebview = (WebView) dialog.findViewById(R.id.webView1);
			mWebview.getSettings().setLoadsImagesAutomatically(true);
			mWebview.getSettings().setJavaScriptEnabled(true);
			mWebview.setWebViewClient(new WebViewClient());
			mWebview.loadUrl("https://twitter.com/TawdeVinod");

		}
	}

}
