package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.OffsetDateTime;

public record TransacaoDTO(
    int id,
    @NotEmpty(message = "O valor não pode ser vazio")
    @NotBlank(message = "O valor nao pode ser vazioo")
    double valor,
    OffsetDateTime datahora
){}