package com.xgaslan.order.service.domain.valueObject;

import com.xgaslan.domain.valueObject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    public TrackingId(UUID value) {
        super(value);
    }
}
