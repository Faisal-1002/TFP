package com.example.tfp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Field name must not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @NotEmpty(message = "Location must not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String location;

    @NotEmpty(message = "Description must not be empty")
    @Column(columnDefinition = "varchar(200) not null")
    private String description;

    @NotEmpty(message = "Photo URL must not be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String photo;

    @NotNull(message = "Open time must not be null")
    @Column(columnDefinition = "time not null")
    private LocalTime openTime;

    @NotNull(message = "Close time must not be null")
    @Column(columnDefinition = "time not null")
    private LocalTime closeTime;

    @ManyToOne
    private Organizer organizer;

    @ManyToOne
    private Sport sport;
}
