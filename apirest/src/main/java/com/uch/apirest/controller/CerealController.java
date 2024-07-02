package com.uch.apirest.controller;

import com.uch.apirest.model.Cereal;
import com.uch.apirest.service.CerealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cereales")
public class CerealController {

    @Autowired
    private CerealService cerealService;

    @GetMapping
    public List<Cereal> obtenerTodosLosCereales() {
        return cerealService.obtenerTodosLosCereales();
    }

    @PostMapping
    public Cereal crearCereal(@RequestBody Cereal cereal) {
        return cerealService.crearCereal(cereal);
    }

    @PutMapping("/{id}")
    public Cereal actualizarCereal(@PathVariable Long id, @RequestBody Cereal detallesCereal) {
        return cerealService.actualizarCereal(id, detallesCereal);
    }

    @DeleteMapping("/{id}")
    public void eliminarCereal(@PathVariable Long id) {
        cerealService.eliminarCereal(id);
    }
}
