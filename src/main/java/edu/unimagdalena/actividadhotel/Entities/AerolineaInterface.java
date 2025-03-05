package edu.unimagdalena.actividadhotel.Entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AerolineaInterface extends JpaRepository<Aerolinea, Long> {

    List<Aerolinea> findByNombre(String nombre);
    Aerolinea findAerolineaByNombre(String nombre);
    Aerolinea findAerolineaById(Long id);
    Aerolinea findByAerolineaIdAndNombre(Long aerolineaId, String nombre);
    Aerolinea findAerolineaByNameLike(String aerolineaN);
    Aerolinea findByIdAereolineaIdIn(List<Long> idAereolineaIds);


}
