package com.seuevento.gestaoeventos.controller;

import com.seuevento.gestaoeventos.dto.EventoDTO;
import com.seuevento.gestaoeventos.model.Evento;
import com.seuevento.gestaoeventos.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento criarEvento(@RequestBody EventoDTO dto) {
        return eventoService.salvar(dto);
    }

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        try {
            Evento evento = eventoService.buscarPorId(id);
            return ResponseEntity.ok(evento);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        eventoService.excluir(id);
    }
}
