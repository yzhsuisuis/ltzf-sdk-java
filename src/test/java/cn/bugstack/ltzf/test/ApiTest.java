package cn.bugstack.ltzf.test;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-09 23:37
 */

import cn.bugstack.ltzf.payments.nativepay.INativePayApi;
import cn.bugstack.ltzf.payments.nativepay.model.PrepayResponse;
import cn.bugstack.ltzf.utils.SignUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class ApiTest {
    public static void main(String[] args) {

        long timestamp = System.currentTimeMillis() / 1000;
//        System.out.println(String.valueOf(timestamp));
        System.out.println(timestamp);

        Map<String, String> dataMap = new HashMap<>();
//        这里是商户号 -- 在蓝兔支付的 -- 商户管理部分
        dataMap.put("mch_id", "1700833091");
        dataMap.put("out_trade_no", "123456");
        dataMap.put("total_fee", "0.01");
        dataMap.put("body", "QQ公仔");
        dataMap.put("timestamp", String.valueOf(timestamp));
        dataMap.put("notify_url", "http://yangbo666.site");

        System.out.println("生成的签名: " + SignUtils.createSign(dataMap, "2aadaaf746b36088b77dc9e7b995ea4d"));

    }
//   原来不是只有spring才带test,java的utils包也是带的
    @Test
    public void  test_retrofit2() throws IOException {
//        retrofit包
        OkHttpClient httpClient = new OkHttpClient();

        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl("https://api.ltzf.cn/")
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(INativePayApi.class);
//        获取时间戳不需要使用,这里是没有new的
        long timestamp = System.currentTimeMillis() / 1000;
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", "1700833091");
        dataMap.put("out_trade_no", "1234567");
        dataMap.put("total_fee", "0.01");
        dataMap.put("body", "QQ公仔");
        dataMap.put("timestamp", String.valueOf(timestamp));
        dataMap.put("notify_url", "http://yangbo666.site");

//        这里的对象可以说自定义的
        Call<PrepayResponse> call = nativePayApi.prepay(
                dataMap.get("mch_id"),
                dataMap.get("out_trade_no"),
                dataMap.get("total_fee"),
                dataMap.get("body"),
                dataMap.get("timestamp"),
                dataMap.get("notify_url"),
                SignUtils.createSign(dataMap, "2aadaaf746b36088b77dc9e7b995ea4d"));

        Response<PrepayResponse> response = call.execute();
        Object object = response.body();

        log.info("测试结果:{}", JSON.toJSONString(object));


    }
}
