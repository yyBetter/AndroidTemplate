package com.yy.www.template.base;

import android.content.Context;

/**
 * Created by yangyu on 2017/3/26.
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter {

    public Context mContext;

    public V mView;

    public BasePresenterImpl(Context mContext, V mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }
}
