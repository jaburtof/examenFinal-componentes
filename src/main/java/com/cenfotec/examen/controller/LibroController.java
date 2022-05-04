package com.cenfotec.examen.controller;

import com.cenfotec.examen.entities.Libro;
import com.cenfotec.examen.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ({"/libro"})
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping(path = "/getLibros/{count}")
    public List<Libro> getHijos(@PathVariable int count) {

        return this.libroService.getAllLibros(count);
    }

    @DeleteMapping ("/{id}")
    public Libro updateLibro(@PathVariable("id") int id, @RequestBody Libro libroActualizar) {
        Optional<Libro> libro = this.libroService.getLibro(id);
        if (libro.isPresent()) {
            Libro libroEntity = libro.get();
            if (libroActualizar.getNombreLibro()!=null)
                libroEntity.setNombreLibro(libroActualizar.getNombreLibro());
            if (libroActualizar.getLeidoPor() != null)
                libroEntity.setLeidoPor(libroEntity.getLeidoPor());
            if (libroActualizar.getEstado() != null )
                libroEntity.setEstado(false);
            libroService.save(libroEntity);
            return libroEntity;
        }
        return null;
    }

}
