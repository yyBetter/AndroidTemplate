package com.yy.www.template.function.main.home.itembinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yy.www.template.R;
import com.yy.www.template.function.main.home.bean.ItemBanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by yangyu on 2017/3/26.
 */

public class ItemBannerBinder extends ItemViewBinder<ItemBanner, ItemBannerBinder.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_banner, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ItemBanner itemBanner) {
        Context context = holder.itemView.getContext();
        Picasso.with(context)
                .load(itemBanner.bannerBeen.get(0).getImg())
                .into(holder.ivBanner);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_Banner)
        ImageView ivBanner;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
