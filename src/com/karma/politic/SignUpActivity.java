package com.karma.politic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class SignUpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.new_register_layout);
	}

	public void singupButton(View v) {
		startActivity(new Intent(this, UserOTP.class));
	}

	public void resetButton(View v) {
		onBackPressed();
	}
}
