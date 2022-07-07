
package com.portfolio.miqueasrodriguez.Repositorio;

import com.portfolio.miqueasrodriguez.Entidad.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepo extends JpaRepository<Proyectos, Long> {
    
}
