package edu.unimagdalena.actividadhotel.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AerolineaInterface extends JpaRepository<Aerolinea, Long> {

    List<Aerolinea> findByNombre(String nombre);
    Aerolinea findAerolineaByNombre(String nombre);
    Aerolinea findAerolineaById(Long id);
    Aerolinea findByAerolineaIdAndNombre(Long id, String nombre);
    Aerolinea findAerolineaByNameLike(String aerolineaN);
    Aerolinea findByIdAereolineaIdIn(List<Long> ids);

    @Query("SELECT a FROM Aerolinea a ORDER BY a.nombre ASC")
    List<Aerolinea> obtenerTodasOrdenadas();

    @Query("SELECT COUNT(a) FROM Aerolinea a")
    Long contarAerolíneas();

    @Query("SELECT a FROM Aerolinea a WHERE LOWER(a.nombre) = LOWER(?1)")
    Aerolinea buscarPorNombre(String nombre);

    @Query("SELECT a FROM Aerolinea a WHERE a.id IN ?1")
    List<Aerolinea> buscarPorListaIds(List<Long> ids);

    @Query("SELECT a FROM Aerolinea a WHERE a.nombre LIKE %?1%")
    List<Aerolinea> buscarPorNombreParcial(String nombre);

}
