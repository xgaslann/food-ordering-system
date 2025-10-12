package com.xgaslan.order.service.domain.ports.output.repository;

import com.xgaslan.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
