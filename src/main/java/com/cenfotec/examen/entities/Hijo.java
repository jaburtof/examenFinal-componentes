package com.cenfotec.examen.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Hijo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private boolean lectura;

    @Column(nullable = false)
    private boolean guarderia;

    @Column(nullable = false)
    private String alergias;

    @Column(nullable = false)
    private int padres;


    public Hijo(){};

    public Hijo(int id, String nombre, boolean lectura, boolean guarderia, String alergias, int padres) {
        this.id = id;
        this.nombre = nombre;
        this.lectura = lectura;
        this.guarderia = guarderia;
        this.alergias = alergias;
        this.padres = padres;
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

    public boolean isLectura() {
        return lectura;
    }

    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }

    public boolean isGuarderia() {
        return guarderia;
    }

    public void setGuarderia(boolean guarderia) {
        this.guarderia = guarderia;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getPadres() {
        return padres;
    }

    public void setPadres(int padres) {
        this.padres = padres;
    }
}
