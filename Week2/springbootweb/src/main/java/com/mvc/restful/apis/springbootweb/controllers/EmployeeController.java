package com.mvc.restful.apis.springbootweb.controllers;

import com.mvc.restful.apis.springbootweb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {
//    @GetMapping(path = "/getMessage")
//    public String getSecretMessage() {
//        return "This is secret message only shown in the path /getMessage";
//    }

    @GetMapping(path = "employee/{employeeId}")
    public EmployeeDTO getEmployeeById (@PathVariable Long employeeId) {
        return new EmployeeDTO(employeeId, "Sounak", "sounak.saha@org.in", 23, LocalDate.of(2022, 8, 23), true);
    }
}
