package org.example.entity;

import jakarta.persistence.Entity;

@Entity(name = "carro_popular")
public class CarroPopular extends Carro{

    public CarroPopular(String marca, String modelo) {
        super(marca, modelo);
    }

    public CarroPopular() {
        super(null, null);
    }

    @Override
    public String descricao() {
        return "Um carro popular da marca " + getMarca() + " e o modelo " + getModelo() + " foi adicionado!";
    }
}