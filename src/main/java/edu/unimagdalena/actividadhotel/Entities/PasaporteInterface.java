package edu.unimagdalena.actividadhotel.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PasaporteInterface extends JpaRepository<Pasaporte, Long> {

    List<Pasaporte> findByNumero(String numero);
    Pasaporte findPasaporteByNumero(String numero);
    Pasaporte findPasaporteById(Long id);
    Pasaporte findByIdAndNumero(Long id, String numero);
    List<Pasaporte> findPasaporteByNumeroLike(String numero);
    List<Pasaporte> findByIdIn(List<Long> ids);

    @Query("SELECT p FROM Pasaporte p ORDER BY p.numero ASC")
    List<Pasaporte> obtenerTodosOrdenados();

    @Query("SELECT COUNT(p) FROM Pasaporte p")
    Long contarPasaportes();

    @Query("SELECT p FROM Pasaporte p WHERE LOWER(p.numero) = LOWER(?1)")
    Pasaporte buscarPorNumero(String numero);

    @Query("SELECT p FROM Pasaporte p WHERE p.id IN ?1")
    List<Pasaporte> buscarPorListaIds(List<Long> ids);

    @Query("SELECT p FROM Pasaporte p WHERE p.numero LIKE %?1%")
    List<Pasaporte> buscarPorNumeroParcial(String numero);
}
