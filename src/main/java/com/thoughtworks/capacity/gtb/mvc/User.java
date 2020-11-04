package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull(message = "username must not be null")
    @Length(min=3,max=10,message = "Please set a username of 3-10 digits")
    private String username;

    @NotNull
    @Length(min=5,max=12,message = "Please set a password of 5-12 digits")
    private String password;

    @Email(message = "Invalid email address")
    private String email;
}
