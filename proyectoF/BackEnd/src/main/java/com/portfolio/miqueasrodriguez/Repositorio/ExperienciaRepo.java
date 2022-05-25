
package com.portfolio.miqueasrodriguez.Repositorio;

import com.portfolio.miqueasrodriguez.Entidad.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepo extends JpaRepository<Experiencia, Long>{
    
}
