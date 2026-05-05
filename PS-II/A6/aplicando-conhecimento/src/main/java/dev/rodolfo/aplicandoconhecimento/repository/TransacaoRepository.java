package dev.rodolfo.aplicandoconhecimento.repository;

import dev.rodolfo.aplicandoconhecimento.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}