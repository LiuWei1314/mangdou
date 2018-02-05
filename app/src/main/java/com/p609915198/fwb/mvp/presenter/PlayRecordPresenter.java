package com.p609915198.fwb.mvp.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.request.GetPlayRecordRequest;
import com.p609915198.basemodule.net.response.GetPlayRecordResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.R;
import com.p609915198.fwb.app.AppConfig;
import com.p609915198.fwb.mvp.contract.PlayRecordContract;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/7.
 */
@ActivityScope
public class PlayRecordPresenter extends BasePresenter<PlayRecordContract.Model, PlayRecordContract.View> {

    @Inject
    public PlayRecordPresenter(PlayRecordContract.Model model, PlayRecordContract.View rootView) {
        super(model, rootView);
    }

    public void getPlayRecordData() {
        GetPlayRecordRequest request = new GetPlayRecordRequest();
        request.setUser_id(AppConfig.getUserId());
        mModel.getPlayRecord(request)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<GetPlayRecordResponse>>() {
                          @Override
                          protected void onNext(List<GetPlayRecordResponse> getPlayRecordResponses) {
                              if (null != getPlayRecordResponses) {
                                  PlayRecordAdapter adapter = new PlayRecordAdapter(getPlayRecordResponses);
                                  mRootView.setAdapter(adapter);
                              }
                          }
                      },
                      (Context) mRootView, true
              ));
    }

    public class PlayRecordAdapter extends BaseQuickAdapter<GetPlayRecordResponse, BaseViewHolder> {
        @Override
        protected BaseViewHolder createBaseViewHolder(View view) {
            AutoUtils.auto(view);// 屏幕适配
            return super.createBaseViewHolder(view);
        }

        public PlayRecordAdapter(@Nullable List<GetPlayRecordResponse> data) {
            super(R.layout.item_play_record, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, GetPlayRecordResponse item) {
//            helper.setText(R.id.tv_menu1, item.getAudio_name())
//                    .setText(R.id.tv_menu2, item.getDatetime());
        }
    }
}
