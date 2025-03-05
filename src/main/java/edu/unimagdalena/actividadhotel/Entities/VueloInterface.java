package edu.unimagdalena.actividadhotel.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VueloInterface extends JpaRepository<Vuelo, Long> {

        //  CONSULTAS USANDO QUERY METHODS

        List<Vuelo> findByOrigen(String origen);

        List<Vuelo> findByDestino(String destino);

        Optional<Vuelo> findByNumVuelo(UUID numVuelo);

        List<Vuelo> findByReservasIsNotEmpty();

        List<Vuelo> findAllByOrderByOrigenAsc();


        // CONSULTAS USANDO JPQL


        List<Vuelo> findVuelosConMultiplesAerolineas();

        @Query("SELECT COUNT(v) FROM Vuelo v WHERE v.origen = :origen")
        long countVuelosDesdeOrigen(String origen);

        @Query("SELECT v FROM Vuelo v WHERE v.reservas IS EMPTY")
        List<Vuelo> findVuelosSinReservas();

        @Query("SELECT v FROM Vuelo v WHERE v.destino LIKE %:keyword%")
        List<Vuelo> findVuelosPorDestinoConteniendo(String keyword);

        @Query("SELECT v FROM Vuelo v WHERE v.origen = :origen AND SIZE(v.reservas) > 1")
        List<Vuelo> findVuelosDesdeOrigenConMultiplesReservas(String origen);

        @Query("SELECT v FROM Vuelo v ORDER BY v.destino DESC")
        List<Vuelo> findAllOrderByDestinoDesc();
    }



