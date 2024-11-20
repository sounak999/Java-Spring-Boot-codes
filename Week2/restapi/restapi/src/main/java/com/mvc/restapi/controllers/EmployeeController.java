package com.mvc.restapi.controllers;

import com.mvc.restapi.dto.EmployeeDTO;
import com.mvc.restapi.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    private ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(name = "employeeId") @Valid Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.findById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    private ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    private ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.save(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    private EmployeeDTO updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable(name = "employeeId") Long id) {
        return employeeService.update(id, employeeDTO);
    }

    @PatchMapping(path = "/{employeeId}")
    private ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Map<String, Object> updates,
                                       @PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.partialUpdate(updates, employeeId);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    private ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId) {
        boolean isDeleted = employeeService.delete(employeeId);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }
}
