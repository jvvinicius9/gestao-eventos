package com.seuevento.gestaoeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seuevento.gestaoeventos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
    
}
