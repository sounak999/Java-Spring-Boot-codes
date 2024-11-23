package com.mvc.restapi.advices;

import org.springframework.http.HttpStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiError {
    private String message;
    private HttpStatus status;
    private List<String> subErrors;
}
