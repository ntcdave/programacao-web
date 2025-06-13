package com.example.demo.controllers;

import com.example.demo.dtos.TransacaoDTO;
import com.example.demo.models.Transacao;
import com.example.demo.services.TransacaoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    TransacaoServices transacaoServices;

    @PostMapping("/salvar")
    public ResponseEntity<Transacao> salvar(@Valid @RequestBody TransacaoDTO transacaoDTO){
        Transacao transacao = new Transacao();
        transacao.setValor(transacaoDTO.valor());
        transacao.setDataHora(transacaoDTO.datahora());

        transacaoServices.salvar(transacao);
        return new ResponseEntity<>(transacao, HttpStatus.CREATED);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Transacao>> buscarTodas(){
        List<Transacao> transacoes = transacaoServices.buscarTodas();
        if(transacoes.isEmpty()){
            return new ResponseEntity<List<Transacao>>(HttpStatus.NOT_FOUND);
        }else{
         return new ResponseEntity<List<Transacao>>(transacoes, HttpStatus.FOUND);
        }
    }
}
