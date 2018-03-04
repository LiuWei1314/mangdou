package com.p609915198.basemodule.net;


import com.p609915198.basemodule.net.request.AddPlayRecordRequest;
import com.p609915198.basemodule.net.request.AnchorMoreRequest;
import com.p609915198.basemodule.net.request.AudioDetailRequest;
import com.p609915198.basemodule.net.request.AwardRankRequest;
import com.p609915198.basemodule.net.request.ChangePwdPhoneRequest;
import com.p609915198.basemodule.net.request.ChangeUserInfoRequest;
import com.p609915198.basemodule.net.request.CreateRoomRequest;
import com.p609915198.basemodule.net.request.DeleteRoomRequest;
import com.p609915198.basemodule.net.request.FeedBackRequest;
import com.p609915198.basemodule.net.request.GetWithdrawInfoRequest;
import com.p609915198.basemodule.net.request.GiveAwardRequest;
import com.p609915198.basemodule.net.request.GiveGiftRequest;
import com.p609915198.basemodule.net.request.HomeadRequest;
import com.p609915198.basemodule.net.request.IsLikeRequest;
import com.p609915198.basemodule.net.request.LikeRoomRequest;
import com.p609915198.basemodule.net.request.ModifyRoomRequest;
import com.p609915198.basemodule.net.request.MyAwardRequest;
import com.p609915198.basemodule.net.request.MyGiftRequest;
import com.p609915198.basemodule.net.request.MyReceiveAwardRequest;
import com.p609915198.basemodule.net.request.MyReceiveGiftRequest;
import com.p609915198.basemodule.net.request.MyRoomsRequest;
import com.p609915198.basemodule.net.request.PagerOneRequest;
import com.p609915198.basemodule.net.request.PostReplyRequest;
import com.p609915198.basemodule.net.request.PublishAudioRequest;
import com.p609915198.basemodule.net.request.ReplyListRequest;
import com.p609915198.basemodule.net.request.RoomDetailRequest;
import com.p609915198.basemodule.net.request.SecondaryCategoryRequest;
import com.p609915198.basemodule.net.request.SecondaryRoomsRequest;
import com.p609915198.basemodule.net.request.WithdrawRequest;
import com.p609915198.basemodule.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;

public class Api {
    private ApiService mApiService;

    public static final int PLATFORM = 1;// 平台

    public Api(Retrofit retrofit) {
        mApiService = retrofit.create(ApiService.class);
    }

    public static class HttpResultFunc<T> implements Function<HttpResult<T>, T> {
        @Override
        public T apply(HttpResult<T> httpResult) throws Exception {
            if (httpResult.getCode() != 200) {
                throw new ApiException(httpResult);
            }
            return httpResult.getResult();
        }
    }

    public Observable roomsMore(String labelid) {return mApiService.roomsMore(labelid, PLATFORM).compose(RxUtils.ioMain());}

    public Observable anchorMore(AnchorMoreRequest request) {
        return mApiService.anchorMore(request.getLabelid(), request.getPage(), request.getPagesize(), PLATFORM)
                          .compose(RxUtils.ioMain()).map(new HttpResultFunc());
    }

    public Observable category() {return mApiService.category().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable roomDetail(RoomDetailRequest request) {
        return mApiService.roomDetail(request.getRoom_id(), request.getUser_id()).compose(RxUtils.ioMain()).map(new HttpResultFunc());
    }

    public Observable anchorDetail(String userId) {return mApiService.anchorDetail(userId).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable secondaryCategory(SecondaryCategoryRequest request) {
        return mApiService.secondaryCategory(request.getCategory_id(), request.getLength())
                          .compose(RxUtils.ioMain()).map(new HttpResultFunc());
    }

    public Observable popularityRank() {return mApiService.popularityRank().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable payRecomment() {return mApiService.payRecomment().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable modifyRoom(ModifyRoomRequest request) {return mApiService.modifyRoom(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable changeUserInfo(ChangeUserInfoRequest request) {
        return mApiService.changeUserInfo(request.getAge(), request.getBank(), request.getBank_name(), request.getCity(),
                                          request.getHead(), request.getName(), request.getSex(), request.getUser_id(),
                                          request.getVolley(), request.getWechat(), request.getWechat_name(),
                                          request.getWords(), request.getZhi_fu_bao(), request.getZhi_fu_bao_name())
                          .compose(RxUtils.ioMain());
    }

    public Observable createRoom(CreateRoomRequest request) {return mApiService.createRoom(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable deleteRoom(DeleteRoomRequest request) {return mApiService.deleteRoom(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable publishAudio(PublishAudioRequest request) {return mApiService.publishAudio(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable likeRoom(LikeRoomRequest request) {return mApiService.likeRoom(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable superLive() { return mApiService.superLive().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable superHot() { return mApiService.superHot().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable superClassics() { return mApiService.superClassics().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable girlLove() { return mApiService.girlLove().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable secondaryRooms(SecondaryRoomsRequest request) { return mApiService.secondaryRooms(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable alreadyBuy(String userId, int page, int pageSize) {
        return mApiService.alreadyBuy(userId, page, pageSize).compose(RxUtils.ioMain()).map(new HttpResultFunc());
    }

    public Observable pagerOne(PagerOneRequest request) { return mApiService.pagerOne(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable radioPlay() { return mApiService.radioPlay().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable myReceiveAward(MyReceiveAwardRequest request) { return mApiService.myReceiveAward(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable myReceiveGift(MyReceiveGiftRequest request) { return mApiService.myReceiveGift(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable myRooms(MyRoomsRequest request) { return mApiService.myRooms(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable myAward(MyAwardRequest request) { return mApiService.myAward(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable mySubscribe(String userId) { return mApiService.mySubscribe(userId).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable myGift(MyGiftRequest request) { return mApiService.myGift(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable myAward(GiveAwardRequest request) { return mApiService.myAward(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable awardRank(AwardRankRequest request) { return mApiService.awardRank(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable search(String content) { return mApiService.search(content).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable changePwdPhone(String phone, String password) { return mApiService.changePwdPhone(phone, password).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable newRecomment() { return mApiService.newRecomment().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable newRank() { return mApiService.newRank().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable superStar() { return mApiService.superStar().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable isLike(IsLikeRequest request) { return mApiService.isLike(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable changePassword(ChangePwdPhoneRequest request) { return mApiService.changePassword(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable addPlayRecord(AddPlayRecordRequest request) { return mApiService.addPlayRecord(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable hotSoaring() { return mApiService.hotSoaring().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable hotClassics() { return mApiService.hotClassics().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable feedBack(FeedBackRequest request) { return mApiService.feedBack(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable userBaseInfo(String userId) { return mApiService.userBaseInfo(userId).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable withdraw(WithdrawRequest request) { return mApiService.withdraw(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable register(String phone, String password) { return mApiService.register(phone, password).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable login(String username, String password) { return mApiService.login(username, password).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable broadcastLive() { return mApiService.broadcastLive().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable boyLove() { return mApiService.boyLove().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable shortRecomment() { return mApiService.shortRecomment().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable giftList() { return mApiService.giftList().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable classicsRecomment() { return mApiService.classicsRecomment().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable rankingList() { return mApiService.rankingList().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable getPlayRecord(String userId) { return mApiService.getPlayRecord(userId).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable getWithdrawInfo(GetWithdrawInfoRequest request) { return mApiService.getWithdrawInfo(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable bookRoom(String roomId, String userId) { return mApiService.bookRoom(roomId, userId).compose(RxUtils.ioMain());}

    public Observable postReply(PostReplyRequest request) {return mApiService.postReply(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable replyList(ReplyListRequest request) {return mApiService.replyList(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable subscribeRoom(String roomId, String userId) {return mApiService.subcribeRoom(roomId, userId).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable giveGift(GiveGiftRequest request) {return mApiService.giveGift(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable longRecomment() { return mApiService.longRecomment().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable audioList(int page, int pagesize, String room_id, String user_id) { return mApiService.audioList(page, pagesize, room_id, user_id).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable audioDetail(AudioDetailRequest request) { return mApiService.audioDetail(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable modelLive() { return mApiService.modelLive().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable modelRecommend() { return mApiService.modelRecommend().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable modelHot() { return mApiService.modelHot().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable modelClassics() { return mApiService.modelClassics().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable homead(HomeadRequest request) { return mApiService.homead(request).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable anchorList() { return mApiService.anchorList().compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable roomsList(int labeltype) { return mApiService.roomsList(labeltype).compose(RxUtils.ioMain()).map(new HttpResultFunc());}

    public Observable top(String userId) { return mApiService.top(userId).compose(RxUtils.ioMain());}

    public Observable send(String msg, String phone) { return mApiService.send(msg, phone).compose(RxUtils.ioMain());}

    public Observable topupNew(String key) { return mApiService.topupNew(key, "no").compose(RxUtils.ioMain());}

    public Observable payWX(double zongjia, String danhao) { return mApiService.payWX("login", zongjia, danhao).compose(RxUtils.ioMain());}
}
