package br.com.pucgo.controle;

import br.com.pucgo.modelo.Usuario;
import br.com.pucgo.repositorio.UsuarioRepositorio;

public class UsuarioControle {

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioControle(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public void criaUsuario(Usuario usuario) {
        if (usuario.getNome() == null) {
            System.out.println("Nome informado inválido");
        }

        if (usuario.getCpf() == null) {
            System.out.println("CPF informado inválido");
        }

        usuarioRepositorio.criaUsuario(usuario);
        System.out.println("Usuário criado com sucesso.");
    }

    public Usuario getUsuarioPorCpf(String cpfUsuario) {
        Usuario usuarioPorCpf = usuarioRepositorio.getUsuarioPorCpf(cpfUsuario);

        if (usuarioPorCpf == null) {
            System.out.println("Usuário informado não registrado na base de dados.");
        }

        return usuarioPorCpf;
    }
}
