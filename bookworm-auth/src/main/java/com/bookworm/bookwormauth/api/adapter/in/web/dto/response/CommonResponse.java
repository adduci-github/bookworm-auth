package com.bookworm.bookwormauth.api.adapter.in.web.dto.response;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private T data;
    private String message;
}
