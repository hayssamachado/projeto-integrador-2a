package br.com.pucgo.controle;

import br.com.pucgo.modelo.Pergunta;
import br.com.pucgo.repositorio.PerguntaRepositorio;

import java.util.List;

public class PerguntaControle {

    private PerguntaRepositorio perguntaRepositorio;

    public PerguntaControle(PerguntaRepositorio perguntaRepositorio) {
        this.perguntaRepositorio = perguntaRepositorio;
    }

    public void criaPergunta(Pergunta pergunta) {
        boolean camposValidos = true;
        if (pergunta.getDescricao() == null) {
            System.out.println("Descrição informada inválida");
            camposValidos = false;
        }

        if (pergunta.getGabarito() == null) {
            System.out.println("Gabarito informado inválido");
            camposValidos = false;
        }

        if (camposValidos) {
            perguntaRepositorio.criaPergunta(pergunta);
            System.out.println("Pergunta criada com sucesso.");
        }
    }

    public Boolean listaPerguntas() {
        List<Pergunta> perguntasCadastradas = perguntaRepositorio.getTodasPerguntas();

        if (perguntasCadastradas.isEmpty()) {
            System.out.println("Não existem perguntas cadastradas");

            return false;
        }

        perguntasCadastradas.forEach(System.out::println);
        return true;
    }

    public void deletaPergunta(Long id) {
        if (id != null) {
            Pergunta perguntaBuscada = perguntaRepositorio.getPerguntaId(id);

            if (perguntaBuscada != null) {
                perguntaRepositorio.apagaPergunta(id);
            } else {
                System.out.println("Pergunta informada não existe na base, por favor confira se informou o id correto.");
            }
        }
    }
}
