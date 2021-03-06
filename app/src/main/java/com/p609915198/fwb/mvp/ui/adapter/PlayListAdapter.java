package com.p609915198.fwb.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSONObject;
import com.arialyy.annotations.Download;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadTask;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BaseAdapter;
import com.p609915198.basemodule.net.UrlConstant;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.fwb.R;
import com.p609915198.fwb.utils.DoubleUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.p609915198.basemodule.net.UrlConstant.DOWNLOAD_AUDIO_ADDRESS;

/**
 * Created by Administrator on 2017/12/27 0027.
 */
public class PlayListAdapter extends BaseAdapter<Audio, BaseViewHolder> {
    private BuyListener mBuyListener;

    public PlayListAdapter(@Nullable List<Audio> data) {
        super(R.layout.item_play_list, data);
        Aria.download(this).register();
    }

    @Override
    protected void convert(BaseViewHolder helper, Audio item) {
        helper.setText(R.id.tv_title, item.getAudio_name().replace(".mp3", ""))
              .setText(R.id.tv_time, TimeUtils.millis2String(TimeUtils.string2Millis(item.getAudio_length(), new SimpleDateFormat("HH:mm:ss")), new SimpleDateFormat("mm:ss")))
              .addOnClickListener(R.id.rl);

        if ("1".equals(item.getAudio_free())) {
            // 免费
            helper.setText(R.id.tv_listen_try, "可试听");
            helper.getView(R.id.iv_download).setOnClickListener(
                    v -> {
                        ToastUtils.showShort("开始下载！");
                        helper.getView(R.id.iv_download).setClickable(false);
                        Aria.download(this)
                            .load(UrlConstant.AUDIO_ADDRESS + item.getAudio_path().replace("\\", ""))     //读取下载地址
                            .setFilePath(DOWNLOAD_AUDIO_ADDRESS + "/" + item.getAudio_name()) //设置文件保存的完整路径
                            .setExtendField(JSONObject.toJSONString(item))
                            .start();   //启动下载
                    }
            );
        } else {
            // 收费
            helper.setText(R.id.tv_listen_try, DoubleUtils.D2S(Double.valueOf(item.getPrice())) + "忙豆");
            if (item.getIs_buy() == 0) {
                // 没买
                helper.getView(R.id.iv_download).setOnClickListener(
                        v -> {
                            ToastUtils.showShort("请先购买！");
                            if (null != mBuyListener) {
                                mBuyListener.buy(item);
                            }
                        }
                );
            } else {
                helper.setText(R.id.tv_listen_try, DoubleUtils.D2S(Double.valueOf(item.getPrice())) + "忙豆(已购买)");
                // 已买
                File file = new File(DOWNLOAD_AUDIO_ADDRESS, item.getAudio_name());
                if (file.exists()) {
                    helper.setImageResource(R.id.iv_download, R.mipmap.ic_download_success);
                    helper.getView(R.id.iv_download).setClickable(false);
                } else {
                    helper.getView(R.id.iv_download).setOnClickListener(
                            v -> {
                                ToastUtils.showShort("开始下载！");
                                helper.getView(R.id.iv_download).setClickable(false);
                                Aria.download(this)
                                    .load(UrlConstant.AUDIO_ADDRESS + item.getAudio_path().replace("\\", ""))     //读取下载地址
                                    .setFilePath(DOWNLOAD_AUDIO_ADDRESS + "/" + item.getAudio_name()) //设置文件保存的完整路径
                                    .setExtendField(JSONObject.toJSONString(item))
                                    .start();   //启动下载
                            }
                    );
                }
            }
        }
    }

    public void setListener(BuyListener listener) {
        mBuyListener = listener;
    }

    public interface BuyListener {
        void buy(Audio audio);
    }

    @Download.onTaskComplete
    void taskComplete(DownloadTask task) {
        notifyDataSetChanged();
    }
}
