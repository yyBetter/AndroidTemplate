package com.yy.www.template.function.main.home.itembinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yy.www.template.R;
import com.yy.www.template.function.main.home.bean.CommonItem;
import com.yy.www.template.function.main.home.bean.ItemServer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by yangyu on 2017/3/26.
 */

public class ItemServerBinder extends ItemViewBinder<ItemServer, ItemServerBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_server, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ItemServer itemServer) {
        Context context = holder.itemView.getContext();


    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.innerRecyclerView)
        RecyclerView innerRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            initRecyclerView(itemView.getContext());
        }

        private void initRecyclerView(Context context) {
            MultiTypeAdapter adapter = new MultiTypeAdapter();
            adapter.register(CommonItem.class, new ItemCommonBinder());
            innerRecyclerView.setLayoutManager(new GridLayoutManager(context, 4));
            innerRecyclerView.setAdapter(adapter);
            List<Object> items = new ArrayList<>();
            items.add(new CommonItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490540148008&di=1c58cc4e499364f84454dc12f0e16545&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F472309f7905298222740e887d2ca7bcb0a46d407.jpg", "title1"));
            items.add(new CommonItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490540148008&di=1c58cc4e499364f84454dc12f0e16545&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F472309f7905298222740e887d2ca7bcb0a46d407.jpg", "title2"));
            items.add(new CommonItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490540148008&di=1c58cc4e499364f84454dc12f0e16545&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F472309f7905298222740e887d2ca7bcb0a46d407.jpg", "title3"));
            items.add(new CommonItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490540148008&di=1c58cc4e499364f84454dc12f0e16545&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F472309f7905298222740e887d2ca7bcb0a46d407.jpg", "title3"));
            items.add(new CommonItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490540148008&di=1c58cc4e499364f84454dc12f0e16545&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F472309f7905298222740e887d2ca7bcb0a46d407.jpg", "title3"));
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
    }
}
