
package com.portfolio.miqueasrodriguez.Servicio;

import com.portfolio.miqueasrodriguez.Entidad.Persona;
import com.portfolio.miqueasrodriguez.Interface.IPersonaServicio;
import com.portfolio.miqueasrodriguez.Repositorio.IPersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaServicio implements IPersonaServicio{
    
    @Autowired IPersonaRepositorio ipersonaRepository;

    @Override
    public List<Persona> Getpersona() {
        
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        
          ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
