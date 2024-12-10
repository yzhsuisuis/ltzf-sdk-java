package cn.bugstack.ltzf.payments.nativepay;

import cn.bugstack.ltzf.factory.Configuration;
import cn.bugstack.ltzf.payments.nativepay.model.PrepayRequest;
import cn.bugstack.ltzf.payments.nativepay.model.PrepayResponse;
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
}
