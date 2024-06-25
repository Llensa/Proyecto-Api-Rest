package com.uch.apirest.service;


import com.uch.apirest.model.Cereal;
import com.uch.apirest.repository.CerealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CerealService {
    @Autowired
    private CerealRepository cerealRepository;

    public List<Cereal> obtenerTodos() {
        return cerealRepository.findAll();
    }

    public Optional<Cereal> obtenerPorId(Long id) {
        return cerealRepository.findById(id);
    }

    public Cereal agregarCereal(Cereal cereal) {
        return cerealRepository.save(cereal);
    }

    public Cereal modificarCereal(Cereal cereal) {
        if (cereal.getId() == null || !cerealRepository.existsById(cereal.getId())) {
            throw new RuntimeException("Cereal no encontrado");
        }
        return cerealRepository.save(cereal);
    }

    public void eliminarCereal(Long id) {
        cerealRepository.deleteById(id);
    }
}