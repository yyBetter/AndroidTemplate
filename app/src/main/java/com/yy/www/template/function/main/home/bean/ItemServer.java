package com.yy.www.template.function.main.home.bean;

import java.util.List;

import me.drakeet.multitype.Item;

/**
 * Created by yangyu on 2017/3/26.
 */

public class ItemServer implements Item {
    public List<HomeBean.DataBean.ServerBean> serverBeen;

    public ItemServer(List<HomeBean.DataBean.ServerBean> serverBeen) {
        this.serverBeen = serverBeen;
    }
}
