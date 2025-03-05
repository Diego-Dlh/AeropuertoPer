package edu.unimagdalena.actividadhotel.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PasajeroInterface extends JpaRepository<Pasajero, Long> {

    List<Pasajero> findByNombre(String nombre);

    Optional<Pasajero> findByNid(String nid);

    @Query("SELECT p FROM Pasajero p WHERE SIZE(p.reservas) > 1")
    List<Pasajero> findPasajerosConMultiplesReservas();

    List<Pasajero> findAllByOrderByNombreAsc();

    @Query("SELECT p FROM Pasajero p WHERE p.pasaporte IS NOT NULL")
    List<Pasajero> findPasajerosConPasaporte();

    List<Pasajero> findByNombreContaining(String keyword);

    @Query("SELECT COUNT(p) FROM Pasajero p WHERE p.pasaporte IS NOT NULL")
    long countPasajerosConPasaporte();

    @Query("SELECT p FROM Pasajero p WHERE SIZE(p.reservas) > 2")
    List<Pasajero> findPasajerosConMasDeDosReservas();

    Optional<Pasajero> findByNombreAndNid(String nombre, String nid);

    @Query("SELECT p FROM Pasajero p WHERE p.reservas IS EMPTY")
    List<Pasajero> findPasajerosSinReservas();

}
