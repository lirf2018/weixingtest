package com.yufan.action;

import com.alibaba.fastjson.JSONObject;
import com.yufan.bean.AlipayBean;
import com.yufan.common.LotFilterAction;

import javax.servlet.ServletInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/27 17:49
 * 功能介绍:
 */
public class AlipayCallBack extends LotFilterAction {


    /**
     * http://lrf-13418915218.6655.la/weixingtest/index/alipayCallBack
     *
     * @return
     */
    public void index() {
        try {
            initData();
            String message = null;
            message = request.getParameter("message");
            if (null == message || "".equals(message)) {
                message = readStreamParameter(request.getInputStream());
            }
            System.out.println("------------支付宝回调message=" + message);

            //公共响应参数
            String code = request.getParameter("code");//	String	是	-	网关返回码,详见文档	40004
            String msg = request.getParameter("msg");//	String	是	-	网关返回码描述,详见文档	Business Failed
            String sub_code = request.getParameter("sub_code");//	String	否	-	业务返回码，参见具体的API接口文档	ACQ.TRADE_HAS_SUCCESS
            String sub_msg = request.getParameter("sub_msg");//	String	否	-	业务返回码描述，参见具体的API接口文档	交易已被支付
            String sign = request.getParameter("sign");//	String	是	-	签名,详见文档

            //响应参数
            String out_trade_no = request.getParameter("out_trade_no");//	String	必填	64	商户网站唯一订单号	70501111111S001111119
            String trade_no = request.getParameter("trade_no");//	String	必填	64	该交易在支付宝系统中的交易流水号。最长64位。	2014112400001000340011111118
            String total_amount = request.getParameter("total_amount");//	Price	必填	9	该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。	9.00
            String seller_id = request.getParameter("seller_id");//	String	必填	16	收款支付宝账号对应的支付宝唯一用户号。    以2088开头的纯16位数字	2088111111116894
            String merchant_order_no = request.getParameter("merchant_order_no");//	String	必填	32	商户原始订单号，最大长度限制32位	20161008001

            JSONObject json = new JSONObject();
            json.put("code", code);
            json.put("msg", msg);
            json.put("sub_code", sub_code);
            json.put("sub_msg", sub_msg);
            json.put("out_trade_no", out_trade_no);
            json.put("trade_no", trade_no);
            json.put("total_amount", total_amount);
            json.put("seller_id", seller_id);
            json.put("merchant_order_no", merchant_order_no);
//            json.put("sign", sign);

            System.out.println("------------支付宝回调alipayBean=" + json);//失败获取

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 校验接口可用性
     */
    public void checkSys() {

    }

    /**
     * 从流中读取数据
     *
     * @param in
     * @return
     */
    public String readStreamParameter(ServletInputStream in) {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

}
