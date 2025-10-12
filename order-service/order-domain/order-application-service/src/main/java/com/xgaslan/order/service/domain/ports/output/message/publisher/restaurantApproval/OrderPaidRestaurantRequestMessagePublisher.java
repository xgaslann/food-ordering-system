package com.xgaslan.order.service.domain.ports.output.message.publisher.restaurantApproval;

import com.xgaslan.domain.event.publisher.DomainEventPublisher;
import com.xgaslan.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
