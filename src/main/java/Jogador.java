import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Jogador {
    private String nome;
    private String sobrenome;
    private String posicao;
    private int idade;
    private String clube;

    // Construtor
    public Jogador(String nome, String sobrenome, String posicao, int idade, String clube) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.idade = idade;
        this.clube = clube;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getIdade() {
        return idade;
    }

    public String getClube() {
        return clube;
    }

    // Método para gerar a descrição
    public String getDescricao() {
        return String.format("O jogador %s %s, atua como %s no clube %s e tem %d anos.",
                nome, sobrenome, posicao, clube, idade);
    }
}

public class JogadorGerador {
    private static final String API_URL = "URL_DA_SUA_API_AQUI";

    public static Jogador criarJogador() throws Exception {
        // Realiza a requisição HTTP apenas uma vez
        String jsonResponse = fazerRequisicaoHttp(API_URL);

        // Parse do JSON
        JSONObject jogadorJson = new JSONObject(jsonResponse);

        // Constrói o objeto Jogador com os dados do JSON
        return new Jogador(jogadorJson.getString("nome"),
                jogadorJson.getString("sobrenome"),
                jogadorJson.getString("posicao"),
                jogadorJson.getInt("idade"),
                jogadorJson.getString("clube"));
    }

    private static String fazerRequisicaoHttp(String url) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String lista = response.body();
        return "";  // Substitua por sua implementação real
    }

    private static String[] Requisicao(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String lista = response.body();

        return lista.split("\n");
    }

    public static void main(String[] args) {
        // Exemplo de uso
        Jogador jogador = JogadorGerador.criarJogador();
        System.out.println(jogador.getDescricao());
    }
}
