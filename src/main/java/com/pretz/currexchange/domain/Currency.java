package com.pretz.currexchange.domain;

import java.math.BigDecimal;

public class Currency {

    private String code;
    private BigDecimal mid;

    public Currency() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", mid=" + mid +
                '}';
    }
}
