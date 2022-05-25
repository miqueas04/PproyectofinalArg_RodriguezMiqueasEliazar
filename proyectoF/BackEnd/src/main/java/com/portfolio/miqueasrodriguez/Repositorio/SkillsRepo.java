
package com.portfolio.miqueasrodriguez.Repositorio;

import com.portfolio.miqueasrodriguez.Entidad.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface SkillsRepo extends JpaRepository<Skills, Long> {
    
}
