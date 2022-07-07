
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
public class Proyectos  implements Serializable {
    
    public Proyectos (Long idPro, String nombre, int fechaR, String descripcion, String imagen){
    this.idPro = idPro;
    this.nombre = nombre;
    this.fechaR = fechaR;
    this.descripcion = descripcion;
    this.imagen = imagen;
    
    }
     public Proyectos() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPro;
    private String nombre;
    private int fechaR;
    private String descripcion;
    private String imagen;
}
