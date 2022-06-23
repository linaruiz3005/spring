package com.sena.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="albums")
public class Album {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_album;
    @NotEmpty
    @Column(length = 50,nullable=false)
    private String ani_publicacion;

    private Boolean estado_album;

    //Constructores
    public Album(){

    }
    public Album(Integer id, String nombre_album,String ani_publicacion, Boolean estado_album){
        this.id=id;
        this.nombre_album=nombre_album;
        this.ani_publicacion=ani_publicacion;
        this.estado_album=estado_album;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre_album() {
        return nombre_album;
    }
    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }
    public String getAni_publicacion() {
        return ani_publicacion;
    }
    public void setAni_publicacion(String ani_publicacion) {
        this.ani_publicacion = ani_publicacion;
    }
    public Boolean getEstado_album() {
        return estado_album;
    }
    public void setEstado_album(Boolean estado_album) {
        this.estado_album = estado_album;
    }
    
}

