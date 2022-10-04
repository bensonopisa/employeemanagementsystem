package com.stackdevs.EMS.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponse<T> {
    private int code;
    private String status;
    private String message;
    private T data;
}
