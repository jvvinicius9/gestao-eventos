package com.seuevento.gestaoeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seuevento.gestaoeventos.model.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
    
}
