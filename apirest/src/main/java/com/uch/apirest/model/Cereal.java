package com.uch.apirest.model;

import jakarta.persistence.*;

@Entity
public class Cereal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private double precio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutricion_id", referencedColumnName = "id")
    private Nutricion nutricion;

    // Constructores, getters y setters
    public Cereal() {}

    public Cereal(String nombre, String marca, double precio, Nutricion nutricion) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.nutricion = nutricion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Nutricion getNutricion() {
        return nutricion;
    }

    public void setNutricion(Nutricion nutricion) {
        this.nutricion = nutricion;
    }
}
