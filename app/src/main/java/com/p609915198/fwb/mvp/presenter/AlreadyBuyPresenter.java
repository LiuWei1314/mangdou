package com.p609915198.fwb.mvp.presenter;import android.content.Intent;import android.text.TextUtils;import android.widget.Button;import android.widget.EditText;import com.blankj.utilcode.util.ToastUtils;import com.p609915198.basemodule.base.BasePresenter;import com.p609915198.basemodule.di.scope.ActivityScope;import com.p609915198.basemodule.net.Api;import com.p609915198.basemodule.net.HttpResult;import com.p609915198.basemodule.net.ProgressSubscriber;import com.p609915198.basemodule.net.SubscriberOnNextListener;import com.p609915198.basemodule.net.request.PostReplyRequest;import com.p609915198.basemodule.net.response.AlreadyBuyResponse;import com.p609915198.basemodule.utils.RxUtils;import com.p609915198.fwb.R;import com.p609915198.fwb.app.AppConfig;import com.p609915198.fwb.app.MyApplication;import com.p609915198.fwb.mvp.contract.AlreadyBuyContract;import com.p609915198.fwb.mvp.ui.activity.ColumnActivity;import com.p609915198.fwb.mvp.ui.adapter.AlreadyBuyAdapter;import com.p609915198.fwb.mvp.ui.fragment.RoomDetailFragment;import com.p609915198.fwb.utils.ShareUtil;import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;import java.util.List;import javax.inject.Inject;import me.shaohui.bottomdialog.BottomDialog;/** * Created by Administrator on 2017/11/14. */@ActivityScopepublic class AlreadyBuyPresenter extends BasePresenter<AlreadyBuyContract.Model, AlreadyBuyContract.View> {	@Inject Api mApi;	private AlreadyBuyAdapter mAlreadyBuyAdapter;	@Inject	public AlreadyBuyPresenter(AlreadyBuyContract.Model model, AlreadyBuyContract.View rootView,							   AlreadyBuyAdapter adapter) {		super(model, rootView);		this.mAlreadyBuyAdapter = adapter;	}	public void initData() {		mApi.alreadyBuy(AppConfig.getUserId(), 0, 100)			.compose(RxUtils.bindToLifecycle(mRootView))			.subscribe(new ProgressSubscriber<>(					new SubscriberOnNextListener<List<AlreadyBuyResponse>>() {						@Override						protected void onNext(List<AlreadyBuyResponse> alreadyBuyResponses) {							if (alreadyBuyResponses.isEmpty()) {								mRootView.showToast("暂无购买记录!");							} else {								mAlreadyBuyAdapter.setOnItemChildClickListener((adapter, view, position) -> {									switch (view.getId()) {										case R.id.tv_share:											WXWebpageObject webpageObject = new WXWebpageObject();											webpageObject.webpageUrl = AppConfig.QQ_SHARE_TARGET_URL;											WXMediaMessage msg = new WXMediaMessage(webpageObject);											msg.title = "忙豆听书";											msg.description = "忙豆听书";											SendMessageToWX.Req req = new SendMessageToWX.Req();											req.transaction = ShareUtil.buildTransaction("webpage");											req.message = msg;											req.scene = SendMessageToWX.Req.WXSceneTimeline;											MyApplication.getIWXAPI().sendReq(req);											break;										case R.id.tv_comments:											mRootView.showCommentDialog(alreadyBuyResponses.get(position).getRoom_id());											break;									}								});								mAlreadyBuyAdapter.setOnItemClickListener((adapter, view, position) -> {									Intent intent = new Intent(mRootView.getActivity(), ColumnActivity.class);									intent.putExtra("roomId", alreadyBuyResponses.get(position).getRoom_id());									mRootView.launchActivity(intent);								});								mAlreadyBuyAdapter.replaceData(alreadyBuyResponses);							}						}					},					mRootView.getActivity(), false			));	}}