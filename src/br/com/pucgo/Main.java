package br.com.pucgo;

import br.com.pucgo.controle.PerguntaControle;
import br.com.pucgo.controle.UsuarioControle;
import br.com.pucgo.modelo.Pergunta;
import br.com.pucgo.modelo.Usuario;
import br.com.pucgo.repositorio.PerguntaRepositorio;
import br.com.pucgo.repositorio.UsuarioRepositorio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Seja bem vindo ao sistema de armazenamento de perguntas e respostas");

        System.out.println("Informe o seu nome para continuar");
        String nome = scan.nextLine();

        System.out.println("Informe o seu CPF (apenas números) para continuar");
        String cpf = scan.nextLine();

        UsuarioControle usuarioControle = new UsuarioControle(new UsuarioRepositorio());
        Usuario usuarioInfomado = usuarioControle.getUsuarioPorCpf(cpf);

        if (usuarioInfomado != null && usuarioInfomado.getCpf() != null) {
            System.out.println("Seja bem vindo " + usuarioInfomado.getNome());
        } else {
            usuarioControle.criaUsuario(new Usuario(cpf, nome));
        }

        PerguntaControle perguntaControle = new PerguntaControle(new PerguntaRepositorio());

        int opcao = imprimeMenu();

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    cadastraPergunta(scan, perguntaControle);
                    opcao = imprimeMenu();
                    break;
                case 2:
                    listarPerguntas(perguntaControle);
                    opcao = imprimeMenu();
                    break;
                case 3:
                    deletarPergunta(scan, perguntaControle);
                    opcao = imprimeMenu();
                    break;
                default:
                    System.out.println("Opção informada inválida.");
                    opcao = 0;
                    break;
            }
        }

        System.out.println("Obrigado por visitar o sistema, volte sempre!");
    }

    private static void deletarPergunta(Scanner scan, PerguntaControle perguntaControle) {
        Boolean existePerguntaCadastrada = perguntaControle.listaPerguntas();

        if (existePerguntaCadastrada) {
            System.out.println("Infome o ID da pergunta pergunta a ser apagada: ");
            Long id = scan.nextLong();

            perguntaControle.deletaPergunta(id);
        }
    }

    private static void listarPerguntas(PerguntaControle perguntaControle) {
        perguntaControle.listaPerguntas();
    }

    private static void cadastraPergunta(Scanner scan, PerguntaControle perguntaControle) {
        System.out.println("Insira uma descrição para a pergunta: ");
        String descricao = scan.nextLine();

        System.out.println("Insira um gabarito para a pergunta acima: ");
        String gabarito = scan.nextLine();

        perguntaControle.criaPergunta(new Pergunta(descricao, gabarito));
    }

    public static int imprimeMenu() {
        System.out.println("------------MENU-----------");
        System.out.println("Informe a opção desejada: ");
        System.out.println("1 - Criar pergunta");
        System.out.println("2 - Listar perguntas");
        System.out.println("3 - Deletar pergunta");
        System.out.println("0 - SAIR");
        System.out.println("---------------------------");

        Scanner scan = new Scanner(System.in);;

        return scan.nextInt();
    }

}
