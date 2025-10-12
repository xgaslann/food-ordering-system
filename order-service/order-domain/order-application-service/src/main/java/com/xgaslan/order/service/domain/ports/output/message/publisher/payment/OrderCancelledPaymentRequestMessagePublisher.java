package com.xgaslan.order.service.domain.ports.output.message.publisher.payment;

import com.xgaslan.domain.event.publisher.DomainEventPublisher;
import com.xgaslan.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
