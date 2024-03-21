package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        JogadorGerador jogadorGerador = new JogadorGerador();
        Jogador jogador = jogadorGerador.geraJogador();
        Jogador jogador1 = jogadorGerador.geraJogador();
        Jogador jogador2 = jogadorGerador.geraJogador();
        Jogador jogador3 = jogadorGerador.geraJogador();


        System.out.println(jogador.getDescricao());
        System.out.println("------");
        System.out.println(jogador1.getDescricao());
        System.out.println("------");
        System.out.println(jogador2.getDescricao());
        System.out.println("------");
        System.out.println(jogador3.getDescricao());

    }
}