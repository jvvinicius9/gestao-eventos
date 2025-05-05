package com.seuevento.gestaoeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seuevento.gestaoeventos.model.Organizador;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long>{
    
}
