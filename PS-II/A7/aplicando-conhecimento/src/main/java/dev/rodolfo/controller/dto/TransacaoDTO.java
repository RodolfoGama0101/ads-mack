package dev.rodolfo.controller.dto;

import dev.rodolfo.enums.TipoTransacaoEnum;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TransacaoDTO(
    Long id,
    LocalDate data,
    String descricao,
    Double valor,
    TipoTransacaoEnum tipoTransacao
) { }
