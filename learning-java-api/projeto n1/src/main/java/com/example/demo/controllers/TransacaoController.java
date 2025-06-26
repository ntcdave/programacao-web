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
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class TransacaoController {
    @Autowired
    TransacaoServices transacaoServices;

   @PostMapping("/transacao")
public ResponseEntity<Void> salvar(@Valid @RequestBody TransacaoDTO transacaoDTO){

    // 1. Validação: A transação NÃO DEVE ter valor negativo [cite: 11]
    if (transacaoDTO.valor() < 0) {
        // Resposta 422 Unprocessable Entity sem corpo
        return ResponseEntity.unprocessableEntity().build();
    }

    // 2. Validação: A transação NÃO DEVE acontecer no futuro [cite: 11]
    if (transacaoDTO.datahora().isAfter(OffsetDateTime.now())) {
        // Resposta 422 Unprocessable Entity sem corpo
        return ResponseEntity.unprocessableEntity().build();
    }

    // Se as validações passarem, continua o processo normal
    Transacao transacao = new Transacao();
    transacao.setValor(transacaoDTO.valor());
    transacao.setDataHora(transacaoDTO.datahora());

    transacaoServices.salvar(transacao);

    // Resposta 201 Created sem corpo. `build()` é uma forma de fazer isso.
    return ResponseEntity.status(HttpStatus.CREATED).build();
}

    @GetMapping("/transacao")
    public ResponseEntity<List<Transacao>> buscarTodas(){
        List<Transacao> transacoes = transacaoServices.buscarTodas();
        if(transacoes.isEmpty()){
            return new ResponseEntity<List<Transacao>>(HttpStatus.NOT_FOUND);
        }else{
         return new ResponseEntity<List<Transacao>>(transacoes, HttpStatus.FOUND);
        }
    }
    @DeleteMapping("/transacao")
    public ResponseEntity<Void> apagarTodas() {
    transacaoServices.apagarTodasAsTransacoes();

    // Resposta 200 OK sem corpo, como pedido no PDF [cite: 14]
    return ResponseEntity.ok().build();
}
}
