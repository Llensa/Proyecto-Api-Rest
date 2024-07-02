package com.uch.apirest.controller;

import com.uch.apirest.model.Proveedor;
import com.uch.apirest.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorService.obtenerTodosLosProveedores();
    }

    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.crearProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor detallesProveedor) {
        return proveedorService.actualizarProveedor(id, detallesProveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
    }
}
