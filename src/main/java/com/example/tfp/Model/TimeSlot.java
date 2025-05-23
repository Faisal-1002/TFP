package com.example.tfp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Date must not be null")
    @Column(columnDefinition = "date not null")
    private LocalDate date;

    @NotNull(message = "Start time must not be null")
    @Column(columnDefinition = "time not null")
    private LocalTime startTime;

    @NotNull(message = "End time must not be null")
    @Column(columnDefinition = "time not null")
    private LocalTime endTime;

    @NotNull(message = "Price must not be null")
    @Min(value = 0, message = "Price must be non-negative")
    @Column(columnDefinition = "double not null")
    private Double price;

//    @NotNull(message = "Max players must not be null")
//    @Min(value = 2, message = "There must be at least 2 players")
//    @Column(columnDefinition = "int not null")
//    private Integer maxPlayers;

    @NotEmpty(message = "Status must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String status; // e.g., OPEN, FULL, CLOSED

    @ManyToOne
    private Field field;

    @ManyToOne
    private PublicMatch publicMatch;

    @ManyToOne
    private PrivateMatch privateMatch;
}
