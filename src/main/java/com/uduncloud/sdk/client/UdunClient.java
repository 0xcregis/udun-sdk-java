package com.uduncloud.sdk.client;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.uduncloud.sdk.constant.ApiPath;
import com.uduncloud.sdk.domain.Address;
import com.uduncloud.sdk.domain.Coin;
import com.uduncloud.sdk.domain.ResultMsg;
import com.uduncloud.sdk.exception.UdunException;
import com.uduncloud.sdk.util.UdunUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UdunClient implements UdunApi {
    private static Logger logger = LoggerFactory.getLogger(UdunClient.class);

    /**
     * UDUN API Gateway
     */
    private final String gateway;

    /**
     * UDUN Merchant Number
     */
    private final String merchantId;

    /**
     * UDUN Merchant Key
     */
    private final String merchantKey;

    /**
     * Callback to business system
     */
    private final String defaultCallBackUrl;

    public UdunClient(String gateway, String merchantId, String merchantKey, String defaultCallBackUrl) {
        this.gateway = gateway;
        this.merchantId = merchantId;
        this.merchantKey = merchantKey;
        this.defaultCallBackUrl = defaultCallBackUrl;
    }

    @Override
    public Address createAddress(String mainCoinType)  throws UdunException{
        return createAddress(mainCoinType, "", "", defaultCallBackUrl);
    }

    @Override
    public Address createAddress(String mainCoinType, String alias, String walletId)  throws UdunException{
        return createAddress(mainCoinType, alias, walletId, defaultCallBackUrl);
    }

    @Override
    public Address createAddress(String mainCoinType, String alias, String walletId, String callUrl) throws UdunException{
        Map<String, String> params = new HashMap<>();
        params.put("merchantId", merchantId);
        params.put("coinType", mainCoinType);
        params.put("callUrl", callUrl);
        params.put("walletId", walletId);
        params.put("alias", alias);

        ResultMsg result = JSONUtil.toBean(UdunUtils.post(gateway, merchantKey, ApiPath.CREATE_ADDRESS, StrUtil.format("[{}]", JSONUtil.toJsonStr(params))), ResultMsg.class);
        if (result.getCode() != HttpStatus.HTTP_OK) {
            logger.error("createAddress:{}",JSONUtil.toJsonStr(result));
            throw new UdunException(result.getCode(), result.getMessage());
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
    public ResultMsg autoWithdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo) {
        return autoWithdraw(address, amount, mainCoinType, coinType, businessId, memo, defaultCallBackUrl);
    }

    @Override
    public ResultMsg autoWithdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo, String callUrl) {
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
