package com.android.placenotification.ui.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.android.placenotification.R;
import com.android.placenotification.ui.activity.base.BaseActivity;
import com.android.placenotification.ui.activity.dashboard.DashboardActivity;
import com.android.placenotification.ui.activity.login.LoginActivity;
import com.android.placenotification.utilities.PreferenceConnector;

import static com.android.placenotification.utilities.Constants.LOGIN_STATUS;
import static com.android.placenotification.utilities.Constants.SPLASH_DELAY_TIME;

/**
 * Created by Gufran on 10/5/2017.
 */

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        navigate();
    }

    private void navigate() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (PreferenceConnector.readBoolean(SplashActivity.this, LOGIN_STATUS, false)) {
                    Intent loginIntent = new Intent(SplashActivity.this, DashboardActivity.class);
                    startActivity(loginIntent);
                } else {
                    Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                }
                finish();
            }
        }, SPLASH_DELAY_TIME);


    }
}
