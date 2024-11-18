package com.mvc.restapi.controllers;

import com.mvc.restapi.dto.EmployeeDTO;
import com.mvc.restapi.entities.EmployeeEntity;
import com.mvc.restapi.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static java.time.LocalDate.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    private EmployeeEntity getEmployee(@PathVariable(name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    private List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    private EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @PutMapping
    private String dummy() {
        return "Dummy put msg to test";
    }
}
