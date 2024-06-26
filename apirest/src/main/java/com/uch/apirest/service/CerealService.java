package com.uch.apirest.service;

import com.uch.apirest.exception.ResourceNotFoundException;
import com.uch.apirest.model.Cereal;
import com.uch.apirest.model.Nutricion;
import com.uch.apirest.repository.CerealRepository;
import com.uch.apirest.repository.NutricionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class CerealService {

    @Autowired
    private CerealRepository cerealRepository;

    @Autowired
    private NutricionRepository nutricionRepository;

    public List<Cereal> obtenerTodos() {
        return cerealRepository.findAll();
    }

    public Optional<Cereal> obtenerPorId(Long id) {
        return cerealRepository.findById(id);
    }

    public Cereal agregarCereal(Cereal cereal) {
        if (cereal.getNutricion() != null) {
            Nutricion nutricion = cereal.getNutricion();
            nutricion.setCereal(cereal);  // Establece la relación bidireccional
            nutricionRepository.save(nutricion);
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
            Nutricion nutricion = cereal.getNutricion();
            nutricion.setCereal(existingCereal);  // Establece la relación bidireccional
            existingCereal.setNutricion(nutricion);
            nutricionRepository.save(nutricion);
        }

        return cerealRepository.save(existingCereal);
    }

    public void eliminarCereal(Long id) {
        Cereal existingCereal = cerealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cereal no encontrado para este id :: " + id));
        cerealRepository.delete(existingCereal);
    }
}
