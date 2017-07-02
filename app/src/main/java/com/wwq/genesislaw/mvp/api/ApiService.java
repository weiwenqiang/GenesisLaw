package com.wwq.genesislaw.mvp.api;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wwq on 2017/4/12.
 */

public interface ApiService {
    /**
     * 服务器地址
     */
    String BASE_URL = "http://192.168.0.200:8080/";//124.165.205.15//211.159.158.126

    /**
     *  以下为接口地址
     * ---------------------------------------- 强大分割线 ----------------------------------------
     */
//    /**
//     * 登录
//     */
//    @POST("app/guard/login")
//    Observable<LoginEntity> Login(@Query("phone") String phone,
//                                  @Query("password") String password);
//
//    /**
//     * 查看该闪递人是否已经注册
//     */
//    @POST("app/guard/selectGuard")
//    Observable<RequestErrorEntity> SelectGuard(@Query("phoneNumber") String phoneNumber);
//
//    /**
//     * 注册--实名认证
//     */
//    @Multipart
//    @POST("app/guard/register/info")
//    Observable<String> RegisterInfo(@Part("token") RequestBody token,
//                                    @Part("realName") RequestBody realName,
//                                    @Part("idCard") RequestBody idCard,
//                                    @Part("carNumber") RequestBody carNumber,
//                                    @Part MultipartBody.Part idCardFrontFile,
//                                    @Part MultipartBody.Part idCardBackFile,
//                                    @Part MultipartBody.Part drivingLicenseFile,
//                                    @Part MultipartBody.Part vehicleTravelLicenseFile,
//                                    @Part MultipartBody.Part carImageFile);
//
//    /**
//     * 注册
//     */
//    @POST("app/guard/register")
//    Observable<String> Register(@Query("phone") String phone,
//                                @Query("password") String password);
//
//    /**
//     * 修改密码
//     */
//    @GET("app/guard/changePassword")
//    Observable<String> ChangePassword(@Query("token") String token,
//                                      @Query("oldPassword") String oldPassword,
//                                      @Query("newPassword") String newPassword);
//
//    /**
//     * 忘记密码后的修改
//     */
//    @GET("app/guard/user/forgetPwd")
//    Observable<RequestErrorEntity> ForgetPwd(@Query("phoneNumber") String phoneNumber,
//                                             @Query("newPwd") String newPwd);
//
//    /**
//     * 闪递人订单列表（5类）
//     */
//    @GET("app/guard/order/allOrder")
//    Observable<OrderEntity> AllOrder(@Query("token") String token,
//                                     @Query("type") int type,
//                                     @Query("rum") int rum);
//
//    /**
//     * 点击订单按钮
//     */
//    @GET("app/guard/order/receiveOrder")
//    Observable<String> ReceiveOrder(@Query("token") String token,
//                                    @Query("orderNo") String orderNo,
//                                    @Query("type") int type);
//
//    /**
//     * 查询订单列表
//     */
//    @GET("app/guard/selorder/selAllOrder")
//    Observable<String> SelAllOrder(@Query("token") String token,
//                                   @Query("type") int type,
//                                   @Query("date") String date,
//                                   @Query("rum") int rum);
//
//    /**
//     * 更新跑腿人地理位置
//     */
//    @POST("app/guard/coordinate/update")
//    Observable<String> Update(@Query("token") String token,
//                              @Query("latitude") String latitude,
//                              @Query("longitude") String longitude);
//
//    /**
//     * 闪递人设置工作状态
//     */
//    @GET("app/guard/workStatus/isRest")
//    Observable<RequestErrorEntity> IsRest(@Query("token") String token,
//                                          @Query("state") int state);
//
//    /**
//     * 抢单
//     */
//    @GET("app/guard/order/robOrder")
//    Observable<String> RobOrder(@Query("token") String token,
//                                @Query("orderType") int orderType,
//                                @Query("orderNo") int orderNo);
//
//    /**
//     * 闪递人今日销量及金额
//     */
//    @GET("app/guard/guardSale")
//    Observable<GuardSaleEntity> GuardSale(@Query("token") String token);
//
//    /**
//     * 闪递人反馈意见
//     */
//    @POST("app/guard/addComplain")
//    Observable<String> AddComplain(@Query("token") String token,
//                                   @Query("talkContent") String talkContent);
//
//    /**
//     * 闪递人交易明细
//     */
//    @POST("app/people/select")
//    Observable<String> Select(@Query("token") String token,
//                              @Query("pageSize") String pageSize);
//
//    /**
//     * 闪递人一段时间的交易总单数（比如一天一月）
//     */
//    @POST("app/people/selectDayNumber")
//    Observable<String> SeleselectDayNumberct(@Query("token") String token,
//                                             @Query("finishTime") String finishTime);
//
//    /**
//     * 闪递人一段时间的交易总收益（比如一天一月）
//     */
//    @POST("app/people/totalRevenue")
//    Observable<String> TotalRevenue(@Query("token") String token,
//                                    @Query("finishTime") String finishTime);
//
//    /**
//     * 闪递人端查看未回复已回复评论
//     */
//    @POST("app/guard/order/orderNotEvaluated")
//    Observable<FindTalkEntity> OrderNotEvaluated(@Query("token") String token,
//                                                 @Query("talk") int talk,
//                                                 @Query("page") int page);
//
//    /**
//     * 闪递人回复用户评论
//     */
//    @GET("app/guard/order/reply")
//    Observable<String> Reply(@Query("token") String token,
//                             @Query("id") long id,
//                             @Query("replyContent") String replyContent);
//
//    /**
//     * 获取闪递人当天，当月各类数据
//     */
//    @POST("app/people/queryInComeDetails")
//    Observable<String> QueryInComeDetails(@Query("token") String token);
//
//    /**
//     * 极光 绑定 registrationId
//     */
//    @POST("app/registration/jpush")
//    Observable<String> jpushRegistrationId(@Query("registrationId") String registrationId,
//                                           @Query("type") int type,
//                                           @Query("status") int status,
//                                           @Query("token") String token);
//
//    /**
//     * 检查新版本，App升级
//     */
//    @POST("application/flashgordon/update.json")
//    Observable<CheckUpgradeApkEntity> getAppUpdate();
}
