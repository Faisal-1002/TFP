package com.example.tfp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PublicMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Match name must not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @NotEmpty(message = "Status must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String status; // e.g. OPEN, FULL

    @OneToMany(mappedBy = "publicMatch", cascade = CascadeType.ALL)
    private List<TimeSlot> timeSlots;

    @ManyToOne
    private Field field;

    @OneToOne
    @JoinColumn(name = "team_a_id", referencedColumnName = "id")
    private TeamA teamA;

    @OneToOne
    @JoinColumn(name = "team_b_id", referencedColumnName = "id")
    private TeamB teamB;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Organizer organizer;

    @OneToMany(mappedBy = "publicMatch", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
