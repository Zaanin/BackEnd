package org.example;

public class Jogador {

    private String nome;
    private String sobrenome;
    private String posicao;
    private String clube;
    private int idade;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public void setClube(String clube) {
        this.clube = clube;
    }

    String getDescricao() {
        return nome + " " + sobrenome + " é um futebolista brasileiro de "+idade+" anos que atua como " + posicao + ". Atualmente defende o " + clube + ".";}

}
