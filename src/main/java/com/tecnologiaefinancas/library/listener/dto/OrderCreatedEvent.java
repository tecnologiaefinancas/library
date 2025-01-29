package com.tecnologiaefinancas.library.listener.dto;

import com.tecnologiaefinancas.library.entity.OrderIten;

import java.util.List;

public record OrderCreatedEvent(Long orderCode,
                                Long customerCode,
                                List<OrderItenEvent> itens) {
}
