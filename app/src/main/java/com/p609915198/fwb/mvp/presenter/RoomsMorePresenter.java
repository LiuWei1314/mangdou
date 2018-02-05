package com.p609915198.fwb.mvp.presenter;

import android.content.Intent;
import android.text.TextUtils;

import com.p609915198.basemodule.base.BasePresenter;
import com.p609915198.basemodule.di.scope.ActivityScope;
import com.p609915198.basemodule.net.ApiException;
import com.p609915198.basemodule.net.HttpResult;
import com.p609915198.basemodule.net.ProgressSubscriber;
import com.p609915198.basemodule.net.SubscriberOnNextListener;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.basemodule.utils.RxUtils;
import com.p609915198.fwb.mvp.contract.RoomsMoreContract;
import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;
import com.p609915198.fwb.mvp.ui.adapter.RoomsMoreAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/11/9.
 */
@ActivityScope
public class RoomsMorePresenter extends BasePresenter<RoomsMoreContract.Model, RoomsMoreContract.View> {
    private RoomsMoreAdapter adapter;

    @Inject
    public RoomsMorePresenter(RoomsMoreContract.Model model, RoomsMoreContract.View rootView,
                              RoomsMoreAdapter adapter) {
        super(model, rootView);
        this.adapter = adapter;
    }

    public void initData(String labelId) {
        mModel.roomsMore(labelId)
              .compose(RxUtils.bindToLifecycle(mRootView))
              .map(new Function<HttpResult<List<RoomsMoreResponse>>, List<RoomsMoreResponse>>() {
                  @Override
                  public List<RoomsMoreResponse> apply(HttpResult<List<RoomsMoreResponse>> listHttpResult) throws Exception {
                      if (listHttpResult.getCode() != 200) {
                          throw new ApiException(listHttpResult.getMsg());
                      }
                      if (null != listHttpResult.getAd() && !TextUtils.isEmpty(listHttpResult.getAd().getSelf_ad())) {
                          mRootView.setAdHeaderView(listHttpResult.getAd());
                      }
                      return listHttpResult.getResult();
                  }
              })
              .subscribe(new ProgressSubscriber<>(
                      new SubscriberOnNextListener<List<RoomsMoreResponse>>() {
                          @Override
                          protected void onNext(List<RoomsMoreResponse> responses) {
                              adapter.replaceData(responses);
                              adapter.setOnItemClickListener((adapter, view, position) -> {
                                  Intent intent = new Intent(mRootView.getActivity(), ColumnActivity.class);
                                  intent.putExtra("roomId", responses.get(position).getRoom_id());
                                  mRootView.launchActivity(intent);
                              });
                          }
                      },
                      mRootView.getActivity(), true
              ));
    }
}
