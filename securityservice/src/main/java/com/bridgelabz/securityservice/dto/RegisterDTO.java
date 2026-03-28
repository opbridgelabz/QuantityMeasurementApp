package com.bridgelabz.securityservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDTO {

    @NotBlank
    @Size(min = 5, max = 20)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z[0-9]@$!%*?&]{8,15}$",
            message = "Password must contain one numeric value, one lowercase, one uppercase, one special symbol, minimum 8 characters")
    private String password;
}
