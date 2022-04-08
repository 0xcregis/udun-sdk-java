package com.uduncloud.sdk.client;

import com.uduncloud.sdk.domain.Address;
import com.uduncloud.sdk.domain.Coin;
import com.uduncloud.sdk.domain.ResultMsg;
import com.uduncloud.sdk.exception.UdunException;

import java.math.BigDecimal;
import java.util.List;

public interface UdunApi {
    /**
     * 创建币种地址，别名和钱包编号默认，回调地址使用统一配置
     *
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @return 地址
     */
    Address createAddress(String mainCoinType)  throws UdunException;

    /**
     * 创建币种地址，别名和钱包编号自定义，回调地址使用统一配置
     *
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @param alias        地址别名
     * @param walletId     钱包编号
     * @return 地址
     */
    Address createAddress(String mainCoinType, String alias, String walletId)  throws UdunException;

    /**
     * 创建币种地址，别名和钱包编号自定义，回调地址自定义
     *
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @param alias        地址别名
     * @param walletId     钱包编号
     * @param callUrl      回调地址
     * @return 地址
     */
    Address createAddress(String mainCoinType, String alias, String walletId, String callUrl) throws UdunException;


    /**
     * 提币，回调地址使用统一配置
     *
     * @param address      提币地址
     * @param amount       提币数量
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @param coinType     子币种编号,使用获取商户币种信息接口
     * @param businessId   业务编号，必须保证该字段在系统内唯一，如果重复，则该笔提币钱包将不会进行接收
     * @param memo         备注,XRP和EOS，这两种币的提币申请该字段可选，其他类型币种不填
     * @return 返回信息
     */
    ResultMsg withdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo);

    /**
     * 提币，回调地址自定义
     *
     * @param address      提币地址
     * @param amount       提币数量
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @param coinType     子币种编号,使用获取商户币种信息接口
     * @param businessId   业务编号，必须保证该字段在系统内唯一，如果重复，则该笔提币钱包将不会进行接收
     * @param memo         备注,XRP和EOS，这两种币的提币申请该字段可选，其他类型币种不填
     * @param callUrl      回调地址
     * @return 返回信息
     */
    ResultMsg withdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo, String callUrl);

    /**
     * 代付，回调地址使用统一配置
     *
     * @param address      提币地址
     * @param amount       提币数量
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @param coinType     子币种编号,使用获取商户币种信息接口
     * @param businessId   业务编号，必须保证该字段在系统内唯一，如果重复，则该笔提币钱包将不会进行接收
     * @param memo         备注,XRP和EOS，这两种币的提币申请该字段可选，其他类型币种不填
     * @return 返回信息
     */
    ResultMsg autoWithdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo);

    /**
     * 代付，回调地址自定义
     *
     * @param address      提币地址
     * @param amount       提币数量
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @param coinType     子币种编号,使用获取商户币种信息接口
     * @param businessId   业务编号，必须保证该字段在系统内唯一，如果重复，则该笔提币钱包将不会进行接收
     * @param memo         备注,XRP和EOS，这两种币的提币申请该字段可选，其他类型币种不填
     * @param callUrl      回调地址
     * @return 返回信息
     */
    ResultMsg autoWithdraw(String address, BigDecimal amount, String mainCoinType, String coinType, String businessId, String memo, String callUrl);

    /**
     * 检验地址合法性
     *
     * @param mainCoinType 主币种编号,使用获取商户币种信息接口
     * @param address      币种地址
     * @return 是否合法
     */
    boolean checkAddress(String mainCoinType, String address);

    /**
     * 获取商户支持的币种,以及余额
     *
     * @param showBalance 是否显示余额
     * @return 支持币种列表
     */
    List<Coin> listSupportCoin(boolean showBalance);
}
