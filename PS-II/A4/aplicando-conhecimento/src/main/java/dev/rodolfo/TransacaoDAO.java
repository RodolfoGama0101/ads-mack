package dev.rodolfo;

import dev.rodolfo.exception.ValorInvalidoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    public void salvar(Transacao t) {
        String sql = "INSERT INTO transacoes (descricao, valor, data, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getDescricao());
            stmt.setDouble(2, t.getValor());
            stmt.setString(3, t.getData().toString());

            if (t instanceof Receita) {
                stmt.setString(4, "RECEITA");
            } else if (t instanceof Despesa) {
                stmt.setString(4, "DESPESA");
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao salvar transação: " + e.getMessage());
        }
    }

    public List<Transacao> listar() {
        List<Transacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM transacoes";

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Double valor = rs.getDouble("valor");
                LocalDate data = LocalDate.parse(rs.getString("data"));
                String tipo = rs.getString("tipo");

                Transacao t = null;

                try {
                    if ("RECEITA".equals(tipo)) {
                        t = new Receita();
                    } else if ("DESPESA".equals(tipo)) {
                        t = new Despesa();
                    }

                    if (t != null) {
                        t.setDescricao(descricao);
                        t.setValor(valor);
                        t.setData(data);
                        lista.add(t);
                    }
                } catch (ValorInvalidoException | IllegalArgumentException e) {
                    System.err.println("Erro ao carregar transação do banco: " + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar transações: " + e.getMessage());
        }

        return lista;
    }
}