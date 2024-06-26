package com.uch.apirest.controller;

import com.uch.apirest.exception.ResourceNotFoundException;
import com.uch.apirest.model.Cereal;
import com.uch.apirest.service.CerealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cereales")
public class CerealController {

    @Autowired
    private CerealService cerealService;

    @GetMapping
    public List<Cereal> getAllCereales() {
        return cerealService.obtenerTodos();
    }

    @PostMapping
    public Cereal createCereal(@RequestBody Cereal cereal) {
        return cerealService.agregarCereal(cereal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cereal> getCerealById(@PathVariable(value = "id") Long cerealId) {
        Cereal cereal = cerealService.obtenerPorId(cerealId)
                .orElseThrow(() -> new ResourceNotFoundException("Cereal no encontrado para este id :: " + cerealId));
        return ResponseEntity.ok().body(cereal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cereal> updateCereal(@PathVariable(value = "id") Long cerealId,
                                               @RequestBody Cereal cerealDetails) {
        Cereal updatedCereal = cerealService.modificarCereal(cerealId, cerealDetails);
        return ResponseEntity.ok(updatedCereal);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCereal(@PathVariable(value = "id") Long cerealId) {
        cerealService.eliminarCereal(cerealId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
