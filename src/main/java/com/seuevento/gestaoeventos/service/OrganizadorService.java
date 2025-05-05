package com.seuevento.gestaoeventos.service;

import com.seuevento.gestaoeventos.dto.OrganizadorDTO;
import com.seuevento.gestaoeventos.model.Organizador;

import java.util.List;

public interface OrganizadorService {
    Organizador salvar(OrganizadorDTO dto);
    List<Organizador> listarTodos();
}
