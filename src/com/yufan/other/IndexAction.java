package com.yufan.other;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.yufan.common.LotFilterAction;
import com.yufan.other.WeixinBaseDev;
import com.yufan.util.Constant;

import java.io.PrintWriter;

/**
 * @功能名称 微信入口
 * @作者 lirongfan
 * @时间 2015年9月1日 上午11:22:54
 */
public class IndexAction extends LotFilterAction {

    private WeixinBaseDev weixinBaseDev = new WeixinBaseDev();
    /**
     * 获取微信参数
     */
    String appId = ""; // 必填，公众号的唯一标识
    String timestamp = ""; // 必填，生成签名的时间戳
    String nonceStr = ""; // 必填，生成签名的随机串
    String signature = "";// 必填，签名，见附录1

    /**
     * 入口index
     *
     * @return
     */
    public String index() {
        System.out.println("---------->入口index");

        /*扫码begin*/
        System.out.println("进入微信入口方法access_token------------>" + weixinBaseDev.getAccess_token());
        System.out.println("进入微信入口方法jsapi_ticket------------>" + weixinBaseDev.getJsapi_ticket(weixinBaseDev.getAccess_token()));
        appId = Constant.AppID;
        timestamp = weixinBaseDev.getTimestamp();
        nonceStr = weixinBaseDev.getNonceStr();
        weixinBaseDev.getJsApiTicket();
        signature = weixinBaseDev.getSignature();
        /*扫码end*/
//		WeixinGetMsgAction w=new WeixinGetMsgAction();
//		w.getAccess_token();

        return "success";
    }


    /**
     * 微信扫一扫  页面js
     */
    public void saosao() {
        try {
            System.out.println("微信扫一扫  页面Ajax");
            initData();
            String appId = Constant.AppID;
            String timestamp = weixinBaseDev.getTimestamp();
            String nonceStr = weixinBaseDev.getNonceStr();
            weixinBaseDev.getJsApiTicket();
            String signature = weixinBaseDev.getSignature();

            PrintWriter writer = response.getWriter();
            JSONObject obj = new JSONObject();
            obj.put("appId", appId);
            obj.put("timestamp", timestamp);
            obj.put("nonceStr", nonceStr);
            obj.put("signature", signature);
            writer.print(obj);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
