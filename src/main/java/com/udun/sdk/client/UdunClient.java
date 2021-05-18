package com.udun.sdk.client;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.udun.sdk.constant.ApiPath;
import com.udun.sdk.domain.Address;
import com.udun.sdk.domain.Coin;
import com.udun.sdk.domain.ResultMsg;
import com.udun.sdk.util.UdunUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UdunClient implements UdunApi {
    /**
     * 网关
     */
    private final String gateway;
    /**
     * 商户编号
     */
    private final String merchantId;
    /**
     * 商户key
     */
    private final String merchantKey;
    /**
     * 默认回调地址
     */
    private final String defaultCallBackUrl;

    public UdunClient(String gateway, String merchantId, String merchantKey, String defaultCallBackUrl) {
        this.gateway = gateway;
        this.merchantId = merchantId;
        this.merchantKey = merchantKey;
        this.defaultCallBackUrl = defaultCallBackUrl;
    }

    @Override
    public Address createAddress(String mainCoinType) {
        return createAddress(mainCoinType, "", "", defaultCallBackUrl);
    }

    @Override
    public Address createAddress(String mainCoinType, String alias, String walletId) {
        return createAddress(mainCoinType, alias, walletId, defaultCallBackUrl);
    }

    @Override
    public Address createAddress(String mainCoinType, String alias, String walletId, String callUrl) {
        Map<String, String> params = new HashMap<>();
        params.put("merchantId", merchantId);
        params.put("coinType", mainCoinType);
        params.put("callUrl", callUrl);
        params.put("walletId", walletId);
        params.put("alias", alias);

        ResultMsg result = JSONUtil.toBean(UdunUtils.post(gateway, merchantKey, ApiPath.CREATE_ADDRESS, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
        if (result.getCode() != HttpStatus.HTTP_OK) {
            Console.error(JSONUtil.toJsonStr(result));
            return null;
        }
        return JSONUtil.toBean(result.getData(), Address.class);
    }

    @Override
    public ResultMsg withdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo) {
        return withdraw(address, amount, mainCoinType, coinType, businessId, memo, defaultCallBackUrl);
    }

    @Override
    public ResultMsg withdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo, String callUrl) {
        Map<String, Object> params = new HashMap<>();
        params.put("address", address);
        params.put("amount", amount);
        params.put("merchantId", merchantId);
        params.put("mainCoinType", mainCoinType);
        params.put("coinType", coinType);
        params.put("callUrl", callUrl);
        params.put("businessId", businessId);
        params.put("memo", memo);
        return JSONUtil.toBean(UdunUtils.post(gateway, merchantKey, ApiPath.WITHDRAW, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
    }

    @Override
    public ResultMsg proxyPay(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo) {
        return proxyPay(address, amount, mainCoinType, coinType, businessId, memo, defaultCallBackUrl);
    }

    @Override
    public ResultMsg proxyPay(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo, String callUrl) {
        Map<String, Object> params = new HashMap<>();
        params.put("address", address);
        params.put("amount", amount);
        params.put("merchantId", merchantId);
        params.put("mainCoinType", mainCoinType);
        params.put("coinType", coinType);
        params.put("callUrl", callUrl);
        params.put("businessId", businessId);
        params.put("memo", memo);
        return JSONUtil.toBean(UdunUtils.post(gateway, merchantKey, ApiPath.AUTO_WITHDRAW, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
    }

    @Override
    public boolean checkAddress(String mainCoinType, String address) {
        Map<String, String> params = new HashMap<>();
        params.put("merchantId", merchantId);
        params.put("mainCoinType", mainCoinType);
        params.put("address", address);
        ResultMsg result = JSONUtil.toBean(UdunUtils.post(gateway, merchantKey, ApiPath.CHECK_ADDRESS, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
        return result.getCode() == HttpStatus.HTTP_OK;
    }

    @Override
    public List<Coin> listSupportCoin(boolean showBalance) {
        Map<String, Object> params = new HashMap<>();
        params.put("merchantId", merchantId);
        params.put("showBalance", showBalance);
        ResultMsg result = JSONUtil.toBean(UdunUtils.post(gateway, merchantKey, ApiPath.SUPPORT_COIN, JSONUtil.toJsonStr(params)), ResultMsg.class);
        if (result.getCode() != HttpStatus.HTTP_OK) {
            Console.error(JSONUtil.toJsonStr(result));
            return null;
        }
        return JSONUtil.toList(JSONUtil.parseArray(result.getData()), Coin.class);
    }
}
