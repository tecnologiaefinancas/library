package com.tecnologiaefinancas.library.service;

import com.tecnologiaefinancas.library.controller.dto.OrderResponse;
import com.tecnologiaefinancas.library.entity.OrderEntity;
import com.tecnologiaefinancas.library.entity.OrderIten;
import com.tecnologiaefinancas.library.listener.dto.OrderCreatedEvent;
import com.tecnologiaefinancas.library.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderCreatedEvent event){

        var entity = new OrderEntity();

        entity.setOrderId(String.valueOf(event.orderCode()));
        entity.setCustomerId(event.customerCode());
        entity.setItens(getOrderItens(event));
        entity.setTotal(getTotal(event));

        orderRepository.save(entity);
    }

    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest){
        var orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

        return orders.map(OrderResponse::fromEntity);
    }

    private BigDecimal getTotal(OrderCreatedEvent event){
        return event.itens()
                .stream()
                .map(i -> i.price().multiply(BigDecimal.valueOf(i.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderIten> getOrderItens(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> new OrderIten(i.book(), i.quantity(), i.price()))
                .toList();
    }
}
