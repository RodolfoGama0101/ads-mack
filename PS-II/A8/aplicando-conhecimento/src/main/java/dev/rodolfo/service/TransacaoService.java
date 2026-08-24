package dev.rodolfo.service;

import dev.rodolfo.controller.dto.TransacaoDTO;
import dev.rodolfo.enums.TipoTransacaoEnum;
import dev.rodolfo.exception.TransacaoNaoEncontradaException;
import dev.rodolfo.exception.ValorInvalidoException;
import dev.rodolfo.model.Despesa;
import dev.rodolfo.model.Receita;
import dev.rodolfo.model.Transacao;
import dev.rodolfo.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    private TransacaoDTO buildTransacaoDTO(Transacao transacao) {
        return TransacaoDTO.builder()
                .id(transacao.getId())
                .data(transacao.getData())
                .descricao(transacao.getDescricao())
                .valor(transacao.getValor())
                .tipoTransacao(transacao.getTipoTransacao())
                .build();
    }

    private Transacao buildTransacaoEntity(TransacaoDTO transacaoDTO) throws ValorInvalidoException {
        if (transacaoDTO.tipoTransacao().equals(TipoTransacaoEnum.RECEITA)) {
            return new Receita(transacaoDTO.descricao(), transacaoDTO.valor(), transacaoDTO.data());
        }

        if (transacaoDTO.tipoTransacao().equals(TipoTransacaoEnum.DESPESA)) {
            return new Despesa(transacaoDTO.descricao(), transacaoDTO.valor(), transacaoDTO.data());
        }

        return null;
    }

    public List<TransacaoDTO> findAll() {

        List<Transacao> transacoes = transacaoRepository.findAll();

        return transacoes.stream()
                .map(this::buildTransacaoDTO)
                .collect(Collectors.toList());
    }

    public TransacaoDTO findById(Long id) {
        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(() -> new TransacaoNaoEncontradaException("Transacao não encontrada para esse ID"));

        return this.buildTransacaoDTO(transacao);
    }

    public void salvar(TransacaoDTO dto) throws ValorInvalidoException {
        Transacao transacao = this.buildTransacaoEntity(dto);

        if (transacao == null) {
            throw new IllegalArgumentException("Erro ao salvar transação");
        }

        transacaoRepository.save(transacao);
    }

    public void atualizar(Long id, TransacaoDTO dto) throws ValorInvalidoException {
        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(() -> new TransacaoNaoEncontradaException("Transacao não encontrada para esse ID"));

        transacao.setDescricao(dto.descricao());
        transacao.setData(dto.data());
        transacao.setValor(dto.valor());

        transacaoRepository.save(transacao);
    }

    public void excluir(Long id) {
        transacaoRepository.deleteById(id);
    }
}
