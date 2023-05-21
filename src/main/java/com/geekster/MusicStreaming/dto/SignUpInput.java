package com.geekster.MusicStreaming.dto;


import com.geekster.MusicStreaming.model.PlayList;
import com.geekster.MusicStreaming.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {

    @Pattern(regexp = "[A-Z][a-z]*" , message = "First Letter of Name should be Capital")
    private String userName;

    @NotBlank
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter Valid Email")
    private String email;

    @NotBlank(message = "Age cannot be blank")
    private Integer age;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;


}
