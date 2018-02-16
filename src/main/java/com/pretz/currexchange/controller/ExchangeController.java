package com.pretz.currexchange.controller;

import com.pretz.currexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ExchangeController {
    private ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exService) {
        this.exchangeService = exService;
    }

    @RequestMapping(method = GET, path = "/exchange")
    public ResponseEntity<BigDecimal> exchangeCurrency(@RequestParam String amount, @RequestParam String entryCode, @RequestParam String targetCode) {
        return new ResponseEntity<>(exchangeService.exchange(amount, entryCode, targetCode), new HttpHeaders(), HttpStatus.OK);
    }
}
