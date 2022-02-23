package com.uduncloud.sdk.domain;


public class Address {
    private String address;
    private int coinType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCoinType() {
        return coinType;
    }

    public void setCoinType(int coinType) {
        this.coinType = coinType;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", coinType=" + coinType +
                '}';
    }
}
