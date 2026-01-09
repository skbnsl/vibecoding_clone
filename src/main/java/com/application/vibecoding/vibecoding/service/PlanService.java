package com.application.vibecoding.vibecoding.service;

import com.application.vibecoding.vibecoding.dto.subscription.PlanResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
