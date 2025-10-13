package com.xgaslan.order.service.domain.mapper;

import com.xgaslan.domain.valueObject.CustomerId;
import com.xgaslan.domain.valueObject.Money;
import com.xgaslan.domain.valueObject.ProductId;
import com.xgaslan.domain.valueObject.RestaurantId;
import com.xgaslan.order.service.domain.dto.create.CreateOrderCommand;
import com.xgaslan.order.service.domain.dto.create.CreateOrderResponse;
import com.xgaslan.order.service.domain.dto.create.OrderAddress;
import com.xgaslan.order.service.domain.dto.create.OrderItemDto;
import com.xgaslan.order.service.domain.entity.Order;
import com.xgaslan.order.service.domain.entity.OrderItem;
import com.xgaslan.order.service.domain.entity.Product;
import com.xgaslan.order.service.domain.entity.Restaurant;
import com.xgaslan.order.service.domain.valueObject.StreetAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {
    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand){
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                        new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand){
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order){
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message("Order created successfully")
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(List<OrderItemDto> orderItems) {
        return orderItems.stream()
                .map(orderItem -> OrderItem.builder()
                        .product(new Product(new ProductId(orderItem.getProductId())))
                        .price(new Money(orderItem.getPrice()))
                        .quantity(orderItem.getQuantity())
                        .subTotal(new Money(orderItem.getSubTotal()))
                        .build())
                .collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }
}
