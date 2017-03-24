package com.yy.www.template.function.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yy.www.template.R;
import com.yy.www.template.utils.ActivityUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SplashFragment splashFragment = (SplashFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if (splashFragment == null) {
            splashFragment = SplashFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    splashFragment, R.id.contentFrame);
        }

        // Create the presenter
        new SplashPresenter(splashFragment);

    }
}
