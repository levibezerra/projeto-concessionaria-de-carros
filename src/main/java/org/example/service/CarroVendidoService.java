package org.example.service;

import org.example.dao.CarroVendidoDao;
import org.example.dto.CarroVendidoDto;
import org.example.entity.Carro;
import org.example.entity.CarroPopular;
import org.example.entity.CarroVendido;

import java.util.List;

public class CarroVendidoService {

    private CarroVendidoDao carroVendidoDao;

    public CarroVendidoService(CarroVendidoDao carroVendidoDao) {
        this.carroVendidoDao = carroVendidoDao;
    }
}