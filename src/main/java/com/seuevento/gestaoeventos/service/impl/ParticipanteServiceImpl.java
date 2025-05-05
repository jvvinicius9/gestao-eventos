package com.seuevento.gestaoeventos.service.impl;

import com.seuevento.gestaoeventos.dto.ParticipanteDTO;
import com.seuevento.gestaoeventos.model.Participante;
import com.seuevento.gestaoeventos.repository.ParticipanteRepository;
import com.seuevento.gestaoeventos.service.ParticipanteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    private final ParticipanteRepository repository;

    public ParticipanteServiceImpl(ParticipanteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Participante salvar(ParticipanteDTO dto) {
        Participante participante = new Participante();
        participante.setNome(dto.getNome());
        participante.setEmail(dto.getEmail());
        participante.setTelefone(dto.getTelefone());
        return repository.save(participante);
    }

    @Override
    public List<Participante> listarTodos() {
        return repository.findAll();
    }
}
