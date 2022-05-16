
package com.portfolio.miqueasrodriguez.Interface;

import com.portfolio.miqueasrodriguez.Entidad.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IPersonaServicio {
    
    public List<Persona>Getpersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
    
}
