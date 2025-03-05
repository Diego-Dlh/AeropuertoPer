package edu.unimagdalena.actividadhotel.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VueloInterface extends JpaRepository<Vuelo, Long> {

    List<Vuelo> findByOrigen(String origen);

    List<Vuelo> findByDestino(String destino);

    Optional<Vuelo> findByNumVuelo(UUID numVuelo);

    @Query("SELECT v FROM Vuelo v WHERE SIZE(v.reservas) > 1")
    List<Vuelo> findVuelosConMultiplesReservas();

    @Query("SELECT v FROM Vuelo v WHERE SIZE(v.aerolineas) > 1")
    List<Vuelo> findVuelosConMultiplesAerolineas();


}
