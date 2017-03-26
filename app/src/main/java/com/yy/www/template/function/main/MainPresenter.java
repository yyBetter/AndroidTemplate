package com.yy.www.template.function.main;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.brioal.bottomtab.entity.TabEntity;
import com.yy.www.template.R;
import com.yy.www.template.base.BasePresenterImpl;
import com.yy.www.template.function.main.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyu on 2017/3/26.
 * MainPresenter
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(Context context, MainContract.View view) {
        super(context, view);
    }

    @Override
    public void onStart() {
        initBottomMenu();
    }

    private void initBottomMenu() {
        List<TabEntity> bottomList = new ArrayList<>();
        bottomList.add(new TabEntity(R.mipmap.ic_launcher, "推荐"));
        bottomList.add(new TabEntity(R.mipmap.ic_launcher, "游戏"));
        bottomList.add(new TabEntity(R.mipmap.ic_launcher, "软件"));
        bottomList.add(new TabEntity(R.mipmap.ic_launcher, "应用圈"));
        bottomList.add(new TabEntity(R.mipmap.ic_launcher, "管理"));
        mView.showBottomMenu(bottomList);
    }

    @Override
    public void onDestroy() {

    }


    @Override
    public ArrayList<Fragment> getFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        return fragments;
    }
}
