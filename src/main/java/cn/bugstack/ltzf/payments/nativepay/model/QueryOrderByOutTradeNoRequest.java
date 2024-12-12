package cn.bugstack.ltzf.payments.nativepay.model;

import cn.bugstack.ltzf.utils.SignUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/*
 *@auther:yangzihe @洋纸盒
 *@discription: 查询订单请求
 *@create 2024-12-10 23:35
 */
@Data
public class QueryOrderByOutTradeNoRequest {
    /** 商户号 */
    @Setter
    private String mchid;
    /** 商户订单号 */
    @Setter
    private String outTradeNo;
//    当前时间戳

    private final String timestamp = String.valueOf(System.currentTimeMillis()/1000);

    public  String createSign(String partnerKey)
    {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMchid());
        dataMap.put("out_trade_no", getOutTradeNo());
        dataMap.put("timestamp", getTimestamp());
        return SignUtils.createSign(dataMap, partnerKey);
    }


}
