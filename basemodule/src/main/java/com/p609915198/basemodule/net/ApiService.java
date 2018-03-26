package com.p609915198.basemodule.net;


import com.p609915198.basemodule.net.request.AddPlayRecordRequest;
import com.p609915198.basemodule.net.request.AudioDetailRequest;
import com.p609915198.basemodule.net.request.AwardRankRequest;
import com.p609915198.basemodule.net.request.ChangePwdPhoneRequest;
import com.p609915198.basemodule.net.request.CreateRoomRequest;
import com.p609915198.basemodule.net.request.DeleteRoomRequest;
import com.p609915198.basemodule.net.request.GetWithdrawInfoRequest;
import com.p609915198.basemodule.net.request.GiveAwardRequest;
import com.p609915198.basemodule.net.request.HomeadRequest;
import com.p609915198.basemodule.net.request.IsLikeRequest;
import com.p609915198.basemodule.net.request.LikeRoomRequest;
import com.p609915198.basemodule.net.request.ModifyRoomRequest;
import com.p609915198.basemodule.net.request.MyRoomsRequest;
import com.p609915198.basemodule.net.request.PagerOneRequest;
import com.p609915198.basemodule.net.request.PublishAudioRequest;
import com.p609915198.basemodule.net.request.ReplyListRequest;
import com.p609915198.basemodule.net.request.SecondaryRoomsRequest;
import com.p609915198.basemodule.net.request.WithdrawRequest;
import com.p609915198.basemodule.net.response.AlreadyBuyResponse;
import com.p609915198.basemodule.net.response.AnchorDetailResponse;
import com.p609915198.basemodule.net.response.AnchorListResponse;
import com.p609915198.basemodule.net.response.AnchorMoreResponse;
import com.p609915198.basemodule.net.response.AppVersionResponse;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.basemodule.net.response.AudioDetailResponse;
import com.p609915198.basemodule.net.response.AwardRankResponse;
import com.p609915198.basemodule.net.response.BangResponse;
import com.p609915198.basemodule.net.response.BoyLoveResponse;
import com.p609915198.basemodule.net.response.BroadcastLiveResponse;
import com.p609915198.basemodule.net.response.CategoryResponse;
import com.p609915198.basemodule.net.response.ChargeResponse;
import com.p609915198.basemodule.net.response.ClassicsRecommentResponse;
import com.p609915198.basemodule.net.response.GetWithdrawInfoResponse;
import com.p609915198.basemodule.net.response.GiftListResponse;
import com.p609915198.basemodule.net.response.GirlLoveResponse;
import com.p609915198.basemodule.net.response.HomeAdResponse;
import com.p609915198.basemodule.net.response.HotClassicsResponse;
import com.p609915198.basemodule.net.response.HotSoaringResponse;
import com.p609915198.basemodule.net.response.LongRecommentResponse;
import com.p609915198.basemodule.net.response.ModelClassicsResponse;
import com.p609915198.basemodule.net.response.ModelHotResponse;
import com.p609915198.basemodule.net.response.ModelLiveResponse;
import com.p609915198.basemodule.net.response.ModelRecommendResponse;
import com.p609915198.basemodule.net.response.MyAwardResponse;
import com.p609915198.basemodule.net.response.MyGiftResponse;
import com.p609915198.basemodule.net.response.MyReceiveAwardResponse;
import com.p609915198.basemodule.net.response.MyReceiveGiftResponse;
import com.p609915198.basemodule.net.response.MyRoomsResponse;
import com.p609915198.basemodule.net.response.MySubscribeResponse;
import com.p609915198.basemodule.net.response.NewRankResponse;
import com.p609915198.basemodule.net.response.NewRecommentResponse;
import com.p609915198.basemodule.net.response.PagerOneResponse;
import com.p609915198.basemodule.net.response.PayWXResponse;
import com.p609915198.basemodule.net.response.PopularityRankResponse;
import com.p609915198.basemodule.net.response.RadioPlayResponse;
import com.p609915198.basemodule.net.response.RankingListResponse;
import com.p609915198.basemodule.net.response.ReplyListResponse;
import com.p609915198.basemodule.net.response.RoomDetailResponse;
import com.p609915198.basemodule.net.response.RoomsListResponse;
import com.p609915198.basemodule.net.response.RoomsMoreResponse;
import com.p609915198.basemodule.net.response.SearchResponse;
import com.p609915198.basemodule.net.response.SecondaryCategoryResponse;
import com.p609915198.basemodule.net.response.SecondaryRoomsResponse;
import com.p609915198.basemodule.net.response.SendResponse;
import com.p609915198.basemodule.net.response.ShortRecommentResponse;
import com.p609915198.basemodule.net.response.SuperClassicsResponse;
import com.p609915198.basemodule.net.response.SuperHotResponse;
import com.p609915198.basemodule.net.response.SuperLiveResponse;
import com.p609915198.basemodule.net.response.SuperStarResponse;
import com.p609915198.basemodule.net.response.TopResponse;
import com.p609915198.basemodule.net.response.UserBaseInfoResponse;
import com.p609915198.basemodule.net.response.ZhuBoBangResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

import static com.p609915198.basemodule.net.UrlConstant.ADD_PLAY_RECORD;
import static com.p609915198.basemodule.net.UrlConstant.ALREADY_BUY;
import static com.p609915198.basemodule.net.UrlConstant.ANCHOR_DETAIL;
import static com.p609915198.basemodule.net.UrlConstant.ANCHOR_LIST;
import static com.p609915198.basemodule.net.UrlConstant.ANCHOR_MORE;
import static com.p609915198.basemodule.net.UrlConstant.APP_VERSION;
import static com.p609915198.basemodule.net.UrlConstant.AUDIO_DETAIL;
import static com.p609915198.basemodule.net.UrlConstant.AUDIO_LIST;
import static com.p609915198.basemodule.net.UrlConstant.AWARD_RANK;
import static com.p609915198.basemodule.net.UrlConstant.BANG;
import static com.p609915198.basemodule.net.UrlConstant.BOOK_ROOM;
import static com.p609915198.basemodule.net.UrlConstant.BOY_LOVE;
import static com.p609915198.basemodule.net.UrlConstant.BROADCAST_LIVE;
import static com.p609915198.basemodule.net.UrlConstant.CATEGORY;
import static com.p609915198.basemodule.net.UrlConstant.CHANGE_PASSWORD;
import static com.p609915198.basemodule.net.UrlConstant.CHANGE_PWD_PHONE;
import static com.p609915198.basemodule.net.UrlConstant.CHANGE_USER_INFO;
import static com.p609915198.basemodule.net.UrlConstant.CLASSICS_RECOMMENT;
import static com.p609915198.basemodule.net.UrlConstant.CREATE_ROOM;
import static com.p609915198.basemodule.net.UrlConstant.DELETE_ROOM;
import static com.p609915198.basemodule.net.UrlConstant.FEEDBACK;
import static com.p609915198.basemodule.net.UrlConstant.GET_WITHDRAW_INFO;
import static com.p609915198.basemodule.net.UrlConstant.GIFT_LIST;
import static com.p609915198.basemodule.net.UrlConstant.GIRL_LOVE;
import static com.p609915198.basemodule.net.UrlConstant.GIVE_AWARD;
import static com.p609915198.basemodule.net.UrlConstant.GIVE_GIFT_NEW;
import static com.p609915198.basemodule.net.UrlConstant.HOMEAD;
import static com.p609915198.basemodule.net.UrlConstant.HOT_CLASSICS;
import static com.p609915198.basemodule.net.UrlConstant.HOT_SOARING;
import static com.p609915198.basemodule.net.UrlConstant.IS_LIKE;
import static com.p609915198.basemodule.net.UrlConstant.LIKE_ROOM;
import static com.p609915198.basemodule.net.UrlConstant.LOGIN;
import static com.p609915198.basemodule.net.UrlConstant.LONG_RECOMMENT;
import static com.p609915198.basemodule.net.UrlConstant.MODEL_CLASSICS;
import static com.p609915198.basemodule.net.UrlConstant.MODEL_HOT;
import static com.p609915198.basemodule.net.UrlConstant.MODEL_LIVE;
import static com.p609915198.basemodule.net.UrlConstant.MODEL_RECOMMEND;
import static com.p609915198.basemodule.net.UrlConstant.MODIFY_ROOM;
import static com.p609915198.basemodule.net.UrlConstant.MY_AWARD;
import static com.p609915198.basemodule.net.UrlConstant.MY_GIFT;
import static com.p609915198.basemodule.net.UrlConstant.MY_RECEIVE_AWARD;
import static com.p609915198.basemodule.net.UrlConstant.MY_RECEIVE_GIFT;
import static com.p609915198.basemodule.net.UrlConstant.MY_ROOMS;
import static com.p609915198.basemodule.net.UrlConstant.MY_SUBSCRIBE;
import static com.p609915198.basemodule.net.UrlConstant.NEW_RANK;
import static com.p609915198.basemodule.net.UrlConstant.NEW_RECOMMENT;
import static com.p609915198.basemodule.net.UrlConstant.PAGER_ONE;
import static com.p609915198.basemodule.net.UrlConstant.PAY_RECOMMENT;
import static com.p609915198.basemodule.net.UrlConstant.PAY_WX;
import static com.p609915198.basemodule.net.UrlConstant.POPULARITY_RANK;
import static com.p609915198.basemodule.net.UrlConstant.POST_REPLY;
import static com.p609915198.basemodule.net.UrlConstant.PUBLISH_AUDIO;
import static com.p609915198.basemodule.net.UrlConstant.RADIO_PLAY;
import static com.p609915198.basemodule.net.UrlConstant.RANKING_LIST;
import static com.p609915198.basemodule.net.UrlConstant.REGISTER;
import static com.p609915198.basemodule.net.UrlConstant.ROOMS_LIST;
import static com.p609915198.basemodule.net.UrlConstant.ROOMS_MORE;
import static com.p609915198.basemodule.net.UrlConstant.ROOM_DETAIL;
import static com.p609915198.basemodule.net.UrlConstant.SEARCH;
import static com.p609915198.basemodule.net.UrlConstant.SECONDARY_CATEGORY;
import static com.p609915198.basemodule.net.UrlConstant.SECONDARY_ROOMS;
import static com.p609915198.basemodule.net.UrlConstant.SEND;
import static com.p609915198.basemodule.net.UrlConstant.SHORT_RECOMMENT;
import static com.p609915198.basemodule.net.UrlConstant.SUBCRIBE_ROOM;
import static com.p609915198.basemodule.net.UrlConstant.SUPER_CLASSICS;
import static com.p609915198.basemodule.net.UrlConstant.SUPER_HOT;
import static com.p609915198.basemodule.net.UrlConstant.SUPER_LIVE;
import static com.p609915198.basemodule.net.UrlConstant.SUPER_STAR;
import static com.p609915198.basemodule.net.UrlConstant.TOP;
import static com.p609915198.basemodule.net.UrlConstant.TOPUP_NEW;
import static com.p609915198.basemodule.net.UrlConstant.USER_BASE_INFO;
import static com.p609915198.basemodule.net.UrlConstant.WITHDRAW;
import static com.p609915198.basemodule.net.UrlConstant.ZHU_BO_BANG;

public interface ApiService {
    @POST(ROOMS_MORE)
    Observable<HttpResult<List<RoomsMoreResponse>>> roomsMore(@Query("labelid") String labelid, @Query("platform") int platform);

    @POST(ANCHOR_MORE)
    Observable<HttpResult<List<AnchorMoreResponse>>> anchorMore(@Query("labelid") String labelid,
                                                                @Query("page") int page,
                                                                @Query("pagesize") int pagesize,
                                                                @Query("platform") int platform);

    @POST(CATEGORY)
    Observable<HttpResult<List<CategoryResponse>>> category();

    @POST(ROOM_DETAIL)
    Observable<HttpResult<RoomDetailResponse>> roomDetail(@Query("room_id") String roomId, @Query("user_id") String userId);

    @POST(ANCHOR_DETAIL)
    Observable<HttpResult<AnchorDetailResponse>> anchorDetail(@Query("user_id") String userId);

    @POST(SECONDARY_CATEGORY)
    Observable<HttpResult<List<SecondaryCategoryResponse>>> secondaryCategory(@Query("category_id") String category_id,
                                                                              @Query("length") int length);

    @POST(POPULARITY_RANK)
    Observable<HttpResult<List<PopularityRankResponse>>> popularityRank();

    @POST(PAY_RECOMMENT)
    Observable<HttpResult<List<ModelRecommendResponse>>> payRecomment();

    @POST(MODIFY_ROOM)
    Observable<HttpResult<String>> modifyRoom(@Body ModifyRoomRequest request);

    @POST(CHANGE_USER_INFO)
    Observable<HttpResult> changeUserInfo(@Query("age") int age, @Query("bank") String bank, @Query("bank_name") String bank_name, @Query("city") String city,
                                          @Query("head") String head, @Query("name") String name, @Query("sex") int sex,
                                          @Query("user_id") String user_id, @Query("volley") double volley, @Query("wechat") String wechat,
                                          @Query("wechat_name") String wechat_name, @Query("words") String words,
                                          @Query("zhi_fu_bao") String zhi_fu_bao, @Query("zhi_fu_bao_name") String zhi_fu_bao_name);

    @POST(CREATE_ROOM)
    Observable<HttpResult<String>> createRoom(@Body CreateRoomRequest request);

    @POST(DELETE_ROOM)
    Observable<HttpResult<String>> deleteRoom(@Body DeleteRoomRequest request);

    @POST(PUBLISH_AUDIO)
    Observable<HttpResult<String>> publishAudio(@Body PublishAudioRequest request);

    @POST(LIKE_ROOM)
    Observable<HttpResult<String>> likeRoom(@Body LikeRoomRequest request);

    @POST(SUPER_LIVE)
    Observable<HttpResult<List<SuperLiveResponse>>> superLive();

    @POST(SUPER_HOT)
    Observable<HttpResult<List<SuperHotResponse>>> superHot();

    @POST(SUPER_CLASSICS)
    Observable<HttpResult<List<SuperClassicsResponse>>> superClassics();

    @POST(GIRL_LOVE)
    Observable<HttpResult<List<GirlLoveResponse>>> girlLove();

    @POST(SECONDARY_ROOMS)
    Observable<HttpResult<List<SecondaryRoomsResponse>>> secondaryRooms(@Body SecondaryRoomsRequest request);

    @POST(ALREADY_BUY)
    Observable<HttpResult<List<AlreadyBuyResponse>>> alreadyBuy(@Query("user_id") String userId, @Query("page") int page, @Query("pagesize") int pagesize);

    @POST(PAGER_ONE)
    Observable<HttpResult<List<PagerOneResponse>>> pagerOne(@Body PagerOneRequest request);

    @POST(RADIO_PLAY)
    Observable<HttpResult<List<RadioPlayResponse>>> radioPlay();

    @POST(MY_RECEIVE_AWARD)
    Observable<HttpResult<List<MyReceiveAwardResponse>>> myReceiveAward(@Query("user_id") String userId, @Query("page") int page, @Query("pagesize") int pagesize);

    @POST(MY_RECEIVE_GIFT)
    Observable<HttpResult<List<MyReceiveGiftResponse>>> myReceiveGift(@Query("user_id") String userId, @Query("page") int page, @Query("pagesize") int pagesize);

    @POST(MY_ROOMS)
    Observable<HttpResult<List<MyRoomsResponse>>> myRooms(@Body MyRoomsRequest request);

    @POST(MY_AWARD)
    Observable<HttpResult<List<MyAwardResponse>>> myAward(@Query("user_id") String userId, @Query("page") int page, @Query("pagesize") int pagesize);

    @POST(MY_SUBSCRIBE)
    Observable<HttpResult<List<MySubscribeResponse>>> mySubscribe(@Query("user_id") String userId, @Query("page") int page, @Query("pagesize") int pagesize);

    @POST(MY_GIFT)
    Observable<HttpResult<List<MyGiftResponse>>> myGift(@Query("user_id") String userId, @Query("page") int page, @Query("pagesize") int pagesize);

    @POST(GIVE_AWARD)
    Observable<HttpResult<String>> myAward(@Body GiveAwardRequest request);

    @POST(AWARD_RANK)
    Observable<HttpResult<List<AwardRankResponse>>> awardRank(@Body AwardRankRequest request);

    @POST(SEARCH)
    Observable<HttpResult<List<SearchResponse>>> search(@Query("content") String content, @Query("page") int page, @Query("pagesize") int pagesize);

    @POST(CHANGE_PWD_PHONE)
    Observable<HttpResult<String>> changePwdPhone(@Query("phone") String phone, @Query("password") String password);

    @POST(NEW_RECOMMENT)
    Observable<HttpResult<List<NewRecommentResponse>>> newRecomment();

    @POST(NEW_RANK)
    Observable<HttpResult<List<NewRankResponse>>> newRank();

    @POST(SUPER_STAR)
    Observable<HttpResult<List<SuperStarResponse>>> superStar();

    @POST(IS_LIKE)
    Observable<HttpResult<String>> isLike(@Body IsLikeRequest request);

    @POST(CHANGE_PASSWORD)
    Observable<HttpResult<String>> changePassword(@Body ChangePwdPhoneRequest request);

    @POST(ADD_PLAY_RECORD)
    Observable<HttpResult<String>> addPlayRecord(@Body AddPlayRecordRequest request);

    @POST(HOT_SOARING)
    Observable<HttpResult<List<HotSoaringResponse>>> hotSoaring();

    @POST(HOT_CLASSICS)
    Observable<HttpResult<List<HotClassicsResponse>>> hotClassics();

    @POST(FEEDBACK)
    Observable<HttpResult> feedBack(@Query("user_id") String userId, @Query("content") String content, @Query("feedback_type") int feedBackType);

    @POST(USER_BASE_INFO)
    Observable<HttpResult<UserBaseInfoResponse>> userBaseInfo(@Query("user_id") String userId);

    @POST(WITHDRAW)
    Observable<HttpResult<String>> withdraw(@Body WithdrawRequest request);

    @POST(REGISTER)
    Observable<HttpResult<Integer>> register(@Query("phone") String phone, @Query("password") String password);

    @POST(LOGIN)
    Observable<HttpResult<String>> login(@Query("phone") String phone, @Query("password") String password);

    @POST(BROADCAST_LIVE)
    Observable<HttpResult<List<BroadcastLiveResponse>>> broadcastLive();

    @POST(BOY_LOVE)
    Observable<HttpResult<List<BoyLoveResponse>>> boyLove();

    @POST(SHORT_RECOMMENT)
    Observable<HttpResult<List<ShortRecommentResponse>>> shortRecomment();

    @POST(GIFT_LIST)
    Observable<HttpResult<List<GiftListResponse>>> giftList();

    @POST(CLASSICS_RECOMMENT)
    Observable<HttpResult<List<ClassicsRecommentResponse>>> classicsRecomment();

    @POST(RANKING_LIST)
    Observable<HttpResult<List<RankingListResponse>>> rankingList();

    @POST
    Observable<HttpResult> recordSearch(@Url String url, @Query("user_id") String userId);

    @POST(GET_WITHDRAW_INFO)
    Observable<HttpResult<List<GetWithdrawInfoResponse>>> getWithdrawInfo(@Body GetWithdrawInfoRequest request);

    @POST(BOOK_ROOM)
    Observable<HttpResult<String>> bookRoom(@Query("room_id") String roomId, @Query("user_id") String userId);

    @POST(POST_REPLY)
    Observable<HttpResult> postReply(@Query("room_id") String roomId, @Query("user_id") String userId,
                                     @Query("content") String content, @Query("load") boolean load);

    @POST(POST_REPLY)
    Observable<HttpResult<List<ReplyListResponse>>> replyList(@Body ReplyListRequest request);

    @POST(SUBCRIBE_ROOM)
    Observable<HttpResult> subcribeRoom(@Query("room_id") String roomId, @Query("user_id") String userId);

    @POST(GIVE_GIFT_NEW)
    Observable<HttpResult> giveGift(@Query("key") String key);

    @POST(LONG_RECOMMENT)
    Observable<HttpResult<List<LongRecommentResponse>>> longRecomment();

    @POST(AUDIO_LIST)
    Observable<HttpResult<List<Audio>>> audioList(@Query("page") int page, @Query("pagesize") int pagesize,
                                                  @Query("room_id") String room_id, @Query("user_id") String user_id);

    @POST(AUDIO_DETAIL)
    Observable<HttpResult<List<AudioDetailResponse>>> audioDetail(@Body AudioDetailRequest request);

    @POST(MODEL_LIVE)
    Observable<HttpResult<List<ModelLiveResponse>>> modelLive();

    @POST(MODEL_RECOMMEND)
    Observable<HttpResult<List<ModelRecommendResponse>>> modelRecommend();

    @POST(MODEL_HOT)
    Observable<HttpResult<List<ModelHotResponse>>> modelHot();

    @POST(MODEL_CLASSICS)
    Observable<HttpResult<List<ModelClassicsResponse>>> modelClassics();

    @POST(HOMEAD)
    Observable<HttpResult<List<HomeAdResponse>>> homead(@Body HomeadRequest request);

    @POST(ANCHOR_LIST)
    Observable<HttpResult<List<AnchorListResponse>>> anchorList();

    @POST(ROOMS_LIST)
    Observable<HttpResult<List<RoomsListResponse>>> roomsList(@Query("labeltype") int request);

    @POST(TOP)
    Observable<TopResponse> top(@Query("user_id") String userId);

    @POST(SEND)
    Observable<HttpResult<SendResponse>> send(@Query("code") String msg, @Query("phone") String phone);

    @GET(TOPUP_NEW)
    Observable<ChargeResponse> topupNew(@Query("key") String key, @Query("is_encode") String isEncode);

    @POST(PAY_WX)
    Observable<PayWXResponse> payWX(@Query("type") String type, @Query("zongjia") double zongjia, @Query("danhao") String danhao);

    @GET(APP_VERSION)
    Observable<AppVersionResponse> appVersion();

    @POST(BANG)
    Observable<BangResponse> bang();

    @POST(ZHU_BO_BANG)
    Observable<ZhuBoBangResponse> zhuBoBang();
}