package io.jwttry.my_app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long user;


}
