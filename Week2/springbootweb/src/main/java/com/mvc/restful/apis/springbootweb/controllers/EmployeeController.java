package com.mvc.restful.apis.springbootweb.controllers;

import com.mvc.restful.apis.springbootweb.dto.EmployeeDTO;
import com.mvc.restful.apis.springbootweb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById (@PathVariable (name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployeeDetails (@RequestParam(required = false, name = "name") String inputName,
                                                    @RequestParam(required = false, name = "getAge") Integer age) {
        return employeeService.findAll();
    }

    @PostMapping
    public EmployeeDTO createEmployee (@RequestBody EmployeeDTO employee) {
        return employeeService.createNewEmployee(employee);
    }

    @PutMapping (path = "/{employeeId}")
    public EmployeeDTO updateEmployee (@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return employeeService.updateEmployee(employeeDTO, employeeId);
    }

    @PatchMapping (path = "/{employeeId}")
    public EmployeeDTO updateEmployeePartially (@RequestBody Map<String, Object> updates, @PathVariable Long employeeId) {
        return employeeService.updateEmployeePartially(updates, employeeId);
    }

    @DeleteMapping (path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }
}
