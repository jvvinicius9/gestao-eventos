package com.seuevento.gestaoeventos.service;

import com.seuevento.gestaoeventos.dto.ParticipanteDTO;
import com.seuevento.gestaoeventos.model.Participante;

import java.util.List;

public interface ParticipanteService {
    Participante salvar(ParticipanteDTO dto);
    List<Participante> listarTodos();
}
