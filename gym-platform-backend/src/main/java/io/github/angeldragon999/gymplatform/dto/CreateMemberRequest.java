package io.github.angeldragon999.gymplatform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateMemberRequest(

        @NotBlank(message = "First name is required")
        @Size(max = 60, message = "First name cannot exceed 60 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(max = 60, message = "Last name cannot exceed 60 characters")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email adress is not valid")
        @Size(max = 250, message = "Email cannot exceed 250 characters")
        String email
) {
}
