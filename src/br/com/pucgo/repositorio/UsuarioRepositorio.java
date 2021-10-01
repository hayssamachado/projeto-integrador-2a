package br.com.pucgo.repositorio;

import br.com.pucgo.modelo.Usuario;

import java.sql.*;

public class UsuarioRepositorio {

    private final String url = "jdbc:postgresql://localhost:5432/projeto-integrador-2a";
    private final String user = "postgres";
    private final String password = "postgres";

    public void criaUsuario(Usuario usuario) {
        try {
            // 1 - Abre conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, user, password);

            // 2 - Crio um statement de criação do usuario
            PreparedStatement ps = connection.prepareStatement("INSERT INTO usuarios (cpf, nome) VALUES (?, ?);");
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getNome());

            // 3 - Executo a query de criacao.
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizaUsuario(Usuario usuario) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = connection.prepareStatement("update usuarios set nome = ? where cpf = ?;");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioPorCpf(String cpfUsuario) {
        Usuario usuarioBuscado = new Usuario();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement("select cpf, nome from usuarios where cpf =?");
            ps.setString(1, cpfUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuarioBuscado.setCpf(rs.getString("cpf"));
                usuarioBuscado.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioBuscado;
    }

    public void apagaUsuario(String cpfUsuario) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = connection.prepareStatement("delete from usuarios where cpf = ?;");
            ps.setString(1, cpfUsuario);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
