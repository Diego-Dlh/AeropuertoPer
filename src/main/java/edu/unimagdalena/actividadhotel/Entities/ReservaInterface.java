package edu.unimagdalena.actividadhotel.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ReservaInterface extends JpaRepository<Reserva, Long> {

    List<Reserva> findByCodigoReserva(UUID codigoReserva);
    Reserva findReservaById(Long id);
    Reserva findByIdAndCodigoReserva(Long id, UUID codigoReserva);
    List<Reserva> findByIdIn(List<Long> ids);
    List<Reserva> findByVueloId(Long vueloId);

    @Query("SELECT r FROM Reserva r ORDER BY r.codigoReserva ASC")
    List<Reserva> obtenerTodasOrdenadas();

    @Query("SELECT COUNT(r) FROM Reserva r")
    Long contarReservas();

    @Query("SELECT r FROM Reserva r WHERE r.codigoReserva = ?1")
    Reserva buscarPorCodigoReserva(UUID codigoReserva);

    @Query("SELECT r FROM Reserva r WHERE r.vuelo.id = ?1")
    List<Reserva> buscarPorVueloId(Long vueloId);

    @Query("SELECT r FROM Reserva r WHERE r.pasajero.id = ?1")
    List<Reserva> buscarPorPasajeroId(Long pasajeroId);
}
