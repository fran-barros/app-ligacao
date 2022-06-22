package com.example.appligacao.controller;

import com.example.appligacao.domain.Ligacao;
import com.example.appligacao.domain.Telefone;
import com.example.appligacao.service.LigacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class LigacaoController {

    private final LigacaoService service;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ligacao> fazerLigacao(@RequestBody Ligacao request, @RequestHeader boolean agenda){

        Ligacao ligacao = service.fazerLigacao(request, agenda);

        return ResponseEntity.status(HttpStatus.CREATED).body(ligacao);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ligacao> encerrarLigacao(@RequestHeader String id){

        Ligacao ligacao = service.encerrarLigacao(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ligacao);
    }
}
