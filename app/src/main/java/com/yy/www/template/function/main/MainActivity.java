package com.yy.www.template.function.main;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.brioal.bottomtab.entity.TabEntity;
import com.brioal.bottomtab.interfaces.OnTabSelectedListener;
import com.brioal.bottomtab.view.BottomLayout;
import com.orhanobut.logger.Logger;
import com.yy.www.template.R;
import com.yy.www.template.base.BaseActivity;
import com.yy.www.template.function.main.home.adapter.MainViewPagerAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yangyu on 2017/3/23.
 * MainActivity
 */
@Route(path = "/main/activity")
public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.main_tab)
    BottomLayout mainTab;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    MainContract.Presenter mPresenter;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter(this, this);
        mPresenter.onStart();
    }

    @Override
    protected void initView() {
        initViewPager();
    }

    private void initViewPager() {
        FragmentManager manager = getSupportFragmentManager();
        viewPager.setAdapter(new MainViewPagerAdapter(manager, mPresenter.getFragment()));
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void showBottomMenu(List<TabEntity> bottomList) {
        mainTab.setList(bottomList); //设置数据源
        mainTab.setInCircleColor(R.color.colorPrimary);
        mainTab.setExCircleColor(R.color.colorPrimaryDark);
        mainTab.setNews(1, 0); //设置未读消息
        mainTab.setNews(2, 1);
        mainTab.setNews(3, 2);
        mainTab.setNews(4, 3);
        mainTab.setNews(5, 4);
        //设置Item点击事件
        mainTab.setSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int position) {
                mainTab.cleanNews(position); //清除未读消息
                Logger.d(position);
            }
        });
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }


}
