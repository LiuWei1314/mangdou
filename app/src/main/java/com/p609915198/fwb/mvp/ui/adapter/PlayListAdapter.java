package com.p609915198.fwb.mvp.ui.adapter;

import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.fwb.R;
import com.zhy.autolayout.utils.AutoUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/12/27 0027.
 */
public class PlayListAdapter extends BaseQuickAdapter<Audio, BaseViewHolder> {

    public PlayListAdapter(@Nullable List<Audio> data) {
        super(R.layout.item_play_list, data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        AutoUtils.auto(view);// 屏幕适配
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, Audio item) {
        helper.setText(R.id.tv_title, item.getAudio_name().replace(".mp3", ""))
              .setText(R.id.tv_time, item.getAudio_length())
              .addOnClickListener(R.id.rl);

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), item.getAudio_name());
        if (file.exists()) {
            helper.setImageResource(R.id.iv_download, R.mipmap.ic_download_success);
            helper.getView(R.id.iv_download).setClickable(false);
        } else {
            helper.getView(R.id.iv_download).setOnClickListener(
                    v -> {
                        ToastUtils.showShort("开始下载！");
                        helper.getView(R.id.iv_download).setClickable(false);
                        OkHttpUtils.get()
                                   .url(UrlConstant.AUDIO_ADDRESS + item.getAudio_path().replace("\\", ""))
                                   .build()
                                   .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), item.getAudio_name()) {
                                       @Override
                                       public void onError(Call call, Exception e, int id) {
                                           ToastUtils.showShort(item.getAudio_name() + "下载失败！" + e.getMessage());
                                           helper.getView(R.id.iv_download).setClickable(true);
                                       }

                                       @Override
                                       public void onResponse(File response, int id) {
                                           LogUtils.e(TAG, "onResponse :" + response.getAbsolutePath());
                                           ToastUtils.showShort(item.getAudio_name() + "下载成功！");

                                           helper.setImageResource(R.id.rl, R.mipmap.ic_download_success);
                                           helper.getView(R.id.iv_download).setClickable(false);
                                       }
                                   });
                    }
            );
        }
    }
}
