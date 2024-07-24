package com.mvc.restful.apis.springbootweb.controllers;

import com.mvc.restful.apis.springbootweb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
//    @GetMapping(path = "/getMessage")
//    public String getSecretMessage() {
//        return "This is secret message only shown in the path /getMessage";
//    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById (@PathVariable (name = "employeeId") Long id) {
        return new EmployeeDTO(id, "Sounak", "sounak.saha@org.in", 23, LocalDate.of(2022, 8, 23), true);
    }

    @GetMapping
    public String getEmployeeDetails (@RequestParam(required = false, name = "name") String inputName,
                                      @RequestParam(required = false, name = "getAge") Integer age) {
        return "Hi, " + inputName + " with age: " + age;
    }

    @PostMapping
    public EmployeeDTO createEmployee (@RequestBody EmployeeDTO employee) {
        employee.setEmployeeId(100L);
        return employee;
    }

    @PutMapping
    public String updateEmployee () {
        return "Hello from PUT";
    }
}
