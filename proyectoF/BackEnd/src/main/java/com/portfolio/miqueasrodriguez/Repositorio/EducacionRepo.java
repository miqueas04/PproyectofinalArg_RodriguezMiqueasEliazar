
package com.portfolio.miqueasrodriguez.Repositorio;

import com.portfolio.miqueasrodriguez.Entidad.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Long>{
    
}
