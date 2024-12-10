package cn.bugstack.ltzf.payments.nativepay;

import cn.bugstack.ltzf.payments.nativepay.model.PrepayResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-10 19:55
 */
public interface INativePayApi {
    @POST("api/wxpay/native")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<PrepayResponse> prepay(@Field("mch_id") String mch_id,
                        @Field("out_trade_no") String outTradeNo,
                        @Field("total_fee") String totalFee,
                        @Field("body") String body,
                        @Field("timestamp") String timestamp,
                        @Field("notify_url") String notifyUrl,
                        @Field("sign") String sign
    );

}
