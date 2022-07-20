
package com.portfolio.miqueasrodriguez.Controlador;

import com.portfolio.miqueasrodriguez.Entidad.Persona;
import com.portfolio.miqueasrodriguez.Interface.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://miqueasfront.web.app")
public class PersonaControlador {
 
@Autowired IPersonaServicio ipersonaServicio;


@GetMapping("/personas/traer")
public List<Persona> getPersona(){
  
   return ipersonaServicio.Getpersona();
          
}
@PostMapping("/personas/crear")
  public String createPersona(@RequestBody Persona persona) {
      ipersonaServicio.savePersona(persona);
      return "La perosna fue creada!";
  }
  
@DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaServicio.deletePersona(id);
        return "Persona eliminada correctamente";
    }
    
 @PutMapping("/personas/editar/{id}")
 public Persona editarPersona(@PathVariable Long id,
         
                               @RequestParam("nombre")String nuevoNombre,
                               @RequestParam("apellido")String nuevoApellido,
                               @RequestParam("img")String nuevoImg){
     Persona persona = ipersonaServicio.findPersona(id);
     persona.setNombre(nuevoNombre);
     persona.setApellido(nuevoApellido);
     persona.setImg(nuevoImg);
     ipersonaServicio.savePersona(persona);
     return persona;
 }
   @GetMapping("/personas/traer/perfil")
    public Persona findpersona(){return ipersonaServicio.findPersona((long)1);}
 
}
