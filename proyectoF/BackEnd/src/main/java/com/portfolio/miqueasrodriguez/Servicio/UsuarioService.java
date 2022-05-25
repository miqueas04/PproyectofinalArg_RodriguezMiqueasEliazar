
package com.portfolio.miqueasrodriguez.Servicio;

import com.portfolio.miqueasrodriguez.Entidad.Usuario;
import com.portfolio.miqueasrodriguez.Repositorio.UsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;

    @Autowired
      public UsuarioService(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
    

    //Metodos//
    public Usuario addUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

  
    public List<Usuario> buscarUsuario(){
    return usuarioRepo.findAll();
    }
    
    public Usuario editarUsuario(Usuario usuario){
    return usuarioRepo.save(usuario);
    }
    
    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }
    
    public Usuario buscarUsuarioPorId(Long id){
        
        return usuarioRepo.findById(id).orElse(null);
        
    }
   
}