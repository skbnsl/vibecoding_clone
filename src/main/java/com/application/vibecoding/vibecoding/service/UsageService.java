package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.usage.PlanLimitsResponse;
import com.application.vibecoding.vibecoding.dto.usage.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {

    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId);
}
