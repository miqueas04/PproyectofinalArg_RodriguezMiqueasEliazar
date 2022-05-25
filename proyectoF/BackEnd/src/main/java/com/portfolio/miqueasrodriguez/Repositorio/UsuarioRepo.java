
package com.portfolio.miqueasrodriguez.Repositorio;

import com.portfolio.miqueasrodriguez.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    
}
