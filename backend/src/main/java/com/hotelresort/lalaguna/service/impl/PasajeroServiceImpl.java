package com.hotelresort.lalaguna.service.impl;

import com.hotelresort.lalaguna.exception.ModelNotFoundException;
import com.hotelresort.lalaguna.model.Pasajero;
import com.hotelresort.lalaguna.repository.PasajeroRepository;
import com.hotelresort.lalaguna.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServiceImpl implements PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroServiceImpl(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    @Override
    public List<Pasajero> findAll() {
        return pasajeroRepository.findAll();
    }

    @Override
    public Pasajero findById(Integer id) {
        Optional<Pasajero> op = pasajeroRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ModelNotFoundException("Pasajero no encontrado");
        }
    }

    @Override
    public Pasajero save(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    @Override
    public Pasajero update(Pasajero pasajero) {
        return save(pasajero);
    }

    @Override
    public boolean delete(Integer id) {
        pasajeroRepository.deleteById(id);
        return true;
    }
}
