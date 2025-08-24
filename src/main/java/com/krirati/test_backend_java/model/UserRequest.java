package com.krirati.test_backend_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull(message = "name should not be null")
    @NotEmpty(message = "name should not be blank")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "username should not be null")
    @NotEmpty(message = "username should not be blank")
    @JsonProperty("username")
    private String username;

    @NotNull(message = "email should not be null")
    @NotEmpty(message = "email should not be blank")
    @Email
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("website")
    private String website;
}
