package com.yy.www.template.function.main.home;

import com.yy.www.template.base.BasePresenter;
import com.yy.www.template.base.BaseView;

import java.util.List;

import me.drakeet.multitype.Item;

/**
 * Created by yangyu on 2017/3/26.
 */

public interface HomeContact {
    interface View extends BaseView {

        void showMenus(List<Item> items);
    }

    interface Presenter extends BasePresenter {

    }
}
