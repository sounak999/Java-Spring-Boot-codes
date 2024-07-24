package com.mvc.restful.apis.springbootweb.repositories;

import com.mvc.restful.apis.springbootweb.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
