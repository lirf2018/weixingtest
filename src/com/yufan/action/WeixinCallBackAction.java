package com.yufan.action;

import com.alibaba.fastjson.JSONObject;
import com.yufan.common.LotFilterAction;
import com.yufan.util.Sha1Util;
import com.yufan.util.XmlConverJsonUtil;
import com.yufan.weixin.WeixinDevUtils;
import com.yufan.weixin.WeixinInformation;
import com.yufan.weixin.bean.msg.RequestMessage;
import com.yufan.weixin.bean.msg.ResponseMessage;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 创建人: lirf
 * 创建时间:  2017-09-11 11:12
 * 功能介绍:
 */
public class WeixinCallBackAction extends LotFilterAction {


    public void weixinCallBackAction() {
        initData();
//        access(request,response);//认证
        System.out.println("---->微信回调开始");
        try {
            String accessToken = WeixinDevUtils.getAccessToken();
//            String accessToken = "1YkNSrQWEEG_zqt5gR2uHeCuzANo4aMTFRxzrsOk9b3f7J2nOXGlINIgN-xyd8pbWFjNR1dvIVTDLtUU99WchSziMMxzy7kJ-u0wGhnrBcXe1dT_cCZEnU5TKUjQsQoRPTKiAJAGKB";
            String message = null;
            message = request.getParameter("message");
            if (null == message || "".equals(message)) {
                message = readStreamParameter(request.getInputStream());
            }
            RequestMessage inputMsg = XmlConverJsonUtil.xmlToBean(message, RequestMessage.class);
//            System.out.println(JSONObject.toJSONString(inputMsg));

//            //被动回复
            String content = "欢迎关注“程序员编程”\n" +
                    "-------------------\n" +
                    "回复数字“1”即可领取微信小程序源码以及视频教程。\n" +
                    "回复数字“2”即可领取2.5G Android项目源码。\n" +
                    "回复数字“3”即可领取IOS、JavaWeb、Hadoop、.net、PHP资料。\n" +
                    "回复数字“4”即可领取C++、Web、Python、微信公众号开发、Java、Linux资料。\n" +
                    "回复数字“5”即可领取Unity3d、reachnative、淘淘商城视频及源码、Web前端、人工智能资料。\n" +
                    "———————————";
            String servername = inputMsg.getToUserName();// 服务端
            String custermname = inputMsg.getFromUserName();// 客户端
            if ("o0h3Ps_RnNdnZxMrgM906qRfpvLI".equals(custermname)) {
                content = "李融凡";
            } else if ("o0h3Psxp0dgnVYUGME2IC8UEPBuc".equals(custermname)) {
                content = "可乐果";
            }


            String outXml = WeixinInformation.responseTextMsgXML(content, servername, custermname);
            PrintWriter writer = response.getWriter();
            writer.write(outXml);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---->微信回调结束");
    }

    /**
     * 验证URL真实性  http://lrf-13418915218.6655.la/weixingtest/index/weixinCallBack
     *
     * @param request
     * @param response
     * @return String
     * @author morning
     * @date 2015年2月17日 上午10:53:07
     */
    private String access(HttpServletRequest request, HttpServletResponse response) {
        // 验证URL真实性
        System.out.println("进入验证access");
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");// 随机数
        String echostr = request.getParameter("echostr");// 随机字符串
        List<String> params = new ArrayList<String>();
        params.add("weixintoken");//在配置页面填写的token
        params.add(timestamp);
        params.add(nonce);
        // 1. 将token、timestamp、nonce三个参数进行字典序排序
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = Sha1Util.getSha1(params.get(0) + params.get(1) + params.get(2));
        if (temp.equals(signature)) {
            try {
                response.getWriter().write(echostr);
                System.out.println("成功返回 echostr：" + echostr);
                return echostr;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("接口 认证 失败");
        return null;
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
