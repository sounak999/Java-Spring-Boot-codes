package com.mvc.restful.apis.springbootweb.controllers;

import com.mvc.restful.apis.springbootweb.dto.EmployeeDTO;
import com.mvc.restful.apis.springbootweb.entity.EmployeeEntity;
import com.mvc.restful.apis.springbootweb.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    // Not a recommended practice: to add entity or repository to controllers (to be removed)
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById (@PathVariable (name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployeeDetails (@RequestParam(required = false, name = "name") String inputName,
                                                    @RequestParam(required = false, name = "getAge") Integer age) {
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmployee (@RequestBody EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping
    public String updateEmployee () {
        return "Hello from PUT";
    }
}
