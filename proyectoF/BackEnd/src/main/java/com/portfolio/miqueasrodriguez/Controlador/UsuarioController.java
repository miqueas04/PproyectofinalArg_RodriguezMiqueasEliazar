
package com.portfolio.miqueasrodriguez.Controlador;

import com.portfolio.miqueasrodriguez.Entidad.Usuario;
import com.portfolio.miqueasrodriguez.Servicio.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://miqueasfront.web.app")
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario>obtenerUsuario(@PathVariable("id") Long id){
        Usuario usuario=usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }
    
    
    @PutMapping("/update")
    public ResponseEntity<Usuario>editarUsuario(@RequestBody Usuario usuario){
        Usuario updateUsuario=usuarioService.editarUsuario(usuario);
        return new ResponseEntity<>(updateUsuario,HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
  public String createPersona(@RequestBody Usuario usuario) {
      usuarioService.addUsuario(usuario);
      return "Usuario creado!";
  }
  
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return "Usuario eliminado correctamente";
    }
}
