package com.example.tfp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private String status;

    @OneToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private Field field;

    @OneToOne
    @JoinColumn(name = "team_a_id", referencedColumnName = "id")
    private TeamA teamA;

    @OneToOne
    @JoinColumn(name = "team_b_id", referencedColumnName = "id")
    private TeamB teamB;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @OneToMany(mappedBy = "publicMatch", cascade = CascadeType.ALL)
    private List<TimeSlot> timeSlots;

}
