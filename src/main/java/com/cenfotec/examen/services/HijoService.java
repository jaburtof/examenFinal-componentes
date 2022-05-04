package com.cenfotec.examen.services;

import com.cenfotec.examen.entities.Hijo;
import com.cenfotec.examen.entities.Padre;
import com.cenfotec.examen.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HijoService {

    @Autowired
    HijoRepository hijoRepo;


    public List<Hijo> getAllHijos(int count) {
        return this.hijoRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Hijo> getHijo(int id) {
        return this.hijoRepo.findById(id);
    }

    //punto#5
    public List<Hijo> getHijoByPadre(int id) {
        List hijos = this.hijoRepo.findAll().stream().collect(Collectors.toList());
        List<Hijo> myList = new ArrayList<>();

        for (int i=0; i<hijos.size(); i++){
            Hijo hijo = Hijo.class.cast(hijos.get(i));
            if(id == hijo.getPadres()) {
                myList.add(hijo);
            }
        }
        return myList;
    }

    public Hijo createHijo(String nombre, boolean lectura, boolean guarderia, String alergias, int padres) {
        Hijo hijo = new Hijo();
        hijo.setNombre(nombre);
        hijo.setLectura(lectura);
        hijo.setGuarderia(guarderia);
        hijo.setAlergias(alergias);
        hijo.setPadres(padres);
        return this.hijoRepo.save(hijo);
    }

    public void save(Hijo hijoEntity) {
        this.hijoRepo.save(hijoEntity);
    }
}
