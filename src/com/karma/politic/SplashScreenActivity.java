package com.karma.politic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SplashScreenActivity extends Activity {

	private final int SPLASH_DISPLAY_LENGHT = 2500;
	ImageView iv;
	RelativeLayout l;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash_screen);

		l = (RelativeLayout) findViewById(R.id.rl1);
		iv = (ImageView) findViewById(R.id.LogoImage);
		StartAnimations();

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
				startActivity(i);
			}

		}, SPLASH_DISPLAY_LENGHT);
	}

	private void StartAnimations() {
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();

		l.clearAnimation();
		l.startAnimation(anim);

		anim = AnimationUtils.loadAnimation(this, R.anim.translate);
		anim.reset();

		iv.clearAnimation();
		iv.startAnimation(anim);

	}
}