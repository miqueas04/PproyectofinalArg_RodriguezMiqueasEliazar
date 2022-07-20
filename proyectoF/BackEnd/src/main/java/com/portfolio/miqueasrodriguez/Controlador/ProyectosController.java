
package com.portfolio.miqueasrodriguez.Controlador;

import com.portfolio.miqueasrodriguez.Entidad.Proyectos;
import com.portfolio.miqueasrodriguez.Servicio.ProyectosService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/proyectos")
public class ProyectosController {
    
    
    private final ProyectosService proyectosService;

    public ProyectosController(ProyectosService proyectosService) {
        this.proyectosService = proyectosService;
    }
    
     @GetMapping("/all")
    public ResponseEntity<List<Proyectos>>obtenerProyectos(){
        List<Proyectos> proyectos=proyectosService.buscarProyectos();
        return new ResponseEntity<>(proyectos,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Proyectos>editarProyectos(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos=proyectosService.editarProyectos(proyectos);
        return new ResponseEntity<>(updateProyectos,HttpStatus.OK);
    }
     @PostMapping("/add")
    public ResponseEntity<Proyectos> crearExperiencia(@RequestBody Proyectos proyectos){
        Proyectos nuevoProyectos=proyectosService.addProyectos(proyectos);
        return new ResponseEntity<>(nuevoProyectos,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarProyectos (@PathVariable("id")long id ){
        proyectosService.borrarProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
