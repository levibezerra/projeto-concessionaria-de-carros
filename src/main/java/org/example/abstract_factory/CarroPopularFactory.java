package org.example.abstract_factory;

import org.example.entity.Carro;
import org.example.entity.CarroPopular;
import org.example.repository.CarroFactory;

public class CarroPopularFactory implements CarroFactory {

    @Override
    public Carro criarCarro() {
        return new CarroPopular();
    }
}