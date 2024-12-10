package cn.bugstack.ltzf.factory;

import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-10 20:53
 */
//这里基本上就是写死的
@Getter
public class Configuration {
//    只要前面的域名
    private String apiHost = "https://api.ltzf.cn";
//开发者ID
    private final String appId;
//    商户ID
    private final String merchantId;

//    商户密钥
    private final String partnerKey;


    public Configuration(String appId, String merchantId, String partnerKey) {
        this.appId = appId;
        this.merchantId = merchantId;
        this.partnerKey = partnerKey;
    }

    @Setter
    private OkHttpClient okHttpClient;
    @Setter
    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;
    @Setter
    private long connectTimeout = 60;
    @Setter
    private long writeTimeout = 60;
    @Setter
    private long readTimeout = 60;
}
