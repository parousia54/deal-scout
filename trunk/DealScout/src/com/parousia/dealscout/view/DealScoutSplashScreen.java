package com.parousia.dealscout.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.parousia.dealscout.R;

public class DealScoutSplashScreen extends DealScoutScreen {

	private static String LOGTAG = "SplashScreen";
	protected boolean _active = true;
	protected int _splashTime = 5000; // time to display the splash screen in ms

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		// thread for displaying the SplashScreen
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (_active && (waited < _splashTime)) {
						sleep(100);
						if (_active) {
							waited += 100;
						}
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					finish();
					goNext();
					stop();
				}
			}
		};
		splashTread.start();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN
				|| event.getAction() == MotionEvent.ACTION_UP) {
			_active = false;
		}
		return true;
	}

	protected void goNext() {
		Intent intent = new Intent(this, DealScoutMenuScreen.class);
		startActivity(intent);

	}
}
