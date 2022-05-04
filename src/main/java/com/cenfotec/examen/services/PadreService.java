package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Padre;
import com.cenfotec.examen.repositories.PadreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PadreService {

    @Autowired
    PadreRepository padreRepo;

    public List<Padre> getAllPadres(int count) {
        return this.padreRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Padre> getPadre(int id) {
        return this.padreRepo.findById(id);
    }

    //punto#3
    public List<Padre> getPadreByName(String name) {
        List padres = this.padreRepo.findAll().stream().collect(Collectors.toList());
        List<Padre> myList = new ArrayList<>();

        for (int i=0; i<padres.size(); i++){
            Padre padre = Padre.class.cast(padres.get(i));
            if(name.equals(padre.getNombre())) {
                myList.add(padre);
            }
        }
        return myList;
    }

    public Padre createPadre(String nombre, String cedula, String direccion, String telfPrim, String telfSec) {
        Padre padre = new Padre();
        padre.setNombre(nombre);
        padre.setCedula(cedula);
        padre.setDireccion(direccion);
        padre.setTelfPrim(telfPrim);
        padre.setTelfSec(telfSec);
        return this.padreRepo.save(padre);
    }

    public void save(Padre padreEntity) {
        this.padreRepo.save(padreEntity);
    }
}
