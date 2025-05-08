package com.example.tfp.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class FieldDTO {


    @NotEmpty
    private String name;

    @NotEmpty
    private String location;

    @NotEmpty
    private String description;

    @NotNull
    private LocalTime openTime;

    @NotNull
    private LocalTime closeTime;

}
