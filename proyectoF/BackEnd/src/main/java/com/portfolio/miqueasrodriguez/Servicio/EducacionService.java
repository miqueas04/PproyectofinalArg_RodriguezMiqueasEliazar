
package com.portfolio.miqueasrodriguez.Servicio;

import com.portfolio.miqueasrodriguez.Entidad.Educacion;
import com.portfolio.miqueasrodriguez.Repositorio.EducacionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {
    private final EducacionRepo educacionRepo;

    @Autowired
    public EducacionService(EducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }

    //Metodos//
    public Educacion addEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    
    public List<Educacion> buscarEducacion(){
    return educacionRepo.findAll();
    }
    
    public Educacion editarEducacion(Educacion educacion){
    return educacionRepo.save(educacion);
    }
    
    public void borrarEducacion(Long id){
        educacionRepo.deleteById(id);
    }

    
}
