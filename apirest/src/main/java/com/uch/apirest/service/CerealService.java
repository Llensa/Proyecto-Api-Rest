package com.uch.apirest.service;

import com.uch.apirest.model.Cereal;
import com.uch.apirest.repository.CerealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CerealService {

    @Autowired
    private CerealRepository cerealRepository;

    public List<Cereal> obtenerTodosLosCereales() {
        return cerealRepository.findAll();
    }

    public Cereal crearCereal(Cereal cereal) {
        return cerealRepository.save(cereal);
    }

    public Cereal actualizarCereal(Long id, Cereal detallesCereal) {
        Cereal cereal = cerealRepository.findById(id).orElseThrow();
        cereal.setNombre(detallesCereal.getNombre());
        cereal.setTipo(detallesCereal.getTipo());
        return cerealRepository.save(cereal);
    }

    public void eliminarCereal(Long id) {
        cerealRepository.deleteById(id);
    }
}
