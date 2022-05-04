package com.cenfotec.examen.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Padre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telfPrim;

    @Column(nullable = false)
    private String telfSec;

    public Padre(){};

    public Padre(int id, String nombre, String cedula, String direccion, String telfPrim, String telfSec) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telfPrim = telfPrim;
        this.telfSec = telfSec;
    }

    public Padre(String nombre, String cedula, String direccion, String telfPrim, String telfSec) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telfPrim = telfPrim;
        this.telfSec = telfSec;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelfPrim() {
        return telfPrim;
    }

    public void setTelfPrim(String telfPrim) {
        this.telfPrim = telfPrim;
    }

    public String getTelfSec() {
        return telfSec;
    }

    public void setTelfSec(String telfSec) {
        this.telfSec = telfSec;
    }
}
