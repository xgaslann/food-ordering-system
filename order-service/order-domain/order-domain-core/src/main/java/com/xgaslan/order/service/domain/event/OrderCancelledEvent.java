package com.xgaslan.order.service.domain.event;

import com.xgaslan.domain.event.DomainEvent;
import com.xgaslan.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {
    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
