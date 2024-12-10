package cn.bugstack.ltzf.test;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-09 23:37
 */

import cn.bugstack.ltzf.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

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
}
