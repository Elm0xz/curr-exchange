package com.pretz.currexchange.service;

import com.pretz.currexchange.cache.CurrencyCache;
import com.pretz.currexchange.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeService {
    private final CurrencyCache currencyCache;

    @Autowired
    public ExchangeService(CurrencyCache currCache) {
        this.currencyCache = currCache;
    }

    public BigDecimal exchange(String amount, String entryCode, String targetCode) {

        List<Currency> currencyList = currencyCache.getCurrencies().getCurrencyList();
        List<Currency> entryCurrency = currencyList.stream().filter(curr -> curr.getCode().equals(entryCode)).collect(Collectors.toList());
        List<Currency> targetCurrency = currencyList.stream().filter(curr -> curr.getCode().equals(targetCode)).collect(Collectors.toList());

        BigDecimal parsedAmount = new BigDecimal(amount);
        BigDecimal entryMid = entryCurrency.get(0).getMid();
        BigDecimal targetMid = targetCurrency.get(0).getMid();

        return parsedAmount.multiply(entryMid.divide(targetMid, 8, BigDecimal.ROUND_DOWN));
    }

}
