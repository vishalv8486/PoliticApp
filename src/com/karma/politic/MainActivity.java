package com.karma.politic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText user, pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_two);
		user = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
		user.setText("");
		pass.setText("");
		/*
		 * imageView1 = (ImageView) findViewById(R.id.imageView1); Bitmap bm =
		 * BitmapFactory.decodeResource(getResources(),R.drawable.shahrukh);
		 * roundedImage = new RoundImage(bm);
		 * imageView1.setImageDrawable(roundedImage);
		 */
	}

	public void loginButton(View v) {

		String un, ps;
		un = user.getText().toString();
		ps = pass.getText().toString();

		String checkStr = un + "123";
		if (ps.equals(checkStr)) {
			startActivity(new Intent(this, CandidateSelection.class));
		} else {
			Toast.makeText(this, "Incorrect Username Or Password", Toast.LENGTH_LONG).show();
			user.setText("");
			pass.setText("");
		}
	}

	public void signupButton(View v) {
		startActivity(new Intent(this, SignUpActivity.class));
	}
}
