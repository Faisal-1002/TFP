package com.example.tfp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Organizer {

    @Id
    private Integer id;



    //-------------------------------------------------------------------
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizer")
    private Set<Field> fields;

    @OneToOne
    @JsonIgnore
    private User user;

}
