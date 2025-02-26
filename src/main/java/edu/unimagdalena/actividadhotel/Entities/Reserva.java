package edu.unimagdalena.actividadhotel.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo_reserva")
    private UUID codigoReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vuelos_id")
    private Vuelo vuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pasajeros_id")
    private Pasajero pasajero;
}
