package com.mvc.restful.apis.springbootweb.services;

import com.mvc.restful.apis.springbootweb.entity.EmployeeEntity;
import com.mvc.restful.apis.springbootweb.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }
}
