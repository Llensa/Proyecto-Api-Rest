package com.uch.apirest.controller;



import com.uch.apirest.model.Cereal;
import com.uch.apirest.service.CerealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cereales")
public class CerealController {
    @Autowired
    private CerealService cerealService;

    @GetMapping
    public List<Cereal> obtenerTodos() {
        return cerealService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Cereal obtenerPorId(@PathVariable Long id) {
        return cerealService.obtenerPorId(id);
    }

    @PostMapping
    public void agregarCereal(@RequestBody Cereal cereal) {
        cerealService.agregarCereal(cereal);
    }
}
