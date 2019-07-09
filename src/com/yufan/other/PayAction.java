package com.yufan.other;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.yufan.common.LotFilterAction;
import com.yufan.util.AlipayConfig;
import com.yufan.util.DateUtil;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/27 17:29
 * 功能介绍:
 */
public class PayAction extends LotFilterAction {
    AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.APP_PRIVATE_KEY, "json", "GBK", AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");

    /**
     * http://localhost:8080/weixingtest/index/alipay
     *
     * @return
     */
    public String index() {
        initData();
        System.out.println("==========index");
        return "success";
    }


    /**
     * 手机网站支付
     * <p>
     * 适用于商家在移动端网页应用中集成支付宝支付功能。
     * 商家在网页中调用支付宝提供的网页支付接口调起支付宝客户端内的支付模块，
     * 商家网页会跳转到支付宝中完成支付，支付完后跳回到商家网页内，最后展示支付结果。若无法唤起支付宝客户端，则在一定的时间后会自动进入网页支付流程。
     */
    public void alipay1() {
        initData();
        try {
            System.out.println("==========index2");
//            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
            AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);//在公共参数中设置回跳和通知地址
            //订单内容
            JSONObject orderInfo = new JSONObject();
            //公共参数
            orderInfo.put("out_trade_no", System.currentTimeMillis());//商户网站唯一订单号
            orderInfo.put("total_amount", StringUtils.isEmpty(request.getParameter("price")) ? 0.01 : request.getParameter("price"));//订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
            orderInfo.put("subject", "Iphone6 16G" + DateUtil.getNow("yyyyMMddHHmmss"));//商品的标题/交易标题/订单标题/订单关键字等。
            orderInfo.put("product_code", "QUICK_WAP_WAY");//销售产品码，商家和支付宝签约的产品码 QUICK_WAP_WAY
            //


            alipayRequest.setBizContent(orderInfo.toJSONString());

//            alipayRequest.setBizContent("{" +
//                    " \"out_trade_no\":\"" + System.currentTimeMillis() + "\"," +
//                    " \"total_amount\":\"100.00\"," +
//                    " \"subject\":\"Iphone6 16G\"," +
//                    " \"product_code\":\"QUICK_WAP_PAY\"" +
//                    " }");//填充业务参数
            String form = "";
            try {
                form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public String payTo() {
//        try {
//            System.out.println("------------payTo");
//            initData();
//            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
//            AlipayTradeAppPayRequest requestAlipay = new AlipayTradeAppPayRequest();
//            //订单内容
//            JSONObject orderInfo = new JSONObject();
//            //公共参数
//            orderInfo.put("out_trade_no", System.currentTimeMillis());//商户网站唯一订单号
//            orderInfo.put("total_amount", StringUtils.isEmpty(request.getParameter("price")) ? 0.01 : request.getParameter("price"));//订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
//            orderInfo.put("subject", "Iphone6 16G"+DateUtil.getNow("yyyyMMddHHmmss"));//商品的标题/交易标题/订单标题/订单关键字等。
//            orderInfo.put("product_code", "QUICK_WAP_WAY");//销售产品码，商家和支付宝签约的产品码 QUICK_WAP_WAY
//            //
//            AlipayTradeAppPayResponse response = alipayClient.pageExecute(requestAlipay);
//            if (response.isSuccess()) {
//                System.out.println("调用成功");
//                System.out.println(JSONObject.toJSONString(response));
//                request.setAttribute("ad",response.getBody());
//                return "success";
//            } else {
//                System.out.println("调用失败");
//                System.out.println(JSONObject.toJSONString(response));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return  "";
//    }

    /**
     * 统一收单交易退款接口
     * <p>
     * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，支付宝将在收到退款请求并且验证成功之后，
     * 按照退款规则将支付款按原路退到买家帐号上。 交易超过约定时间（签约时设置的可退款时间）的订单无法进行退款 支付宝退款支持单笔交易分多次退款，
     * 多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。总退款金额不能超过用户实际支付金额
     */
    private void alipayRefund(String tradeNo, BigDecimal price) {
        try {
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            //订单
            JSONObject orderData = new JSONObject();
//            orderData.put("out_trade_no","");//订单支付时传入的商户订单号,不能和 trade_no同时为空。
            orderData.put("trade_no", tradeNo);//支付宝交易号，和商户订单号不能同时为空
            orderData.put("refund_amount", price.doubleValue());//需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
            request.setBizContent(orderData.toJSONString());
//            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.APP_PRIVATE_KEY, "json", "GBK", AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
            System.out.println(JSONObject.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 商户通过该接口进行交易的创建下单
     */

    public void createOrder(BigDecimal price) {
        try {
            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();


            //订单内容
            JSONObject orderData = new JSONObject();
            //公共参数
            orderData.put("out_trade_no", System.currentTimeMillis());//商户网站唯一订单号
            orderData.put("total_amount", price.doubleValue());//订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
            orderData.put("subject", "Iphone9G" + DateUtil.getNow("yyyyMMddHHmmss"));//商品的标题/交易标题/订单标题/订单关键字等。
            orderData.put("product_code", "QUICK_WAP_WAY");//销售产品码，商家和支付宝签约的产品码 QUICK_WAP_WAY
            orderData.put("buyer_id", "2088102177823733");//买家的支付宝唯一用户号（2088开头的16位纯数字）
            //

            request.setBizContent(orderData.toJSONString());

            AlipayTradeCreateResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
            System.out.println(JSONObject.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PayAction payAction = new PayAction();
//        payAction.alipayRefund("2019052922001460681000020786", new BigDecimal("0.01"));
//        payAction.test(new BigDecimal(3));
        payAction.createOrder(new BigDecimal("100"));
    }

}
