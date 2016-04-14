package com.karma.politic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class UserOTP extends Activity {

	EditText getMobileNumber;
	EditText getCustomerName;
	String mobile_no, customer_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.user_otp);

		getCustomerName = (EditText) findViewById(R.id.customerName);
		getMobileNumber = (EditText) findViewById(R.id.mobileNumber);

		getCustomerName.setPaintFlags(getCustomerName.getPaintFlags()
				| Paint.UNDERLINE_TEXT_FLAG);
		getMobileNumber.setPaintFlags(getMobileNumber.getPaintFlags()
				| Paint.UNDERLINE_TEXT_FLAG);

	}

	public void sendMobileNumber(View view) {

		customer_name = getCustomerName.getText().toString();
		mobile_no = getMobileNumber.getText().toString();

		if (mobile_no != null && mobile_no.length() == 10) {
			Intent intent = new Intent(UserOTP.this, OtpVerification.class);
			intent.putExtra("cust_name", customer_name);
			intent.putExtra("mobile_No", mobile_no);
			startActivity(intent);

		} else {
			Toast.makeText(
					UserOTP.this,
					customer_name
							+ " please Enter your Name & valid Mobile number...",
					Toast.LENGTH_LONG).show();
		}
	}
}
