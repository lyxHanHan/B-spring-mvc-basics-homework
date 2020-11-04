package com.thoughtworks.capacity.gtb.mvc;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    @NotBlank(message = "username must not be null")
    @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$",message = "Can only contain letters, numbers, underscores,and the length is 3-10 digits")
    private String username;

    @NotNull
    @Length(min=5,max=12,message = "Please set a password of 5-12 digits")
    private String password;

    @Email(message = "Invalid email address")
    private String email;
}
