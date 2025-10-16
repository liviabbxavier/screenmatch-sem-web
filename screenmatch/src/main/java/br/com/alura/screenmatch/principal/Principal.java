package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=522d9a5";
    private ConsumoApi consumo = new ConsumoApi();

    Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        System.out.println("Digite o nome de uma serie para busca:");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        //"https://www.omdbapi.com/?t=supernatural&apikey=522d9a5"
    }
}
