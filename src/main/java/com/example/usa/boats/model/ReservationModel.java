package com.example.usa.boats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="reservation")
@NoArgsConstructor
@Getter
@Setter
public class ReservationModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    @ManyToOne
    @JoinColumn(name = "boatId")
    @JsonIgnoreProperties("reservations")
    private BoatModel boat;
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private ClientModel client;

    @OneToOne
    @JsonIgnoreProperties("reservation")
    private ScoreModel score;

}
