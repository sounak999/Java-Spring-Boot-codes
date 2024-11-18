package com.mvc.restapi.controllers;

import com.mvc.restapi.dto.EmployeeDTO;
import com.mvc.restapi.entities.EmployeeEntity;
import com.mvc.restapi.repositories.EmployeeRepository;
import com.mvc.restapi.services.EmployeeService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static java.time.LocalDate.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    private EmployeeDTO getEmployee(@PathVariable(name = "employeeId") Long id) {
        return employeeService.findById(id);
    }

    @GetMapping
    private List<EmployeeDTO> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping
    private EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

    @PutMapping
    private String dummy() {
        return "Dummy put msg to test";
    }
}
