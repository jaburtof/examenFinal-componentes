package com.cenfotec.examen.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nombreLibro;

    @Column(nullable = false)
    private String leidoPor;


    @Column(nullable = false)
    private Boolean estado;


    @Column(nullable = false)
    private int cant;


    public Libro(){};

    public Libro(int id, String nombreLibro, String leidoPor, Boolean estado) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.leidoPor = leidoPor;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getLeidoPor() {
        return leidoPor;
    }

    public void setLeidoPor(String leidoPor) {
        this.leidoPor = leidoPor;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
