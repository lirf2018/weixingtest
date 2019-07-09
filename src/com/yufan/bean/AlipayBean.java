package com.yufan.bean;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/29 9:27
 * 功能介绍: 支付宝支付响应参数
 */
public class AlipayBean {

    //公共响应参数
    private String code;//	String	是	-	网关返回码,详见文档	40004
    private String msg;//	String	是	-	网关返回码描述,详见文档	Business Failed
    private String sub_code;//	String	否	-	业务返回码，参见具体的API接口文档	ACQ.TRADE_HAS_SUCCESS
    private String sub_msg;//	String	否	-	业务返回码描述，参见具体的API接口文档	交易已被支付
    private String sign;//	String	是	-	签名,详见文档

    //响应参数
    private String out_trade_no;//	String	必填	64	商户网站唯一订单号	70501111111S001111119
    private String trade_no;//	String	必填	64	该交易在支付宝系统中的交易流水号。最长64位。	2014112400001000340011111118
    private String total_amount;//	Price	必填	9	该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。	9.00
    private String seller_id;//	String	必填	16	收款支付宝账号对应的支付宝唯一用户号。    以2088开头的纯16位数字	2088111111116894
    private String merchant_order_no;//	String	必填	32	商户原始订单号，最大长度限制32位	20161008001

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_msg() {
        return sub_msg;
    }

    public void setSub_msg(String sub_msg) {
        this.sub_msg = sub_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }
}
