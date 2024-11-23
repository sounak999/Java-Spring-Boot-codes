package com.mvc.restapi.services;

import com.mvc.restapi.dto.EmployeeDTO;
import com.mvc.restapi.entities.EmployeeEntity;
import com.mvc.restapi.exceptions.ResourceNotFoundException;
import com.mvc.restapi.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService (EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> findById(Long id) {
        return employeeRepository.findById(id).map(employeeEntity ->
            modelMapper.map(employeeEntity, EmployeeDTO.class)
        );
    }

    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        isEmployeeExist(id);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO partialUpdate(Map<String, Object> updates, Long id) {
        isEmployeeExist(id);

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        updates.forEach((field, value) -> {
            Field fieldToUpdate = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate, employeeEntity, value);
        });

        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean delete(Long id) {
        isEmployeeExist(id);
        employeeRepository.deleteById(id);
        return true;
    }

    private void isEmployeeExist(Long id) {
        boolean isExist = employeeRepository.existsById(id);
        if (!isExist) throw new ResourceNotFoundException("Employee does not exist with id: " + id);
    }
}
