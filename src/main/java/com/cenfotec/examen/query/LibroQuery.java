package com.cenfotec.examen.query;

import com.cenfotec.examen.entities.Hijo;
import com.cenfotec.examen.entities.Libro;
import com.cenfotec.examen.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LibroQuery implements GraphQLQueryResolver {

    @Autowired
    private LibroService libroService;

    public List<Libro> getLibros(int count) {return this.libroService.getAllLibros(count);}
    public Optional<Libro> getLibro(int id) {
        return this.libroService.getLibro(id);
    }

    //#punto 8

    public List<Libro> getLibrosByHijo(String name) {
        return this.libroService.getLibrosByHijo(name);
    }


    //#punto 9
    public List<Libro> getLibrosByHijos() {
        return this.libroService.getLibrosByHijos();
    }



}
