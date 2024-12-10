package cn.bugstack.ltzf.factory;

import cn.bugstack.ltzf.payments.nativepay.NativePayService;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 支付工厂
 * @create 2024-04-13 18:15
 */
public interface PayFactory {

    NativePayService nativePayService();

}
