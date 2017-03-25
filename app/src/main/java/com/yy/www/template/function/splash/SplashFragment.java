package com.yy.www.template.function.splash;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.www.template.R;

/**
 * Created by yangyu on 2017/3/23.
 */

public class SplashFragment extends Fragment implements SplashContract.View {

    SplashContract.Presenter mPresenter;

    public static SplashFragment newInstance() {
//        Bundle arguments = new Bundle();
//        arguments.putString(ARGUMENT_TASK_ID, taskId);
        SplashFragment fragment = new SplashFragment();
//        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_splash, container, false);
        ImageView iv_splash = (ImageView) root.findViewById(R.id.iv_splash);
        iv_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/main/activity").navigation();
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new SplashPresenter(getActivity(), this);
        mPresenter.onStart();
    }
}
