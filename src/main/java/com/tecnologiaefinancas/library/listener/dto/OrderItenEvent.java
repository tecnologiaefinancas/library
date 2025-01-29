package com.tecnologiaefinancas.library.listener.dto;

import java.math.BigDecimal;

public record OrderItenEvent(String book,
                             Integer quantity,
                             BigDecimal price) {
}
