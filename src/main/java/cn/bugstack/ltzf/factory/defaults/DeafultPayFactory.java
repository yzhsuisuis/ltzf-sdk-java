package cn.bugstack.ltzf.factory.defaults;

import cn.bugstack.ltzf.factory.Configuration;
import cn.bugstack.ltzf.factory.PayFactory;
import cn.bugstack.ltzf.payments.nativepay.INativePayApi;
import cn.bugstack.ltzf.payments.nativepay.NativePayService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-10 20:52
 */
public class DeafultPayFactory implements PayFactory {
    private final Configuration configuration;

    private final OkHttpClient httpClient;

    public DeafultPayFactory(Configuration configuration) {
        this.configuration = configuration;
        // 1. 日志配置
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(configuration.getLevel());

        // 2. 开启 HTTP 客户端
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(configuration.getConnectTimeout(), TimeUnit.SECONDS)
                .writeTimeout(configuration.getWriteTimeout(), TimeUnit.SECONDS)
                .readTimeout(configuration.getReadTimeout(), TimeUnit.SECONDS)
                .build();

    }

    //    需要模仿之前的步骤创建一个api,然后添加一堆东西
    @Override
    public NativePayService nativePayService() {
        // 构建API
        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(INativePayApi.class);
        // 创建Native支付服务
        return new NativePayService(nativePayApi,configuration);
//        最后的那叫一个精髓 ,返回的是一个服务,服务

    }
}
