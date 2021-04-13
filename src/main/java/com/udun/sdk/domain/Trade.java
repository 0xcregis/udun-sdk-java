package com.udun.sdk.domain;

import java.math.BigDecimal;

public class Trade {
    //交易Id
    private String txId;
    //交易流水号
    private String tradeId;
    //交易地址
    private String address;
    //币种类型
    private String mainCoinType;
    //代币类型，erc20为合约地址
    private String coinType;
    //交易金额
    private BigDecimal amount;
    //交易类型  1-充值 2-提款(转账)
    private int tradeType;
    //交易状态 0-待审核 1-成功 2-失败,充值无审核
    private int status;
    //旷工费
    private BigDecimal fee;
    private int decimals;
    //提币申请单号
    private String businessId;
    //备注
    private String memo;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMainCoinType() {
        return mainCoinType;
    }

    public void setMainCoinType(String mainCoinType) {
        this.mainCoinType = mainCoinType;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
