package cn.bugstack.ltzf.payments.nativepay;

import cn.bugstack.ltzf.payments.nativepay.model.GetRefundOrderResponse;
import cn.bugstack.ltzf.payments.nativepay.model.PrepayResponse;
import cn.bugstack.ltzf.payments.nativepay.model.QueryOrderByOutTradeNoResponse;
import cn.bugstack.ltzf.payments.nativepay.model.RefundOrderResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    //每一个都有一个不同的api的,不要填错了
    @POST("api/wxpay/get_pay_order")
    //有这个注解代表是表单类型的数据
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<QueryOrderByOutTradeNoResponse> querOrderByOutTradeNo(
            @Field("mch_id") String mch_id,
            @Field("out_trade_no") String outTradeNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );


    @FormUrlEncoded
    @POST("api/wxpay/refund_order")
    Call<RefundOrderResponse> refundOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("refund_fee") String refundFee,
            @Field("refund_desc") String refundDesc,
            @Field("notify_url") String notifyUrl,
            @Field("sign") String sign
    );
    @FormUrlEncoded
    @POST("api/wxpay/get_refund_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<GetRefundOrderResponse> getRefundOrder(
            @Field("mch_id") String mchId,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );
}
