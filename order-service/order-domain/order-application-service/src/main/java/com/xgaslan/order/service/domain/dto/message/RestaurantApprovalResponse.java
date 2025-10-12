package com.xgaslan.order.service.domain.dto.message;

import com.xgaslan.domain.valueObject.OrderApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalResponse {
    private final String id;

    private final String sagaId;

    private final String orderId;

    private final String restaurantId;

    private final Instant createdAt;

    private OrderApprovalStatus orderApprovalStatus;

    private final List<String> failureMessages;

    public List<String> getFailureMessages() {
        return failureMessages == null ?
                Collections.emptyList() :
                Collections.unmodifiableList(failureMessages);
    }
}
