package com.uduncloud.sdk.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

public class UdunUtils {
    public static String post(String gateway, String merchantKey, String path, String body) {
        HttpResponse response = HttpRequest.post(gateway + path).body(parseParams(merchantKey, body)).execute();
        return response.body();
    }

    public static String parseParams(String merchantKey, String body) {
        Map<String, String> params = new HashMap<>();
        String timestamp = System.currentTimeMillis() + "";
        String nonce = RandomUtil.randomString(6);
        String sign = sign(merchantKey, timestamp, nonce, body);
        params.put("timestamp", timestamp);
        params.put("nonce", nonce);
        params.put("sign", sign);
        params.put("body", body);
        return JSONUtil.toJsonStr(params);
    }

    public static String sign(String key, String timestamp, String nonce, String body) {
        String raw = body + key + nonce + timestamp;
        return SecureUtil.md5(raw);
    }

    public static boolean checkSign(String key, String timestamp, String nonce, String body, String sign) {
        String checkSign = sign(key, timestamp, nonce, body);
        return checkSign.equals(sign);
    }
}
