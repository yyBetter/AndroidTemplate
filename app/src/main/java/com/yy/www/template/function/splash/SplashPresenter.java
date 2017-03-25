package com.yy.www.template.function.splash;

import android.content.Context;

import com.yy.www.template.base.BasePresenterImpl;

/**
 * Created by yangyu on 2017/3/23.
 */

public class SplashPresenter extends BasePresenterImpl<SplashContract.View> implements SplashContract.Presenter {

    public SplashPresenter(Context mContext, SplashContract.View mView) {
        super(mContext, mView);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }
}
