package com.xgaslan.order.service.domain.dto.create;

import com.xgaslan.domain.valueObject.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final UUID trackingId;

    @NotNull
    private final OrderStatus status;

    @NotNull
    private final String message;
}
