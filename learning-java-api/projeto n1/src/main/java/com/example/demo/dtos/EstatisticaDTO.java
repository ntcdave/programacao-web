package com.example.demo.dtos;

// Usar 'record' é uma forma moderna e concisa de criar classes de dados.
public record EstatisticaDTO(
    long count,
    double sum,
    double avg,
    double min,
    double max
) {}