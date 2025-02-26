package edu.unimagdalena.actividadhotel.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pasaporte")
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @OneToOne
    @JoinColumn(name = "pasajeros_id")
    private Pasajero pasajero;
}
