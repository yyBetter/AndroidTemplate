package com.yy.www.template.function.main.home;

import android.content.Context;

import com.yy.www.template.base.BasePresenterImpl;
import com.yy.www.template.function.main.home.bean.HomeBean;
import com.yy.www.template.function.main.home.bean.ItemBanner;
import com.yy.www.template.function.main.home.bean.ItemServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyu on 2017/3/26.
 * homePresenter
 */

public class HomePresenterImpl extends BasePresenterImpl<HomeContact.View> implements HomeContact.Presenter {


    public HomePresenterImpl(Context mContext, HomeContact.View mView) {
        super(mContext, mView);
    }

    @Override
    public void onStart() {
        super.onStart();
        mockData();
    }

    /**
     * mock 数据
     */
    private void mockData() {
        HomeBean bean = new HomeBean();
        bean.setCode("200");
        bean.setData(getData());
        bean.setMsg("");
        convertMockData2ListData(bean);
    }

    /**
     * 转换数据
     *
     * @param bean bean
     */
    private void convertMockData2ListData(HomeBean bean) {
        List items = new ArrayList<>();
        items.add(new ItemBanner(bean.getData().getBanner()));
        items.add(new ItemServer(bean.getData().getServer()));
        mView.showMenus(items);
    }

    private HomeBean.DataBean getData() {
        HomeBean.DataBean dataBean = new HomeBean.DataBean();
        dataBean.setBanner(getBannerList());
        dataBean.setServer(getServerList());
        return dataBean;
    }

    private List<HomeBean.DataBean.BannerBean> getBannerList() {
        List<HomeBean.DataBean.BannerBean> bannerList = new ArrayList<>();
        HomeBean.DataBean.BannerBean bannerBean = new HomeBean.DataBean.BannerBean();
        bannerBean.setCompany_id("");
        bannerBean.setFlag("");
        bannerBean.setId("");
        bannerBean.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491129395&di=f2e05234b6094d936b787de746f531ee&imgtype=jpg&er=1&src=http%3A%2F%2Fs9.rr.itc.cn%2Fr%2FwapChange%2F20165_24_17%2Fa3cb7m0847284147855.jpg");
        bannerBean.setTitle("title");
        bannerBean.setUrl("http://www.baidu.com");
        bannerList.add(bannerBean);
        bannerList.add(bannerBean);
        bannerList.add(bannerBean);
        return bannerList;
    }

    private List<HomeBean.DataBean.ServerBean> getServerList() {
        List<HomeBean.DataBean.ServerBean> serverList = new ArrayList<>();
        HomeBean.DataBean.ServerBean serverBean = new HomeBean.DataBean.ServerBean();
        serverBean.setUrl("");
        serverBean.setLogo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490534676210&di=21d8f12d2b8cbc144c8aafc868c63d97&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F0eb30f2442a7d9334f268ca9a84bd11372f00159.jpg");
        serverBean.setServer_name("name");
        serverList.add(serverBean);
        serverList.add(serverBean);
        serverList.add(serverBean);
        serverList.add(serverBean);
        serverList.add(serverBean);
        serverList.add(serverBean);
        return serverList;
    }

}
