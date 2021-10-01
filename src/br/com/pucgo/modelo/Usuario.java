package br.com.pucgo.modelo;

//POJO - Plain Old Java Object - N�o tem regras nessa classe, apenas classe de modelagem.
public class Usuario {

    private String cpf;
    private String nome;

    public Usuario() {
    }

    public Usuario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                '}';
    }
}
