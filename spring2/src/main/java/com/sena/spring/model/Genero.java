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
@Table(name="generos")
public class Genero {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_genero;

    private Boolean estado_genero;

    //Constructores
    public Genero(){

    }
    public Genero(Integer id, String nombre_genero, Boolean estado_genero){
        this.id=id;
        this.nombre_genero=nombre_genero;
        this.estado_genero=estado_genero;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre_genero() {
        return nombre_genero;
    }
    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }
    public Boolean getEstado_genero() {
        return estado_genero;
    }
    public void setEstado_genero(Boolean estado_genero) {
        this.estado_genero = estado_genero;
    }

    
 
}
