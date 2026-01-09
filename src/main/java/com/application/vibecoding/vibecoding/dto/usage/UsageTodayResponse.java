package com.application.vibecoding.vibecoding.dto.usage;

public record UsageTodayResponse(
        int tokenUsed,
        int tokensLimit,
        int previewsRunning,
        int previewsList
) {
}
