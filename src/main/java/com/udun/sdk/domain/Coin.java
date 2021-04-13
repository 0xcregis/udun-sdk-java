package com.udun.sdk.domain;

import java.math.BigDecimal;

public class Coin {
    private String name;
    private String symbol;
    private String mainCoinType;
    private String coinType;
    private String decimals;
    private Integer tokenStatus;
    private String mainSymbol;
    private BigDecimal balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public String getDecimals() {
        return decimals;
    }

    public void setDecimals(String decimals) {
        this.decimals = decimals;
    }

    public Integer getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(Integer tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public String getMainSymbol() {
        return mainSymbol;
    }

    public void setMainSymbol(String mainSymbol) {
        this.mainSymbol = mainSymbol;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
