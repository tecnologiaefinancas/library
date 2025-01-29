package com.tecnologiaefinancas.library.entity;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

public class OrderIten {

    private String book;
    private Integer quantity;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;

    public OrderIten() {
    }

    public OrderIten(String book, Integer quantity, BigDecimal price) {
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
