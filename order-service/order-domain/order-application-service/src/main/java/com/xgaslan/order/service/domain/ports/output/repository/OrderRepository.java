package com.xgaslan.order.service.domain.ports.output.repository;

import com.xgaslan.order.service.domain.entity.Order;
import com.xgaslan.order.service.domain.valueObject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
