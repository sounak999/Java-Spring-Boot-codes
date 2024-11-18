package com.mvc.restapi.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeService {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate DateOfJoining;
    private boolean isActive;
}
