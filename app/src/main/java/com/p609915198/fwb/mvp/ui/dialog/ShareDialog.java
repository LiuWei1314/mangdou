package com.p609915198.fwb.mvp.ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.utils.ShareUtil;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.shaohui.bottomdialog.BottomDialog;

/**
 * Created by mark.liu on 2018-4-17.
 */
public class ShareDialog extends BottomDialog {
    @BindView(R.id.tv_wx_share) TextView mTvWxShare;
    @BindView(R.id.tv_wx_friend_share) TextView mTvWxFriendShare;
    @BindView(R.id.tv_qq_share) TextView mTvQqShare;
    @BindView(R.id.tv_qq_zon_share) TextView mTvQqZonShare;

    private Unbinder unbinder;
    private int shareType;// 1 = 文本 , 2 = 音频 ,3 = 网址
    private String imgUrl = "";
    private String musicUrl = "";
    private String title = "";
    private String description = "";
    private Activity mActivity;

    public static ShareDialog newInstance(int shareType, String title, String description, String imgUrl, String musicUrl) {
        Bundle args = new Bundle();
        args.putInt("shareType", shareType);
        if (!TextUtils.isEmpty(title)) {
            args.putString("title", title);
        }
        if (!TextUtils.isEmpty(description)) {
            args.putString("description", description);
        }
        if (!TextUtils.isEmpty(imgUrl)) {
            args.putString("imgUrl", imgUrl);
        }
        if (!TextUtils.isEmpty(musicUrl)) {
            args.putString("musicUrl", musicUrl);
        }
        ShareDialog fragment = new ShareDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_share;
    }

    @Override
    public void bindView(View v) {
        mActivity = getActivity();
        unbinder = ButterKnife.bind(this, v);

        Bundle bundle = getArguments();
        shareType = bundle.getInt("shareType");
        title = bundle.getString("title", "");
        description = bundle.getString("description", "");
        imgUrl = bundle.getString("imgUrl", "");
        musicUrl = bundle.getString("musicUrl", "");
    }

    @OnClick({R.id.tv_wx_share, R.id.tv_wx_friend_share, R.id.tv_qq_share, R.id.tv_qq_zon_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_wx_share:
                if (1 == shareType) {
                    ShareUtil.wxShareText(title, description, SendMessageToWX.Req.WXSceneSession);
                } else if (2 == shareType) {
                    ShareUtil.wxShareMusic(title, description, imgUrl, musicUrl, SendMessageToWX.Req.WXSceneSession);
                }
                dismiss();
                break;
            case R.id.tv_wx_friend_share:
                if (1 == shareType) {
                    ShareUtil.wxShareText(title, description, SendMessageToWX.Req.WXSceneTimeline);
                } else if (2 == shareType) {
                    ShareUtil.wxShareMusic(title, description, imgUrl, musicUrl, SendMessageToWX.Req.WXSceneTimeline);
                }
                dismiss();
                break;
            case R.id.tv_qq_share:
                if (1 == shareType) {
                    ShareUtil.shareQQText(mActivity, title, description, imgUrl, mIUiListener);
                } else if (2 == shareType) {
                    ShareUtil.shareQQMusic(mActivity, title, description, imgUrl, musicUrl, mIUiListener);
                }
                break;
            case R.id.tv_qq_zon_share:
                if (1 == shareType) {
                    ShareUtil.shareQQZonText(mActivity, title, description, imgUrl, mIUiListener);
                } else if (2 == shareType) {
                    ShareUtil.shareQQZonMusic(mActivity, title, description, imgUrl, musicUrl, mIUiListener);
                }
                break;
        }
    }

    private IUiListener mIUiListener = new IUiListener() {
        @Override
        public void onComplete(Object o) {
            ToastUtils.showLong("分享成功");
            dismiss();
        }

        @Override
        public void onError(UiError uiError) {
            ToastUtils.showLong("分享出错:" + uiError.errorMessage + "|" + uiError.errorCode + "|" + uiError.errorDetail);
            dismiss();
        }

        @Override
        public void onCancel() {
            ToastUtils.showLong("分享取消");
            dismiss();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
