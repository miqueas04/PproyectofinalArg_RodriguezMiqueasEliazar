
package com.portfolio.miqueasrodriguez.Servicio;

import com.portfolio.miqueasrodriguez.Entidad.Skills;
import com.portfolio.miqueasrodriguez.Repositorio.SkillsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
    private final SkillsRepo skillsRepo;
 
    @Autowired
    public SkillsService(SkillsRepo skillsRepo) {
        this.skillsRepo = skillsRepo;
    }
    
      //Metodos//
    public Skills addSkill(Skills skills){
        return skillsRepo.save(skills);
    }

  
    public List<Skills> buscarSkills(){
    return skillsRepo.findAll();
    }
    
    public Skills editarSkills(Skills skills){
    return skillsRepo.save(skills);
    }
    
    public void borrarSkills(Long id){
        skillsRepo.deleteById(id);
    }
    
    public Skills buscarSkillsPorId(Long id){
        
        return skillsRepo.findById(id).orElse(null);
        
    }
    
}
