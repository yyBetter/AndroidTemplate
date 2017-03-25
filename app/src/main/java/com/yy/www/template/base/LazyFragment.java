package com.yy.www.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class LazyFragment extends BaseFragment {

    /**
     * 标记已加载完成，保证懒加载只能加载一次
     */
    private boolean hasLoaded = false;
    /**
     * 标记Fragment是否已经onCreate
     */
    private boolean isCreated = false;
    /**
     * 界面对于用户是否可见
     */
    private boolean isVisibleToUser = false;

    /**
     * 这个方法是实现了基类的抽象方法，你可以把它当成和OnCreate()方法等价
     */


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isCreated = true;//注：关键步骤
        lazyInit();
    }

    /**
     * 监听界面是否展示给用户，实现懒加载
     * 这个方法也是网上的一些方法用的最多的一个，我的思路也是这个，不过把整体思路完善了一下
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;//注：关键步骤
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    /**
     * 懒加载方法，获取数据什么的放到这边来使用，在切换到这个界面时才进行网络请求
     */
    private void lazyInit() {
        //如果该界面不对用户显示、已经加载、fragment还没有创建，
        //三种情况任意一种，不获取数据
        if (!isVisibleToUser || hasLoaded || !isCreated) {
            return;
        }
        lazyInit();
        hasLoaded = true;//注：关键步骤，确保数据只加载一次
    }

    /**
     * 子类必须实现的方法，这个方法里面的操作都是需要懒加载的
     */
    public abstract void lazyLoad();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreated = false;
        hasLoaded = false;
    }
}