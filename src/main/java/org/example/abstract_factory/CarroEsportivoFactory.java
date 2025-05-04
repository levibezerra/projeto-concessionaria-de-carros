package org.example.abstract_factory;

import org.example.entity.Carro;
import org.example.entity.CarroEsportivo;
import org.example.repository.CarroFactory;

public class CarroEsportivoFactory implements CarroFactory {

    @Override
    public Carro criarCarro() {
        return new CarroEsportivo();
    }
}