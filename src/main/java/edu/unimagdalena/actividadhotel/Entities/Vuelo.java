package edu.unimagdalena.actividadhotel.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;
@Data
@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "origen")
    private String origen;
    @Column(name = "destino")
    private String destino;
    @Column(name = "numVuelo")
    private UUID numVuelo;

    @ManyToMany
    @JoinTable(name = "aerolineas_vuelos",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "aerolinea_id"))
            private List<Aerolinea> aerolineas = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "vuelo")
    private Set<Reserva> reservas;

    public void addAerolinea(Aerolinea aerolinea){
        this.aerolineas.add(aerolinea);
    }


}
