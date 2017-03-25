package com.yy.www.template.function.main;

import com.brioal.bottomtab.entity.TabEntity;
import com.yy.www.template.base.BasePresenter;
import com.yy.www.template.base.BaseView;

import java.util.List;

/**
 * Created by yangyu on 2017/3/26.
 */

public class MainContract {

    interface View extends BaseView {

        void showBottomMenu(List<TabEntity> bottomList);
    }

    interface Presenter extends BasePresenter{

    }
}
