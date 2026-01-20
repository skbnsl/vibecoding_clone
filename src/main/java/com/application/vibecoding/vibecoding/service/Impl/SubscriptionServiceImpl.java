package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.subscription.CheckoutRequest;
import com.application.vibecoding.vibecoding.dto.subscription.CheckoutResponse;
import com.application.vibecoding.vibecoding.dto.subscription.PortalResponse;
import com.application.vibecoding.vibecoding.dto.subscription.SubscriptionResponse;
import com.application.vibecoding.vibecoding.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
