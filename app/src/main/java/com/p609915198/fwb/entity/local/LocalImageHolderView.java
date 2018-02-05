package com.p609915198.fwb.entity.local;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.p609915198.basemodule.net.response.HomeAdResponse;

import static com.p609915198.basemodule.net.UrlConstant.IMG_ADDRESS;

/**
 * 广告轮播
 */
public class LocalImageHolderView implements Holder<HomeAdResponse> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, final int position, HomeAdResponse data) {
        Glide.with(context).load(IMG_ADDRESS + data.getUrl()).into(imageView);
    }
}