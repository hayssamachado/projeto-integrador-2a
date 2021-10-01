package br.com.pucgo.modelo;

//POJO - Plain Old Java Object - Não tem regras nessa classe, apenas classe de modelagem.
public class Pergunta {

    private Long id;
    private String descricao;
    private String gabarito;

    public Pergunta(){

    }

    public Pergunta(String descricao, String gabarito){
        this.descricao = descricao;
        this.gabarito = gabarito;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long identificador) {
        this.id = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGabarito() {
        return gabarito;
    }

    public void setGabarito(String gabarito) {
        this.gabarito = gabarito;
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", gabarito='" + gabarito + '\'' +
                '}';
    }
}
