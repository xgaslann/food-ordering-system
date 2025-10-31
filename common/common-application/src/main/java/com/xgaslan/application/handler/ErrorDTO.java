package com.xgaslan.application.handler;

import lombok.Builder;

@Builder
public record ErrorDTO(String code, String message) {
}
