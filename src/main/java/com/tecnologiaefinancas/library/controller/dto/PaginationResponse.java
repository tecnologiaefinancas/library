package com.tecnologiaefinancas.library.controller.dto;

public record PaginationResponse(Integer page,
                                Integer pageSize,
                                Integer totalElements,
                                 Integer totalPages) {
}
