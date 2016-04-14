package com.karma.politic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OtpVerification extends Activity {

	EditText verifyCode;
	String getVerifyCode;
	String getCustomerName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.otp_verification);

		savedInstanceState = getIntent().getExtras();
		getVerifyCode = savedInstanceState.getString("mobile_No");
		getCustomerName = savedInstanceState.getString("cust_name");

		Toast.makeText(OtpVerification.this, "mobile_no" + getVerifyCode,
				Toast.LENGTH_SHORT).show();

		verifyCode = (EditText) findViewById(R.id.verifyCode);


	}

	public void checkVerifyCode(View view) {
		if (verifyCode.getText().toString().equals(getVerifyCode)) {
			Intent intent = new Intent(OtpVerification.this, MainActivity.class);
			startActivity(intent);
		}

		else {

			Toast.makeText(OtpVerification.this, "please Enter valid code",
					Toast.LENGTH_LONG).show();
		}

	}

	public void resendVerifyCode(View view) {
		Intent intent = new Intent(OtpVerification.this, UserOTP.class);
		startActivity(intent);
		finish();

	}

}
