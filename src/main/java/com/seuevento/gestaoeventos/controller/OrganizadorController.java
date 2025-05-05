package com.seuevento.gestaoeventos.controller;

import com.seuevento.gestaoeventos.dto.OrganizadorDTO;
import com.seuevento.gestaoeventos.model.Organizador;
import com.seuevento.gestaoeventos.service.OrganizadorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizadores")
public class OrganizadorController {

    private final OrganizadorService service;

    public OrganizadorController(OrganizadorService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organizador salvar(@RequestBody OrganizadorDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Organizador> listar() {
        return service.listarTodos();
    }
}
