package com.seuevento.gestaoeventos.service.impl;

import com.seuevento.gestaoeventos.dto.EventoDTO;
import com.seuevento.gestaoeventos.model.*;
import com.seuevento.gestaoeventos.repository.*;
import com.seuevento.gestaoeventos.service.EventoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;
    private final OrganizadorRepository organizadorRepository;
    private final ParticipanteRepository participanteRepository;

    public EventoServiceImpl(EventoRepository eventoRepository, OrganizadorRepository organizadorRepository,
                             ParticipanteRepository participanteRepository) {
        this.eventoRepository = eventoRepository;
        this.organizadorRepository = organizadorRepository;
        this.participanteRepository = participanteRepository;
    }

    @Override
    @Transactional
    public Evento salvar(EventoDTO dto) {
        Organizador organizador = organizadorRepository.findById(dto.getOrganizadorId())
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado"));

        List<Participante> participantes = new ArrayList<>();
        if (dto.getParticipantesIds() != null) {
            for (Long id : dto.getParticipantesIds()) {
                Participante p = participanteRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Participante com ID " + id + " não encontrado"));
                participantes.add(p);
            }
        }

        Evento evento = new Evento();
        evento.setNome(dto.getNome());
        evento.setDescricao(dto.getDescricao());
        evento.setLocal(dto.getLocal());
        evento.setData(dto.getData());
        
        try {
            evento.setStatus(StatusEvento.valueOf(dto.getStatus().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Status inválido. Valores permitidos: PENDENTE, ACONTECENDO, ENCERRADO, CANCELADO");
        }
        
        evento.setOrganizador(organizador);
        evento.setParticipantes(participantes);

        return eventoRepository.save(evento);
    }

    @Override
    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    @Override
    public void excluir(Long id) {
        eventoRepository.deleteById(id);
    }
}
