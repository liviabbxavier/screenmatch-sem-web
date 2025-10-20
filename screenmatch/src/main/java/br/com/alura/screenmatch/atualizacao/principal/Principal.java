package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private ConsumoApi consumo = new ConsumoApi();

    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=522d9a5";

    public void exibeMenu() {
        System.out.println("Digite o nome de uma serie para busca:");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" +  i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

        for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        temporadas.forEach(t -> System.out.println());

//        List<String> nomes = Arrays.asList("Armando", "Leonardo", "Samuel", "Samantha", "Beatriz");
//        //fluxo de dados
//        nomes.stream()
//                .sorted()
//                //ordena alfabeticamente
//                .limit(3)
//                //limita a lista no tamanho determinado no parametro
//                .filter(n -> n.startsWith("S"))
//                //CUIDADO COM AS INICIAIS CASO A LISTA ESTEJA COM UM TAMANHO LIMITADO, COLOCANDO "S" EM UMA LISTA DE 3 ITENS, NAO IMPRIME O ITEM COM A INICIAL "S"
//                //pega apenas os itens que comecam com a letra escolhida
//                .map(n -> n.toUpperCase())
//                //coloca a escrita com letra maiuscula
//                .forEach(System.out::println);
//                //imprime os dados
    }
}