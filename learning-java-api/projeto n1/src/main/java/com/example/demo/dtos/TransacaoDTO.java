package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull; // <-- MUDE OS IMPORTS
import java.time.OffsetDateTime;

public record TransacaoDTO(
    int id,

    // Use @NotNull para tipos numéricos e de data. @NotEmpty/@NotBlank são para Strings.
    @NotNull(message = "O valor não pode ser nulo")
    double valor,

    @NotNull(message = "A data/hora não pode ser nula")
    OffsetDateTime datahora
){}