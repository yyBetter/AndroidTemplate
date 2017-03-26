package com.yy.www.template.function.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yy.www.template.R;
import com.yy.www.template.function.main.home.bean.ItemBanner;
import com.yy.www.template.function.main.home.bean.ItemServer;
import com.yy.www.template.function.main.home.itembinder.ItemBannerBinder;
import com.yy.www.template.function.main.home.itembinder.ItemServerBinder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by yangyu on 2017/3/26.
 * HomeFragment
 */

public class HomeFragment extends Fragment implements HomeContact.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    HomeContact.Presenter mPresenter;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        initPresenter();
        return root;
    }


    private void initPresenter() {
        mPresenter = new HomePresenterImpl(getActivity(), this);
        mPresenter.onStart();
    }

    @Override
    public void showMenus(List items) {
        MultiTypeAdapter adapter = new MultiTypeAdapter();
        adapter.register(ItemBanner.class, new ItemBannerBinder());
        adapter.register(ItemServer.class, new ItemServerBinder());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
