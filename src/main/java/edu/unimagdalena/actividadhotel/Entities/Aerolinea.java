package edu.unimagdalena.actividadhotel.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "aerolineas")

public class Aerolinea {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "aerolineas")
    private Set<Vuelo> vuelos;
}
