package org.example.entity;

import jakarta.persistence.Entity;

@Entity(name = "carro_esportivo")
public class CarroEsportivo extends Carro{

    public CarroEsportivo(String marca, String modelo) {
        super(marca, modelo);
    }

    public CarroEsportivo() {
        super(null, null);
    }

    @Override
    public String descricao() {
        return "Um carro esportivo da marca " + getMarca() + " e o modelo " + getModelo() + " foi adicionado!";
    }
}