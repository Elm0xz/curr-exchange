package com.pretz.currexchange.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pretz.currexchange.domain.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrenciesService {

    private final RestTemplate currenciesRestTemplate;
    private String nbpApiUrl;
    //private String currencies;

    @Autowired
    public CurrenciesService(RestTemplateBuilder restTemplateBuilder) {
        this.currenciesRestTemplate = restTemplateBuilder.build();
    }

    @Value("${currexchange.nbpurl}")
    public void setNbpApiUrl(String url) {
        this.nbpApiUrl = url;
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            String currenciesString = currenciesRestTemplate.getForObject(nbpApiUrl, String.class, "");
            Currencies[] currencies = new ObjectMapper().readValue(currenciesString, Currencies[].class);
        };
    }
}