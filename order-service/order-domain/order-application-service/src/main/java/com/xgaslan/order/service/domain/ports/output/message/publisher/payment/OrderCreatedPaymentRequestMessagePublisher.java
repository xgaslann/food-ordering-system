package com.xgaslan.order.service.domain.ports.output.message.publisher.payment;

import com.xgaslan.domain.event.publisher.DomainEventPublisher;
import com.xgaslan.order.service.domain.entity.Order;
import com.xgaslan.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
