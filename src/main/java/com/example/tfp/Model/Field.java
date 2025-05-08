package com.example.tfp.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String location;

    private String description;
    private String photo;
    private LocalTime openTime;
    private LocalTime closeTime;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "organizer_id", referencedColumnName = "id")
    private Organizer organizer;




}
