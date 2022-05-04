package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Libro;
import com.cenfotec.examen.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepo;


    public List<Libro> getAllLibros(int count) {
        return this.libroRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Libro> getLibro(int id) {
        return this.libroRepo.findById(id);
    }

    public List<Libro> getLibrosByHijo(String nombre) {
        List libros = this.libroRepo.findAll().stream().collect(Collectors.toList());
        List<Libro> sortDeleted = new ArrayList<>();
        //filtro de eliminados
        for (int i=0; i<libros.size(); i++){
            Libro libro = Libro.class.cast(libros.get(i));
            if(libro.getEstado() != false){
                sortDeleted.add(libro);
            }
        }


        List<Libro> myList = new ArrayList<>();

        for (int i=0; i<sortDeleted.size(); i++){
            Libro libro = Libro.class.cast(sortDeleted.get(i));
            if(nombre.equals(libro.getLeidoPor())) {
                myList.add(libro);
            }
        }
        return myList;
    }
    public List<Libro> getLibrosByHijos() {
        List<Libro> libros = this.libroRepo.findAll().stream().collect(Collectors.toList());
        List<Libro> sortDeleted = new ArrayList<>();
        //filtro de eliminados
        for (int i=0; i<libros.size(); i++){
            Libro libro = Libro.class.cast(libros.get(i));
            if(libro.getEstado() != false){
                sortDeleted.add(libro);
            }
        }



        List<Libro> myList = new ArrayList<>();
        List<String> nombresList = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<Integer>();

        //hace un array de los hijos que han leido libros - sirve
        for (int i=0; i<sortDeleted.size(); i++){
            Libro libro = Libro.class.cast(sortDeleted.get(i));
            int existe = 0;

            for(String nombre : nombresList ){
                if (libro.getLeidoPor().equals(nombre)){
                    existe++;
                }
            }
            if(existe == 0){
                nombresList.add(libro.getLeidoPor());
            }
        }

        //suma cuantos libros leidos por cada  hijo
        for (int i=0; i<nombresList.size(); i++){
            int contadorLeidos = 0;

            for(Libro libro : sortDeleted){
                if(libro.getLeidoPor().equals(nombresList.get(i))) {
                    contadorLeidos++;
                }
            }
            num.add(contadorLeidos);
        }

        //llenar la lista
        for (int i=0; i<nombresList.size(); i++) {
            Libro libro = new Libro();
            libro.setLeidoPor(nombresList.get(i));
            libro.setCant(num.get(i));
            myList.add(libro);
        }
        return myList;
    }



    public Libro createLibro(String nombreLibro, String leidoPor, Boolean estado) {
        Libro libro = new Libro();
        libro.setNombreLibro(nombreLibro);
        libro.setLeidoPor(leidoPor);
        libro.setEstado(true);
        return this.libroRepo.save(libro);
    }



    public void save(Libro libroEntity) {
        this.libroRepo.save(libroEntity);
    }
}
