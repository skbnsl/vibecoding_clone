package com.application.vibecoding.vibecoding.entity;

import com.application.vibecoding.vibecoding.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {

    private Long id;

    User user;
    Plan plan;

    SubscriptionStatus status;

    //String stripeCustomerId;
    String stripeSubscriptionId;

    Instant currentPeriodStart;
    Instant currentPeriodEnd;

    Boolean cancelAtPeriodEnd = false;

    Instant createdAt;

    Instant updatedAt;
}