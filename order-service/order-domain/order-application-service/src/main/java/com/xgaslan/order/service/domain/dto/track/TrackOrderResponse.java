package com.xgaslan.order.service.domain.dto.track;

import com.xgaslan.domain.valueObject.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderResponse {
    @NotNull
    private final UUID orderTrackingId;

    @NotNull
    private final OrderStatus orderStatus;

    private final List<String> failureMessages;

    public List<String> getFailureMessages() {
        return failureMessages == null ?
                Collections.emptyList() :
                Collections.unmodifiableList(failureMessages);
    }
}
