package com.yufan.util;

/**
 * 创建人: lirf
 * 创建时间:  2019/5/28 16:14
 * 功能介绍:
 */
public class AlipayConfig {
    // 商户appid
    public static String APPID = "2016092900624822";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://lrf-13418915218.6655.la/weixingtest/index/alipayCallBack";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://lrf-13418915218.6655.la/weixingtest/";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";

    // 支付宝公钥(RSA2(SHA256)密钥(推荐)(应用公钥)
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkED5YaI1Eo0im70PMZim2XpNRYbTGs46QpEfalfggmsvtxCUEezmfbtWrr8iwSbRxX4QKnK84JQGkwBB1nH62G7a1qieQdKr7lmuCQn9bScHVt0sv7HviOzeocT5Yd03T2+ej0QNvELuKMhA6kuunHQyB3cPagdwqgblRGhXBIbE2XsQhWpfc8jEtlqrjGLxVadZ+heu7tcB6rkeb7imrsMGrqyRWK8RKA3BavUPQ0NNKB5gRAjh8Mxfez4QzVVFwPwtSf5zTzbHy4Wg5JX4Oo21Yedqh4Q9jq8s3ZwhOqZWNkbdCn94NmS0TogTPILqbrG+eEIu7HBvoY4jEHeGJwIDAQAB";

    //应用公钥
    public static String APP_PUBLIC_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDL3s6VOS7eQxpE7McdQogo1WS64FGqkUr/cRowCd3EvSoFIwy4KKmv9KhZxrRhyjRXx0PoROfxCj6Y/ji90S8U7/kQbixiHxeIhyq0cmol/aMstRNt0KsYLAgIZ2MSAtS6Q2MqawB96FrpRKjbdFIixIYbKERrc6jPf52NYAmFccbNuVZv9iFw51tedr4a9kpfZuPVq6Fi8U9NEjOLUBAgQiaT4kibs1e2j4WRqYpfrcx82Cxw5FbuA7uLkWtSf89HjJHy1a0xYb30cynHMfCCqRiwjwTCUPcTx+1wpicPt+gepJWaUGCZARYGjSMMfVKtCOvYhXFYrMdJj0FoqC3pAgMBAAECggEAT0JdIEit/v0pjlhbhPWjx/RGiBzDw0NfW/YVz01WqbE9T+fzfvlYFy9P8C8/W7FoLiQrM3bukZiBA6v6VVmpK0OsmgWrPa6G0K50HNlKiWCVesEfP5dbnTcpHFNNgegV2iBuwkP9WfXmuj/WQhN0B05OMOqzxu6dV6Zuk1MeAIGsVky842K02ooJwcqZqoAmSAI1Y0jsSwV/VUPVJFW3FKh2c0pAHNmCVUuA3ciQBtofIS4Y5Jr+RRiBkNuuXujK0Tx9APmWTF0owrzQVor7Gj9IVQXnGex6bV/Ujh2c86NEFcWhTW/oCNjY8oQmBIgyTvQ5tlUwhzWmCuAQGyrwnQKBgQD0VjKvv6f2XGyeIowN1awKcA+3Zg/ZrlM8iBNz+5vv6YLboTAzKG7gyMqmntM2YKW4o8D3aka9jqSox/cpbksyfjXwWV5fDvZqqJJluqYItrIwEcVkwqPSJvvH+V0uwvSd5hML0E5v8aOj0EYDoHRx16SGHtOrx57F/DEozGNouwKBgQDVmhvTBus1SSjW0RFyekMjaJQjRIgkOS+oa1HRHNUEY3u2Voz0SuPvveT2ATNo83xJd+tJ8ApBAQSEx4Iw/FFfARGaQpl76Utu8riI76Bqe24TfWW93JMbj+0IUZhf4w+iL7WgyYDLgCkw8y4COiq1srunMwJA59VGQLyfhAibqwKBgQCAMuHxWKv2FVRgPFwjviLAbz+vyHs0icTek78xMakF3g1s00wI64QRqQi7F8ZWV6tcD39l0XtAZiF69UB3mokV+yat7xYW5jDgkYYOnjoThFhF5G0fiwiNcSrWJ75+lIfoeRkxL6CYF772aobxzDSMrsqCHJaPIPPriYD5mRPnlQKBgE13TpAB+lug5MbDm+hAnwjAbLk9qYI5mychhNKp+jdVPRCr4wLWBkR0Qg1V8icl5vVeIF74Rz+79r+Q+454c6pY4OFpNfDScyERtgsznKIBkbJP0A5DaLaeRAC4VuKvnoPbeauOaL9lA4tVJmJ4ZfTvlU7WGQMhESAhakcPw29xAoGABvQ4KnEhEEMbUQnomzg+pAFmcT4eCQhQwP+cNkSEGJMohmu8+nQXykL/QomImqWJxpjvgPFaLTEOKRb57QRVeCqb6HypO1QXprCjtKFofwdRtVoeeU6wEe+F9wp0Hr40yr2flizQQO4BQgRSVoU1lGceJbWA5/E9UUqaICSDiZk=";
    //应用私钥
    public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDL3s6VOS7eQxpE7McdQogo1WS64FGqkUr/cRowCd3EvSoFIwy4KKmv9KhZxrRhyjRXx0PoROfxCj6Y/ji90S8U7/kQbixiHxeIhyq0cmol/aMstRNt0KsYLAgIZ2MSAtS6Q2MqawB96FrpRKjbdFIixIYbKERrc6jPf52NYAmFccbNuVZv9iFw51tedr4a9kpfZuPVq6Fi8U9NEjOLUBAgQiaT4kibs1e2j4WRqYpfrcx82Cxw5FbuA7uLkWtSf89HjJHy1a0xYb30cynHMfCCqRiwjwTCUPcTx+1wpicPt+gepJWaUGCZARYGjSMMfVKtCOvYhXFYrMdJj0FoqC3pAgMBAAECggEAT0JdIEit/v0pjlhbhPWjx/RGiBzDw0NfW/YVz01WqbE9T+fzfvlYFy9P8C8/W7FoLiQrM3bukZiBA6v6VVmpK0OsmgWrPa6G0K50HNlKiWCVesEfP5dbnTcpHFNNgegV2iBuwkP9WfXmuj/WQhN0B05OMOqzxu6dV6Zuk1MeAIGsVky842K02ooJwcqZqoAmSAI1Y0jsSwV/VUPVJFW3FKh2c0pAHNmCVUuA3ciQBtofIS4Y5Jr+RRiBkNuuXujK0Tx9APmWTF0owrzQVor7Gj9IVQXnGex6bV/Ujh2c86NEFcWhTW/oCNjY8oQmBIgyTvQ5tlUwhzWmCuAQGyrwnQKBgQD0VjKvv6f2XGyeIowN1awKcA+3Zg/ZrlM8iBNz+5vv6YLboTAzKG7gyMqmntM2YKW4o8D3aka9jqSox/cpbksyfjXwWV5fDvZqqJJluqYItrIwEcVkwqPSJvvH+V0uwvSd5hML0E5v8aOj0EYDoHRx16SGHtOrx57F/DEozGNouwKBgQDVmhvTBus1SSjW0RFyekMjaJQjRIgkOS+oa1HRHNUEY3u2Voz0SuPvveT2ATNo83xJd+tJ8ApBAQSEx4Iw/FFfARGaQpl76Utu8riI76Bqe24TfWW93JMbj+0IUZhf4w+iL7WgyYDLgCkw8y4COiq1srunMwJA59VGQLyfhAibqwKBgQCAMuHxWKv2FVRgPFwjviLAbz+vyHs0icTek78xMakF3g1s00wI64QRqQi7F8ZWV6tcD39l0XtAZiF69UB3mokV+yat7xYW5jDgkYYOnjoThFhF5G0fiwiNcSrWJ75+lIfoeRkxL6CYF772aobxzDSMrsqCHJaPIPPriYD5mRPnlQKBgE13TpAB+lug5MbDm+hAnwjAbLk9qYI5mychhNKp+jdVPRCr4wLWBkR0Qg1V8icl5vVeIF74Rz+79r+Q+454c6pY4OFpNfDScyERtgsznKIBkbJP0A5DaLaeRAC4VuKvnoPbeauOaL9lA4tVJmJ4ZfTvlU7WGQMhESAhakcPw29xAoGABvQ4KnEhEEMbUQnomzg+pAFmcT4eCQhQwP+cNkSEGJMohmu8+nQXykL/QomImqWJxpjvgPFaLTEOKRb57QRVeCqb6HypO1QXprCjtKFofwdRtVoeeU6wEe+F9wp0Hr40yr2flizQQO4BQgRSVoU1lGceJbWA5/E9UUqaICSDiZk=";

    // RSA2
    public static String SIGNTYPE = "RSA2";
}