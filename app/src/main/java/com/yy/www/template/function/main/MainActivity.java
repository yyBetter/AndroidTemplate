package com.yy.www.template.function.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yy.www.template.R;
import com.yy.www.template.base.BaseActivity;

/**
 * Created by yangyu on 2017/3/23.
 */
@Route(path = "/main/activity")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
