package com.tecnologiaefinancas.library.controller.dto;

import com.tecnologiaefinancas.library.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(String orderId,
                            Long customerId,
                            BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity entity){
        return new OrderResponse(entity.getOrderId(), entity.getCustomerId(), entity.getTotal());
    }
}
