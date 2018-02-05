package com.p609915198.fwb.mvp.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.p609915198.basemodule.base.BaseDialog;
import com.p609915198.fwb.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/4 0004.
 */
public class LogoutDialog extends BaseDialog {
    @BindView(R.id.tv_hint) TextView mTvHint;
    @BindView(R.id.tv_cancel) TextView mTvCancel;
    @BindView(R.id.tv_ok) TextView mTvOk;

    private LogoutListener mLogoutListener;

    public LogoutDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.dialog_general_settings;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_cancel, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                break;
            case R.id.tv_ok:
                if (null != mLogoutListener) {
                    mLogoutListener.logout();
                }
                break;
        }
        killMyself();
    }

    public interface LogoutListener {
        void logout();
    }

    public void setLogoutListener(LogoutListener listener) {
        this.mLogoutListener = listener;
    }
}
