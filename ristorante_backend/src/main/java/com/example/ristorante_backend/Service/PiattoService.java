package com.example.ristorante_backend.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ristorante_backend.Model.Piatto;
import com.example.ristorante_backend.Repository.PiattoRepository;

@Service
public class PiattoService {
    @Autowired
    private PiattoRepository piattoRepository;
    
    public List<Piatto> getAllPiatti() {
        return piattoRepository.findAll();
    }

    public Piatto addPiatto(Piatto piatto) {
        return piattoRepository.save(piatto);
    }
    
    public void deletePiatto(Long id) {
        piattoRepository.deleteById(id);
    }
}
