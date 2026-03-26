package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.subscription.CheckoutRequest;
import com.application.vibecoding.vibecoding.dto.subscription.CheckoutResponse;
import com.application.vibecoding.vibecoding.dto.subscription.PortalResponse;
import com.application.vibecoding.vibecoding.security.AuthUtil;
import com.application.vibecoding.vibecoding.service.PaymentProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class stripePaymentProcessor implements PaymentProcessor {

    private final AuthUtil authUtil;

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request) {
        Long userId = authUtil.getCurrentUserId();
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}