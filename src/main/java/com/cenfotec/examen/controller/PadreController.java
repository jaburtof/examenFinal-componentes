package com.cenfotec.examen.controller;

import com.cenfotec.examen.entities.Padre;
import com.cenfotec.examen.services.HijoService;
import com.cenfotec.examen.services.PadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping({"/padre"})
public class PadreController {

    @Autowired
    private PadreService padreService;

    @GetMapping (path = "/getPadres/{count}")
    public List<Padre> getPadres(@PathVariable int count) {

        return this.padreService.getAllPadres(count);
    }

    @GetMapping(path = "/getPadre/{id}")
    public Optional<Padre> getPadre(@PathVariable int id) {
        return this.padreService.getPadre(id);
    }

    @GetMapping(path = "/getPadreByName/{name}")
    public List<Padre> getPadreByName(@PathVariable String name) {return this.padreService.getPadreByName(name);}

    @PostMapping
    public Padre createPadre(@RequestBody Padre padre) {
        return this.padreService.createPadre(padre.getNombre(), padre.getCedula(), padre.getDireccion(), padre.getTelfPrim(), padre.getTelfSec() );
    }

    @PutMapping ("/{id}")
    public Padre updatePadre(@PathVariable("id") int id, @RequestBody Padre padreActualizar) {
        Optional<Padre> padre = this.padreService.getPadre(id);
        if (padre.isPresent()) {
            Padre padreEntity = padre.get();
            if (padreActualizar.getNombre()!=null)
                padreEntity.setNombre(padreActualizar.getNombre());
            if (padreActualizar.getCedula() != null)
                padreEntity.setCedula(padreActualizar.getCedula());
            if (padreActualizar.getDireccion() != null)
                padreEntity.setDireccion(padreActualizar.getDireccion());
            if (padreActualizar.getTelfPrim() != null)
                padreEntity.setTelfPrim(padreActualizar.getTelfPrim());
            if (padreActualizar.getTelfSec() != null)
                padreEntity.setTelfSec(padreActualizar.getTelfSec());
            padreService.save(padreEntity);
            return padreEntity;
        }
        return null;
    }

}
