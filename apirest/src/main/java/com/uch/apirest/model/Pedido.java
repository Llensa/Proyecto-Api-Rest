package com.uch.apirest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCliente;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "cereal_id")
    private Cereal cereal;
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cereal getCereal() {
        return cereal;
    }

    public void setCereal(Cereal cereal) {
        this.cereal = cereal;
    }
}
