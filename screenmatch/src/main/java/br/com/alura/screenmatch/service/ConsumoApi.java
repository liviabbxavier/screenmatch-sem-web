package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient(); //cliente
        HttpRequest request = HttpRequest.newBuilder() //requisição
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client //resposta, devolve a requisição
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } //tratamento das exceções

        String json = response.body(); //corpo da resposta
        return json;
    }
}
