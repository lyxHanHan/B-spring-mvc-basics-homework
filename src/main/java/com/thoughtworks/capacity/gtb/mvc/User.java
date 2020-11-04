package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;

    @Length(min=5,max=12,message = "Invalid")
    private String password;

    @Email(message = "Invalid email address")
    private String email;
}
