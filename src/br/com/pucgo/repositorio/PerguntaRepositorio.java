package br.com.pucgo.repositorio;

import br.com.pucgo.modelo.Pergunta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerguntaRepositorio {
    private final String url = "jdbc:postgresql://localhost/projeto-integrador-2a";
    private final String user = "postgres";
    private final String password = "postgres";

    public void criaPergunta(Pergunta pergunta) {
        try {
            // 1 - Abre conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, user, password);

            // 2 - Crio um statement de criaçao do pergunta
            PreparedStatement ps = connection.prepareStatement("INSERT INTO perguntas (descricao, gabarito) VALUES (?, ?);");
            ps.setString(1, pergunta.getDescricao());
            ps.setString(2, pergunta.getGabarito());

            // 3 - Executo a query de criacao.
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL Error: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizaPergunta(Pergunta pergunta) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = connection.prepareStatement("update perguntas set descricao = ?, gabarito = ? where id = ?;");
            ps.setString(1, pergunta.getDescricao());
            ps.setString(2, pergunta.getGabarito());
            ps.setLong(3, pergunta.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL Error: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pergunta getPerguntaId(Long id) {
        Pergunta perguntaBuscada = null;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement("select id, descricao, gabarito from perguntas where id =?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                perguntaBuscada = new Pergunta();
                perguntaBuscada.setId(rs.getLong("id"));
                perguntaBuscada.setDescricao(rs.getString("descricao"));
                perguntaBuscada.setGabarito(rs.getString("gabarito"));
            }
        } catch (SQLException e) {
            System.err.format("SQL Error: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return perguntaBuscada;
    }

    public List<Pergunta> getTodasPerguntas() {
        List<Pergunta> perguntasBuscadas = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement("select id, descricao, gabarito from perguntas");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pergunta perguntaBuscada = new Pergunta();
                perguntaBuscada.setId(rs.getLong("id"));
                perguntaBuscada.setDescricao(rs.getString("descricao"));
                perguntaBuscada.setGabarito(rs.getString("gabarito"));
                perguntasBuscadas.add(perguntaBuscada);
            }
        } catch (SQLException e) {
            System.err.format("SQL Error: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return perguntasBuscadas;
    }

    public void apagaPergunta(Long id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement("delete from perguntas where id = ?;");
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL Error: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
