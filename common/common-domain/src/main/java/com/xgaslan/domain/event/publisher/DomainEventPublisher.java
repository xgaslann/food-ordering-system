package com.xgaslan.domain.event.publisher;

import com.xgaslan.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent>{

    void publish(T domainEvent);
}
