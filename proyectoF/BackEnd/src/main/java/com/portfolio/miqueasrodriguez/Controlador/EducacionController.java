
package com.portfolio.miqueasrodriguez.Controlador;

import com.portfolio.miqueasrodriguez.Entidad.Educacion;
import com.portfolio.miqueasrodriguez.Servicio.EducacionService;
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
@RequestMapping("/educacion")
public class EducacionController {
    
    
      private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

   
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>>obtenerEducacion(){
        List<Educacion> educacion=educacionService.buscarEducacion();
        return new ResponseEntity<>(educacion,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Educacion>editarEducacion(@RequestBody Educacion educacion){
        Educacion updateUsuario=educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(updateUsuario,HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion){
        Educacion nuevaEducacion=educacionService.addEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarEducacion (@PathVariable("id")long id ){
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
