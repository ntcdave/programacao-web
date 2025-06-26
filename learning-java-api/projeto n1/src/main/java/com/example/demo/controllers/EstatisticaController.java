package com.example.demo.controllers;

import com.example.demo.dtos.EstatisticaDTO;
import com.example.demo.services.TransacaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private TransacaoServices transacaoServices;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> getEstatisticas() {
        DoubleSummaryStatistics stats = transacaoServices.calcularEstatisticas();

        // Conforme o PDF, se não houver transações, todos os valores devem ser zero[cite: 21].
        if (stats.getCount() == 0) {
            return ResponseEntity.ok(new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0));
        }

        // O PDF especifica que, em caso normal, o 'min' e 'max' devem ser retornados.
        // A classe DoubleSummaryStatistics pode retornar "Infinity" para min se não houver dados,
        // então criamos o DTO para garantir a estrutura correta do JSON.
        EstatisticaDTO response = new EstatisticaDTO(
            stats.getCount(),
            stats.getSum(),
            stats.getAverage(),
            stats.getMin(),
            stats.getMax()
        );

        return ResponseEntity.ok(response);
    }
}