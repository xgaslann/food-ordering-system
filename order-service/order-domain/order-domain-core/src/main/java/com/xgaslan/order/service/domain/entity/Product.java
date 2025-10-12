package com.xgaslan.order.service.domain.entity;

import com.xgaslan.domain.entity.BaseEntity;
import com.xgaslan.domain.valueObject.Money;
import com.xgaslan.domain.valueObject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}
