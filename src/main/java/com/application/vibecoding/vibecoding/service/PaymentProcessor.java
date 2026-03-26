package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.subscription.CheckoutRequest;
import com.application.vibecoding.vibecoding.dto.subscription.CheckoutResponse;
import com.application.vibecoding.vibecoding.dto.subscription.PortalResponse;

public interface PaymentProcessor{

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal(Long userId);

}
