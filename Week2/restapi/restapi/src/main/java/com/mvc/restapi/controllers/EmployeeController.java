package com.mvc.restapi.controllers;

import com.mvc.restapi.dto.EmployeeDTO;
import com.mvc.restapi.services.EmployeeService;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping(path = "/{employeeId}")
    private EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable(name = "employeeId") Long id) {
        return employeeService.update(id, employeeDTO);
    }

    @PatchMapping(path = "/{employeeId}")
    private EmployeeDTO updateEmployee(@RequestBody Map<String, Object> updates,
                                       @PathVariable Long employeeId) {
        return employeeService.partialUpdate(updates, employeeId);
    }

    @DeleteMapping(path = "/{employeeId}")
    private boolean deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.delete(employeeId);
    }
}
