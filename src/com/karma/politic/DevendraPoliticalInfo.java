package com.karma.politic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class DevendraPoliticalInfo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.devendra_political_details_layout);
	}
}