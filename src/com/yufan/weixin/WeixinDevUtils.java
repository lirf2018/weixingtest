package com.yufan.weixin;

import com.alibaba.fastjson.JSONObject;
import com.yufan.util.RequestUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人: lirf
 * 创建时间:  2017-09-11 14:03
 * 功能介绍: 信息接口调用工具类
 */
public class WeixinDevUtils {

    private static String appId = "wx0bdabad84b781956";
    private static String secret = "fc25df579812bbc6d80ac74d1198cb6f";

    public static String getAccessToken() {
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret + "&grant_type=client_credential";
            String result = RequestUtil.sendGet(url, null);
            JSONObject json = JSONObject.parseObject(result);
            String accessToken = json.getString("access_token");
            System.out.println("---------->accessToken=" + accessToken);
            return accessToken;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 测试发送模板消息
     */
    public static void sendModoTest(String accesstoken, String openId, JSONObject obj) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accesstoken;
        obj = new JSONObject();
        obj.put("touser", openId);
        obj.put("template_id", "NGMtvXQswNd1sU_0IhfSZtE1YVuiDk_HTUat5TullW8");
        obj.put("url", "www.baidu.com");
        obj.put("topcolor", "#FF0000");
        JSONObject data = new JSONObject();
        /************设置内容**************/
        //商品名称
        Map<String, Object> goodsName = new HashMap<String, Object>();
        goodsName.put("value", "狗不理包子\n");
        goodsName.put("color", "#173177");
        data.put("goodsName", goodsName);
        //商品价格
        Map<String, Object> goodsPrice = new HashMap<String, Object>();
        goodsPrice.put("value", "28.36\n");
        goodsPrice.put("color", "#173177");
        data.put("goodsPrice", goodsPrice);
        //remark
        Map<String, Object> remark = new HashMap<String, Object>();
        remark.put("value", "狗不理包子好吃\n");
        remark.put("color", "#173177");
        data.put("remark", remark);

        obj.put("data", data);
        System.out.println("obj.toString()=" + obj.toString());
        String result = RequestUtil.httpPost(url, obj.toString());
        System.out.println("result=" + result);


    }

    public static void main(String[] args) {
        getAccessToken();
    }

}
