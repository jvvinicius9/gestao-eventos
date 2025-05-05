package com.seuevento.gestaoeventos.service.impl;

import com.seuevento.gestaoeventos.dto.OrganizadorDTO;
import com.seuevento.gestaoeventos.model.Organizador;
import com.seuevento.gestaoeventos.repository.OrganizadorRepository;
import com.seuevento.gestaoeventos.service.OrganizadorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorServiceImpl implements OrganizadorService {

    private final OrganizadorRepository repository;

    public OrganizadorServiceImpl(OrganizadorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Organizador salvar(OrganizadorDTO dto) {
        Organizador organizador = new Organizador();
        organizador.setNome(dto.getNome());
        organizador.setCpf(dto.getCpf());
        organizador.setEmail(dto.getEmail());
        return repository.save(organizador);
    }

    @Override
    public List<Organizador> listarTodos() {
        return repository.findAll();
    }
}
