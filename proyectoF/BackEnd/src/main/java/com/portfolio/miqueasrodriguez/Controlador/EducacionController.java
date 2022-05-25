
package com.portfolio.miqueasrodriguez.Controlador;

import com.portfolio.miqueasrodriguez.Entidad.Educacion;
import com.portfolio.miqueasrodriguez.Servicio.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/educacion")
public class EducacionController {
    
    
      private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

   
    @GetMapping("/id/{id}")
    public ResponseEntity<Educacion>obtenerEducacion(@PathVariable("id") Long id){
        Educacion educacion=educacionService.buscarEducacionPorId(id);
        return new ResponseEntity<>(educacion,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Educacion>editarEducacion(@RequestBody Educacion educacion){
        Educacion updateUsuario=educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(updateUsuario,HttpStatus.OK);
    }
    
}
