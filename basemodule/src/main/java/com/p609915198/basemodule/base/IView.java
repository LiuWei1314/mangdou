package com.p609915198.basemodule.base;

import android.content.Intent;

/**
 * Created by mark on 2017/05/08.
 */
public interface IView {

    void launchActivity(Intent intent);

    void killMyself();

    void showToast(String msg);

    void showToast(int resId);
}
