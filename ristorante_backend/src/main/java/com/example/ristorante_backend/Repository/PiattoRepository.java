package com.example.ristorante_backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ristorante_backend.Model.Piatto;

@Repository
public interface PiattoRepository extends JpaRepository<Piatto, Long> {
    
}
