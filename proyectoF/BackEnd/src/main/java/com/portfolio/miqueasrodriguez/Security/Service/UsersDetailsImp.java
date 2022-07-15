
package com.portfolio.miqueasrodriguez.Security.Service;


import com.portfolio.miqueasrodriguez.Security.Entity.UsuarioPrincipal;
import com.portfolio.miqueasrodriguez.Security.Entity.Usuarior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsImp implements UserDetailsService {
    @Autowired
    UsuariorService usuariorService; 

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
     Usuarior usuarior =  usuariorService.getByNombreUsuario(nombreUsuario).get();
     return UsuarioPrincipal.build(usuarior);
}
}