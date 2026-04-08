package com.application.vibecoding.vibecoding.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class PaymentConfig {

    @Value("${stripe.api.secret}")
    private String stripeSecretKey;

    @PostConstruct
    public void init(){
        log.info("stripeSecretKey: {}", stripeSecretKey);
        Stripe.apiKey = stripeSecretKey;
    }

}
