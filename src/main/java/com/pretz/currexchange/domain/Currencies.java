package com.pretz.currexchange.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Currencies {

    private Map<String, BigDecimal> currencyMap;

    public Currencies() {
        currencyMap = new HashMap<>();
    }

    public void addCurrency(String code, BigDecimal rate) {
        currencyMap.put(code, rate);
    }
}
