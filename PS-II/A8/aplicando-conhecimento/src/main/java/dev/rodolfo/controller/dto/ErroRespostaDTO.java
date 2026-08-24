package dev.rodolfo.controller.dto;

import java.time.LocalDateTime;

public record ErroRespostaDTO(
    LocalDateTime timestamp,
    Integer status,
    String erro,
    String mensagem
) { }