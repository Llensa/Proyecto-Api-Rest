package com.uch.apirest.service;


import com.uch.apirest.model.Cereal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CerealService {
    private List<Cereal> cereales = new ArrayList<>();

    public CerealService() {
        // Agregar algunos cereales de ejemplo
        cereales.add(new Cereal(1L, "Zucaritas", "Kellogg's", 150.0));
        cereales.add(new Cereal(2L, "Choco Krispies", "Kellogg's", 180.0));
        cereales.add(new Cereal(3L, "Froot Loops", "Kellogg's", 170.0));
        cereales.add(new Cereal(4L, "Granola", "Quaker", 200.0));
        cereales.add(new Cereal(5L, "Avena", "Quaker", 200.0));
    }

    public List<Cereal> obtenerTodos() {
        return cereales;
    }

    public Cereal obtenerPorId(Long id) {
        return cereales.stream()
                .filter(cereal -> cereal.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void agregarCereal(Cereal cereal) {
        cereales.add(cereal);
    }
}

