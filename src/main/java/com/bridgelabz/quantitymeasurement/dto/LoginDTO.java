package com.bridgelabz.quantitymeasurement.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class LoginDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z[0-9]@$!%*?&]{8,15}$",
            message = "Password must contain one numeric value, one lowercase, one uppercase, one special symbol, minimum 8 characters")
    String password;


}
