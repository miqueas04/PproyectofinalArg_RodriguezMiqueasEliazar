
package com.portfolio.miqueasrodriguez.Security.Repository;

import com.portfolio.miqueasrodriguez.Security.Entity.Usuarior;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuariorRepository extends JpaRepository<Usuarior, Integer>{
  Optional<Usuarior> findByNombreUsuario(String nombreUsuario);  
  
  boolean existsByNombreUsuario(String nombreUsuario);
  boolean existsByEmail(String email);
  
}
