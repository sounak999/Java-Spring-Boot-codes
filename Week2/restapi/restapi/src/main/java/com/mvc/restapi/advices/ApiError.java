package com.mvc.restapi.advices;

import org.springframework.http.HttpStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    private String message;
    private HttpStatus status;
}
