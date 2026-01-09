package com.application.vibecoding.vibecoding.dto.usage;

public record UsageTodayResponse(
        Integer tokenUsed,
        Integer tokensLimit,
        Integer previewsRunning,
        Integer previewsList
) {
}
