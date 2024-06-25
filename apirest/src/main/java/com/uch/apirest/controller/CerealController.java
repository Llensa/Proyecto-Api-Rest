package com.uch.apirest.controller;

import com.uch.apirest.model.Cereal;
import com.uch.apirest.service.CerealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cereales")
public class CerealController {
    @Autowired
    private CerealService cerealService;

    @GetMapping
    @ResponseBody
    public List<Cereal> obtenerTodos() {
        return cerealService.obtenerTodos();
    }

    @GetMapping("{id}")
    public Optional<Cereal> obtenerPorId(@PathVariable Long id) {
        return cerealService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseBody
    public Cereal agregarCereal(@RequestBody Cereal cereal) {
        return cerealService.agregarCereal(cereal);
    }

    @DeleteMapping("{id}")
    public void eliminarCereal(@PathVariable Long id) {
        cerealService.eliminarCereal(id);
    }


    @PutMapping("{id}")
    public Cereal modificarCereal(@PathVariable Long id ,@RequestBody Cereal cereal) {
        return cerealService.modificarCereal(cereal);
    }
}
