package com.seuevento.gestaoeventos.controller;

import com.seuevento.gestaoeventos.dto.ParticipanteDTO;
import com.seuevento.gestaoeventos.model.Participante;
import com.seuevento.gestaoeventos.service.ParticipanteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    private final ParticipanteService service;

    public ParticipanteController(ParticipanteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Participante salvar(@RequestBody ParticipanteDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Participante> listar() {
        return service.listarTodos();
    }
}
