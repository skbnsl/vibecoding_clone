package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.subscription.CheckoutRequest;
import com.application.vibecoding.vibecoding.dto.subscription.CheckoutResponse;
import com.application.vibecoding.vibecoding.dto.subscription.PortalResponse;
import com.application.vibecoding.vibecoding.entity.Plan;
import com.application.vibecoding.vibecoding.entity.User;
import com.application.vibecoding.vibecoding.error.ResourceNotFoundException;
import com.application.vibecoding.vibecoding.repository.PlanRepository;
import com.application.vibecoding.vibecoding.repository.UserRepository;
import com.application.vibecoding.vibecoding.security.AuthUtil;
import com.application.vibecoding.vibecoding.service.PaymentProcessor;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class stripePaymentProcessor implements PaymentProcessor {

    private final AuthUtil authUtil;
    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    @Value("${client.url}")
    private String frontendUrl;

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request) {
        Plan plan = planRepository.findById(request.planId()).orElseThrow( () ->
                    new ResourceNotFoundException("planId",request.planId().toString())
                );
        Long userId = authUtil.getCurrentUserId();
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("user", userId.toString()));

        var params = SessionCreateParams.builder()
                .addLineItem(
                        SessionCreateParams.LineItem.builder().setPrice(plan.getStripePriceId()).setQuantity(1L).build())
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .setSubscriptionData(
                        SessionCreateParams.SubscriptionData.builder()
                                .setBillingMode(
                                        SessionCreateParams.SubscriptionData.BillingMode.builder()
                                                .setType(SessionCreateParams.SubscriptionData.BillingMode.Type.FLEXIBLE)
                                                .build()
                                )
                                .build()
                )
                .setSuccessUrl(frontendUrl + "/success.html?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(frontendUrl + "/cancel.html")
                .putMetadata("user_id", userId.toString())
                .putMetadata("plan_id", plan.getId().toString())
                .build();
        try {

            String stripeCustomerId = user.getStripeCustomerId();

            if(stripeCustomerId==null || stripeCustomerId.isEmpty()){
                params.setCustomerEmail(user.getUsername());
            } else {
                params.setCustomer(stripeCustomerId); //stripe customer id
            }

            Session session = Session.create(params.build()); //making an api call to stripe backend
            return new CheckoutResponse(session.getUrl());
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
