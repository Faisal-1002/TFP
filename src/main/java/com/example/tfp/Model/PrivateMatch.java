package com.example.tfp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrivateMatch {

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

    @OneToOne(mappedBy = "privateMatch", cascade = CascadeType.ALL)
    private Booking booking;

    @OneToMany(mappedBy = "privateMatch", cascade = CascadeType.ALL)
    private List<Emails> emails;

    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @OneToMany(mappedBy = "privateMatch", cascade = CascadeType.ALL)
    private List<TimeSlot> timeSlots;
}
