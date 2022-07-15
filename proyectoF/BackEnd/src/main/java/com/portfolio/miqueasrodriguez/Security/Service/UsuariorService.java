
package com.portfolio.miqueasrodriguez.Security.Service;

import com.portfolio.miqueasrodriguez.Security.Entity.Usuarior;
import com.portfolio.miqueasrodriguez.Security.Repository.iUsuariorRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuariorService {
    @Autowired
    iUsuariorRepository iusuariorRepository;
    
    public Optional<Usuarior> getByNombreUsuario(String nombreUsuario){
        return iusuariorRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
    return iusuariorRepository.existsByNombreUsuario(nombreUsuario);
    }
    
  public boolean existsByEmail(String email){
    return iusuariorRepository.existsByEmail(email);
    } 
  
  public void save(Usuarior usuarior){
      iusuariorRepository.save(usuarior);
  }
}
