package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;


public class JogadorGerador {

    public String[] nome;
    public String[] sobrenome;
    public String[] posicao;
    public String[] clube;
    public int Idade;


    JogadorGerador() throws Exception {
        nome = getRequisicao("https://venson.net.br/resources/data/nomes.txt");
        sobrenome = getRequisicao("https://venson.net.br/resources/data/sobrenomes.txt");
        posicao = getRequisicao("https://venson.net.br/resources/data/posicoes.txt");
        clube = getRequisicao("https://venson.net.br/resources/data/clubes.txt");
        System.out.println("passou aqui ");
    }

    private String[] getRequisicao(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String[] lists = response.body().replaceAll("\"", "").replace(",", "").toLowerCase().split("\n");
        return lists;
    }

    private String Aleatorio(String[] dados) throws Exception{
        int min = 0;
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt((dados.length - min) + 1) + min;
        return dados[valor];
    }
    private int Idade() throws Exception {
        int max = 40 ;
        int min = 17;
        Random aleatorio = new Random();
        return aleatorio.nextInt((max - min) + 1) + min;}

    public  Jogador geraJogador() throws Exception {
        Jogador jogador = new Jogador();
        jogador.setNome(Aleatorio(nome));
        jogador.setSobrenome(Aleatorio(sobrenome));
        jogador.setIdade(Idade());
        jogador.setPosicao(Aleatorio(posicao));
        jogador.setClube(Aleatorio(clube));
        return jogador;
    }

}
