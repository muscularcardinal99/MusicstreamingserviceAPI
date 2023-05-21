package com.geekster.MusicStreaming.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter Valid Email")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
