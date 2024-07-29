package com.mvc.restful.apis.springbootweb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private String role;
    private Double salary;

    @JsonProperty("isActive")
    private boolean isActive;
}
