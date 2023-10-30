package io.jwttry.my_app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    private Integer age;
    @NotNull
    private String role;
    @NotNull
    private String password;
    @NotNull
    private String username;

}