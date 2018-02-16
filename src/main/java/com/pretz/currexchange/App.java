package com.pretz.currexchange;

import com.pretz.currexchange.cache.CurrencyCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(App.class, args);
    }

    @Bean
    CurrencyCache getCurrencyCache() {
        return new CurrencyCache();
    }
}
