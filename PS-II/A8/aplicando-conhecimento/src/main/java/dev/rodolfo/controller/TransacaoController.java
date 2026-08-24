package dev.rodolfo.controller;

import dev.rodolfo.controller.dto.TransacaoDTO;
import dev.rodolfo.exception.ValorInvalidoException;
import dev.rodolfo.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacoes")
@CrossOrigin(origins = "*")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> listar() {

        List<TransacaoDTO> response = transacaoService.findAll();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDTO> listarPorId(
            @PathVariable Long id
    ) {
        TransacaoDTO response = transacaoService.findById(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> salvar(
            @RequestBody TransacaoDTO transacaoDTO
    ) throws ValorInvalidoException {
        transacaoService.salvar(transacaoDTO);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(
            @PathVariable Long id,
            @RequestBody TransacaoDTO transacaoDTO
    ) throws ValorInvalidoException {
        transacaoService.atualizar(id, transacaoDTO);

        return ResponseEntity.ok().body("Transação atualizada com sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> remover(
            @PathVariable Long id
    ) {
        transacaoService.excluir(id);

        return ResponseEntity.ok().body("Transação removida com sucesso!");
    }
}
