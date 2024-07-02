package com.uch.apirest.service;

import com.uch.apirest.model.Proveedor;
import com.uch.apirest.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizarProveedor(Long id, Proveedor detallesProveedor) {
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow();
        proveedor.setNombre(detallesProveedor.getNombre());
        proveedor.setPais(detallesProveedor.getPais());
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
