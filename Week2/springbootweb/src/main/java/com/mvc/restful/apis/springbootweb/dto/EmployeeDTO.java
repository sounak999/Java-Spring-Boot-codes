package com.mvc.restful.apis.springbootweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvc.restful.apis.springbootweb.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long employeeId;

    @NotBlank(message = "Employee name cannot be blank")
    @Size(min = 3, max = 10, message = "Employee name characters should lie between [3, 10]")
    private String name;

    @NotBlank(message = "Email of the Employee cannot be blank")
    @Email
    private String email;

    @NotNull(message = "Age of the Employee cannot be blank")
    @Max(value = 80, message = "Employee's age shouldn't exceed 80")
    @Min(value = 18, message = "Employee shouldn't be under 18 years of age")
    private Integer age;

    @PastOrPresent(message = "Date of Joining can't be in the future")
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private boolean isActive;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(USER|ADMIN)$", message = "role of the employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String Role;

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary should be +ve")
    @Digits(integer = 6, fraction = 2, message = "Salary should be in the format XXXXXX.YY")
    @DecimalMin(value="10000.00")
    @DecimalMax(value="500000.00")
    private Double salary;
}
