package com.mvc.restapi.dto;

import com.mvc.restapi.annotations.EmployeeRoleValidation;
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
    private Long id;
    @NotBlank
    @Size(min = 3, max = 20, message = "Name should fall under 3 to 20 characters")
    private String name;

    @Email
    private String email;

    @Min(value = 18)
    @Max(value = 65)
    private Integer age;

    @PastOrPresent(message = "Date of joining can't be in the future")
    private LocalDate DateOfJoining;
    private Boolean isActive;

    @NotBlank
//    @Pattern(regexp = "^(USER|ADMIN)$", message = "Employee role should either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;
}
