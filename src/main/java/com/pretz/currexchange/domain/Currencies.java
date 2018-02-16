package com.pretz.currexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currencies {

    private Date effectiveDate;
    private List<Currency> currencyList;

    public Currencies() {
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    @JsonProperty("rates")
    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "effectiveDate=" + effectiveDate +
                ", currencyList=" + currencyList +
                '}';
    }
}
