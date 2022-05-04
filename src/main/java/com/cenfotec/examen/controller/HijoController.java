package com.cenfotec.examen.controller;

import com.cenfotec.examen.entities.Hijo;
import com.cenfotec.examen.services.HijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping ({"/hijo"})
public class HijoController {

    @Autowired
    private HijoService hijoService;

    @GetMapping(path = "/getHijos/{count}")
    public List<Hijo> getHijos(@PathVariable int count) {

        return this.hijoService.getAllHijos(count);
    }

    @GetMapping(path = "/getHijo/{id}")
    public Optional<Hijo> getHijo(@PathVariable int id) {
        return this.hijoService.getHijo(id);
    }

    @GetMapping (path = "/getHijoByPadre/{id}")
    public List<Hijo> getHijoByPadre(@PathVariable int id) {return this.hijoService.getHijoByPadre(id);}

    @PostMapping
    public Hijo createHijo(@RequestBody Hijo hijo) {
        return this.hijoService.createHijo(hijo.getNombre(), hijo.isLectura(), hijo.isGuarderia(), hijo.getAlergias(),hijo.getPadres());
    }
    @PutMapping ("/{id}")
    public Hijo updateHijo(@PathVariable("id") int id, @RequestBody Hijo hijoActualizar) {
        Optional<Hijo> hijo = this.hijoService.getHijo(id);
        if (hijo.isPresent()) {
            Hijo hijoEntity = hijo.get();
            if (hijoActualizar.getNombre()!=null)
                hijoEntity.setNombre(hijoActualizar.getNombre());
            if (hijoActualizar.isLectura() == true || hijoActualizar.isLectura() == false)
                hijoEntity.setLectura(hijoActualizar.isLectura());
            if (hijoActualizar.isGuarderia() == true || hijoActualizar.isGuarderia() == false)
                hijoEntity.setGuarderia(hijoActualizar.isGuarderia());
            if (hijoActualizar.getAlergias() != null)
                hijoEntity.setAlergias(hijoActualizar.getAlergias());
            if (hijoActualizar.getPadres() != 0)
                hijoEntity.setPadres(hijoActualizar.getPadres());
            hijoService.save(hijoEntity);
            return hijoEntity;
        }
        return null;
    }

}
