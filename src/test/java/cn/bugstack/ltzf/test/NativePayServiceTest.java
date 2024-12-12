package cn.bugstack.ltzf.test;

import cn.bugstack.ltzf.factory.Configuration;
import cn.bugstack.ltzf.factory.PayFactory;
import cn.bugstack.ltzf.factory.defaults.DeafultPayFactory;
import cn.bugstack.ltzf.payments.nativepay.NativePayService;
import cn.bugstack.ltzf.payments.nativepay.model.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description
 * @create 2024-04-13 18:22
 */
@Slf4j
public class NativePayServiceTest {

//    这里提前,把和这个工厂里才能取到的服务作为属性放在 test类里
    private NativePayService nativePayService;

    @Before
    public void init() {
        Configuration configuration = new Configuration(
                "", "1700833091", "2aadaaf746b36088b77dc9e7b995ea4d"
        );

//        PayFactory payFactory = new DefaultPayFactory(configuration);
        DeafultPayFactory payFactory = new DeafultPayFactory(configuration);
        this.nativePayService = payFactory.nativePayService();
    }

    @Test
    public void test_prepay() throws Exception {
        // 1. 请求参数
        PrepayRequest request = new PrepayRequest();
        request.setMchid("1700833091");
        String num = RandomStringUtils.randomNumeric(8);
        request.setOutTradeNo(num);

        request.setTotalFee("0.01");
        request.setBody("QQ公仔");
        request.setNotifyUrl("http://yangbo666.site");

        // 2. 创建支付订单
//        PrepayResponse response = nativePayService.prepay(request);
        PrepayResponse response = nativePayService.prePay(request);
        log.info("订单号:{}",num);


        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("应答结果:{}", JSON.toJSONString(response));

    }
    @Test
    public void test_queryOrder() throws Exception {
        QueryOrderByOutTradeNoRequest request = new QueryOrderByOutTradeNoRequest();
        request.setMchid("1700833091");
        request.setOutTradeNo("79439274");
        QueryOrderByOutTradeNoResponse response = nativePayService.QueryOrderByOutTradeNO(request);
        log.info("请求参数:{}", JSON.toJSONString(request));
        log.info("应答结果:{}", JSON.toJSONString(response));
    }

    @Test
    public void test_refundOrder() throws Exception {
        RefundOrderRequest request = new RefundOrderRequest();
        request.setMchid("1700833091");
        request.setOutTradeNo("79439274");
        request.setOutRefundNo(RandomStringUtils.randomNumeric(8));
        request.setRefundFee("0.01");
        request.setRefundDesc("测试退款");
        request.setNotifyUrl("http://yangbo666.site");

        Object response = nativePayService.refundOrder(request);
        log.info("请求参数: {}", JSON.toJSONString(request));
        log.info("应答结果: {}", JSON.toJSONString(response));
    }
    @Test
    public void test_getRefundOrder() throws Exception {
        GetRefundOrderRequest request = new GetRefundOrderRequest();
        request.setMchid("1700833091");
        request.setOutRefundNo("40598632");

        GetRefundOrderResponse response = nativePayService.getRefundOrder(request);
        log.info("请求参数: {}", JSON.toJSONString(request));
        log.info("应答结果: {}", JSON.toJSONString(response));
    }


}
