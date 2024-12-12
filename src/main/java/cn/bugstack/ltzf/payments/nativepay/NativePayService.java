package cn.bugstack.ltzf.payments.nativepay;

import cn.bugstack.ltzf.factory.Configuration;
import cn.bugstack.ltzf.payments.nativepay.model.*;
import retrofit2.Call;
import retrofit2.Response;


import java.io.IOException;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-10 21:18
 */
public class NativePayService {
    private INativePayApi nativePayApi;
    private Configuration configuration;

    public NativePayService(INativePayApi nativePayApi, Configuration configuration) {
        this.nativePayApi = nativePayApi;
        this.configuration = configuration;
    }
    public PrepayResponse prePay(PrepayRequest request) throws IOException {
        Call<PrepayResponse> call = nativePayApi.prepay(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimestamp(),
                request.getNotifyUrl(),
                request.createSign(configuration.getPartnerKey())

        );
        Response<PrepayResponse> response = call.execute();
        return response.body();

    }

    /**
     *
     * @param request
     * @return 查询订单
     * @throws IOException
     */
   public QueryOrderByOutTradeNoResponse QueryOrderByOutTradeNO(QueryOrderByOutTradeNoRequest request) throws IOException {
       Call<QueryOrderByOutTradeNoResponse> call = nativePayApi.querOrderByOutTradeNo(
               request.getMchid(),
               request.getOutTradeNo(),
               request.getTimestamp(),
               request.createSign(configuration.getPartnerKey()));
       Response<QueryOrderByOutTradeNoResponse> response = call.execute();
       return response.body();


   }
    /**
     * 发起退单
     *
     * @param request 退单信息
     * @return 退单结果
     * @throws Exception 异常
     */
    public RefundOrderResponse refundOrder(RefundOrderRequest request) throws Exception {
        // 1. 请求接口 & 签名
        Call<RefundOrderResponse> call = nativePayApi.refundOrder(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.getRefundFee(),
                request.getRefundDesc(),
                request.getNotifyUrl(),
                request.createSign(configuration.getPartnerKey()));

        // 2. 获取数据
        retrofit2.Response<RefundOrderResponse> execute = call.execute();

        // 3. 返回结果
        return execute.body();
    }
    /**
     * 查询退单结果
     * @param request 请求参数
     * @return 退单信息
     * @throws Exception 异常
     */
    public GetRefundOrderResponse getRefundOrder(GetRefundOrderRequest request) throws Exception {
        // 1. 请求接口 & 签名
        Call<GetRefundOrderResponse> call = nativePayApi.getRefundOrder(
                request.getMchid(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.createSign(configuration.getPartnerKey()));

        // 2. 获取数据
        retrofit2.Response<GetRefundOrderResponse> execute = call.execute();

        // 3. 返回结果
        return execute.body();
    }

}
