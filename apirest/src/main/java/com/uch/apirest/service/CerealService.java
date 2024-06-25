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

    public Cereal modificarCereal(Long id, Cereal cereal) {
        if (!cerealRepository.existsById(id)) {
            throw new RuntimeException("Cereal no encontrado");
        }
        cereal.setId(id);  // Asegura que el cereal tenga el ID correcto
        return cerealRepository.save(cereal);
    }

    public void eliminarCereal(Long id) {
        cerealRepository.deleteById(id);
    }
}
