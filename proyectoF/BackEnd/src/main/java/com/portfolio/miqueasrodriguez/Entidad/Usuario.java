
package com.portfolio.miqueasrodriguez.Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario implements Serializable {

    public Usuario() {
    }

    public Usuario(Long id, String nombre,String descripcion, String apellido, String titulo, String fotoPerfil, String banner) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.apellido = apellido;
        this.titulo = titulo;
        this.fotoPerfil = fotoPerfil;
        this.banner = fotoPerfil;
        
    }

    
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   
    
    private Long id;
   
    @NotNull
    @Size(min = 1, max = 45, message ="no cumple con la cantidad de caracteres")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 45, message ="no cumple con la cantidad de caracteres")
    private String apellido;
    
    private String titulo;
    
    
    @Size(min = 1, max = 300, message ="no cumple con la cantidad de caracteres")
    private String descripcion;
     
     
    private String fotoPerfil;
    
    private String banner;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy ="idEdu")
    private List<Educacion>educacionList;
    @OneToMany(fetch= FetchType.LAZY, mappedBy ="idSkill")
    private List<Skills>skillList;
    @OneToMany(fetch= FetchType.LAZY, mappedBy ="idExp")
    private List<Experiencia>experienciaList;
}
