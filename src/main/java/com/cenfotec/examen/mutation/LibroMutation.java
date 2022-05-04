package com.cenfotec.examen.mutation;

import com.cenfotec.examen.entities.Libro;
import com.cenfotec.examen.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LibroMutation implements GraphQLMutationResolver {

    @Autowired
    private LibroService libroService;

    public Libro createLibro(String nombreLibro, String leidoPor, Boolean estado) {
        return this.libroService.createLibro(nombreLibro, leidoPor, estado);
    }

    public Libro updateLibro(int id, String nombreLibro, String leidoPor, Boolean estado) {
        Optional<Libro> libro = this.libroService.getLibro(id);
        if (libro.isPresent()) {
            Libro libroEntity = libro.get();
            if (nombreLibro!=null)
                libroEntity.setNombreLibro(nombreLibro);
            if (leidoPor != null)
                libroEntity.setLeidoPor(leidoPor);
            if (estado != null)
                libroEntity.setEstado(estado);
            libroService.save(libroEntity);
            return libroEntity;
        }
        return null;
    }

}
