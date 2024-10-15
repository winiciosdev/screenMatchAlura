package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner user = new Scanner(System.in);
        System.out.println("Digite o nome do filme que voce deseja pesquisar");
        var busca = user.nextLine();

        String enderecoFilme = "https://www.omdbapi.com/?t=" + busca + "&apikey=a9bd2ae";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoFilme))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
            //try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo convertido");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e){
            System.out.println("Ocoreu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro na busca, verifique se o nome foi colocado corretamente.");
        }

        System.out.println("O programa finalizou corretamente.");
    }
}
