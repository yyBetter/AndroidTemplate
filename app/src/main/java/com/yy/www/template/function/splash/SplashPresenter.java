package com.yy.www.template.function.splash;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by yangyu on 2017/3/23.
 */

public class SplashPresenter implements SplashContract.Presenter {

    SplashContract.View view;


    public SplashPresenter(SplashContract.View view) {
        this.view = checkNotNull(view,"SplashContract.View not be null");
        view.setPresenter(this);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }
}
