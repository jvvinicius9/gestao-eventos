package com.seuevento.gestaoeventos.service;

import com.seuevento.gestaoeventos.dto.EventoDTO;
import com.seuevento.gestaoeventos.model.Evento;

import java.util.List;

public interface EventoService {
    Evento salvar(EventoDTO dto);
    List<Evento> listarTodos();
    Evento buscarPorId(Long id);
    void excluir(Long id);
}
