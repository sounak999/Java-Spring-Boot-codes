package com.mvc.restful.apis.springbootweb.controllers;

import com.mvc.restful.apis.springbootweb.dto.EmployeeDTO;
import com.mvc.restful.apis.springbootweb.entity.EmployeeEntity;
import com.mvc.restful.apis.springbootweb.repositories.EmployeeRepository;
import com.mvc.restful.apis.springbootweb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById (@PathVariable (name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployeeDetails (@RequestParam(required = false, name = "name") String inputName,
                                                    @RequestParam(required = false, name = "getAge") Integer age) {
        return employeeService.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmployee (@RequestBody EmployeeEntity employee) {
        return employeeService.createNewEmployee(employee);
    }

    @PutMapping
    public String updateEmployee () {
        return "Hello from PUT";
    }
}
