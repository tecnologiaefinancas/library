package com.tecnologiaefinancas.library.repository;

import com.tecnologiaefinancas.library.controller.dto.OrderResponse;
import com.tecnologiaefinancas.library.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

    Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}
