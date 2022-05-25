
package com.portfolio.miqueasrodriguez.Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills implements Serializable {

    public Skills() {
    }

    public Skills(Long idSkill, String nombreSkill, String fotoSkill, int porcentaje) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.fotoSkill = fotoSkill;
        this.porcentaje = porcentaje;
    }
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   
   private Long idSkill;
   private String nombreSkill;
   private String fotoSkill;
   private int porcentaje;
           
}
