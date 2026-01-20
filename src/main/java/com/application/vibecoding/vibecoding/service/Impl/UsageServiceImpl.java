package com.application.vibecoding.vibecoding.service.Impl;

import com.application.vibecoding.vibecoding.dto.usage.PlanLimitsResponse;
import com.application.vibecoding.vibecoding.dto.usage.UsageTodayResponse;
import com.application.vibecoding.vibecoding.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId) {
        return null;
    }
}
