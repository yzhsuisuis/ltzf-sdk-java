package cn.bugstack.ltzf.payments.nativepay.model;

import cn.bugstack.ltzf.utils.SignUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-10 21:03
 */
@Data
public class PrepayRequest {
    @JsonProperty("mch_id")
    private String mchid;
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @JsonProperty("total_fee")
    private String totalFee;
    @JsonProperty("body")
    private String body;
    @JsonProperty("notify_url")
    private String notifyUrl;
    @JsonProperty("time_expire")
    private String timeExpire;

    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    public String getTimestamp() {
        return timestamp;
    }

    //    在这里创建签名
    public String createSign(String partnerKey)
    {
//        直接这样使用比较安全
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMchid());
        dataMap.put("out_trade_no", getOutTradeNo());
        dataMap.put("total_fee", getTotalFee());
        dataMap.put("body", getBody());
        dataMap.put("timestamp", getTimestamp());
        dataMap.put("notify_url", getNotifyUrl());
        return SignUtils.createSign(dataMap, partnerKey);


    }

}
