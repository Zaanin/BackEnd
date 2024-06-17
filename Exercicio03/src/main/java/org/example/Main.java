package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        // Criando instâncias de Ator, Filme e OscarService para teste
        Ator ator = new Ator(true, "Brad Pitt");
        Filme filme = new Filme(true, "As longas tranças de um careca");
        OscarService oscarService = new OscarService();

        // Adicionando indicações
        oscarService.adicionarIndicacao(ator, "Melhor Ator Coadjuvante");
        oscarService.adicionarIndicacao(filme, "Melhor Filme");

        // Listando os indicados
        oscarService.listarIndicados().forEach(indicacao ->
                System.out.println("Indicado: " + indicacao.getIndicavel().getNome() +
                        ", Categoria: " + indicacao.getCategoria()));
    }
}
