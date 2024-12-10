package cn.bugstack.ltzf.test;

/*
 *@auther:yangzihe @洋纸盒
 *@discription:
 *@create 2024-12-10 14:55
 */
import java.nio.charset.StandardCharsets;

public class CodeTest {
    public static void main(String[] args) {
        // 定义一个字符
//        char c = '中';
//
//        // 将字符转换为UTF-8编码的字节序列
//        byte[] utf8Bytes = String.valueOf(c).getBytes(StandardCharsets.UTF_8);
//
//        // 打印字节序列
//        System.out.print("UTF-8编码下的字节序列: ");
//        for (byte b : utf8Bytes) {
//
//            System.out.printf("%02X ", b);
//        }
//        System.out.println();
//
//        System.out.print("UTF-8编码下的二进制序列: ");
//        for (byte b : utf8Bytes) {
//            // 将每个字节转换为8位的二进制字符串
//            String binary = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
//            System.out.print(binary + " ");
//        }
        String s1 = "body=QQ公仔&mch_id=1700833091&notify_url=http:yangbo666.site&out_trade_no=123456&timestamp=1733822969&total_fee=0.01&key=2aadaaf746b36088b77dc9e7b995ea4d";

        String s2 = "body=QQ公仔&mch_id=1700833091&notify_url=http:yangbo666.site&out_trade_no=123456&timestamp=1733822969&total_fee=0.01&key=2aadaaf746b36088b77dc9e7b995ea4d";
        System.out.println(s1.equals(s2));
    }
}