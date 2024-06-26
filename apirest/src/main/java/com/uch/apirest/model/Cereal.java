package com.uch.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String informacion;

    // Constructor sin parámetros
    public Cereal() {}

    // Constructor con parámetros
    public Cereal(Long id, String nombre, String marca, double precio, Nutricion nutricion) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.nutricion = nutricion;
        if (nutricion != null) {
            nutricion.setCereal(this);
        }
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
        if (nutricion != null) {
            nutricion.setCereal(this);
        }
    }

    // El getter para 'informacion' puede ser opcionalmente omitido
    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
