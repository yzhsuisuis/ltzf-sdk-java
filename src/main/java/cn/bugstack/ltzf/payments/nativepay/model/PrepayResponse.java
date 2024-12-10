package cn.bugstack.ltzf.payments.nativepay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-10 21:03
 */
@lombok.Data
//自动忽略无法处理的
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrepayResponse {
    private Long code;
    private Data data;
    private String msg;
    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data{
        @JsonProperty("code_url")
        private String codeUrl;
        @JsonProperty("QRcode_url")
        private String qrcodeUrl;
    }



}
