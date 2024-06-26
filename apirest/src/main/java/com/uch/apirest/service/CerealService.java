package com.uch.apirest.service;

import com.uch.apirest.exception.ResourceNotFoundException;
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
        if (cereal.getNutricion() != null) {
            cereal.getNutricion().setCereal(cereal);
        }
        return cerealRepository.save(cereal);
    }

    public Cereal modificarCereal(Long id, Cereal cereal) {
        Cereal existingCereal = cerealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cereal no encontrado para este id :: " + id));

        existingCereal.setNombre(cereal.getNombre());
        existingCereal.setMarca(cereal.getMarca());
        existingCereal.setPrecio(cereal.getPrecio());

        if (cereal.getNutricion() != null) {
            cereal.getNutricion().setCereal(existingCereal);
            existingCereal.setNutricion(cereal.getNutricion());
        }

        return cerealRepository.save(existingCereal);
    }

    public void eliminarCereal(Long id) {
        Cereal existingCereal = cerealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cereal no encontrado para este id :: " + id));
        cerealRepository.delete(existingCereal);
    }
}
