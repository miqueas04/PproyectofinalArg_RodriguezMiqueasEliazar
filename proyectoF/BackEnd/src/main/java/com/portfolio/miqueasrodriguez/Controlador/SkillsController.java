
package com.portfolio.miqueasrodriguez.Controlador;

import com.portfolio.miqueasrodriguez.Entidad.Skills;
import com.portfolio.miqueasrodriguez.Servicio.SkillsService;
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
@RequestMapping("/skills")
public class SkillsController {
    
      private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

  
   
    @GetMapping("/id/{id}")
    public ResponseEntity<Skills>obtenerEducacion(@PathVariable("id") Long id){
        Skills skills=skillsService.buscarSkillsPorId(id);
        return new ResponseEntity<>(skills,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Skills>editarSkills(@RequestBody Skills skills){
        Skills updateSkills=skillsService.editarSkills(skills);
        return new ResponseEntity<>(updateSkills,HttpStatus.OK);
    }
    
}
