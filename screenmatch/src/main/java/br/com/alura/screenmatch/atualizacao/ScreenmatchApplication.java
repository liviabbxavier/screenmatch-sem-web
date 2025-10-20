package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner { //interface de linha de comando

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception { //método main
        Principal principal = new Principal();
        principal.exibeMenu();
//        var consumoApi = new ConsumoApi();
//        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=supernatural&apikey=522d9a5");
//        System.out.println(json);
//
//        json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//        System.out.println(json);
//
//        ConverteDados conversor = new ConverteDados();
//        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
//        System.out.println(dados);
//
//        json = consumoApi.obterDados("https://www.omdbapi.com/?t=supernatural&season=1&episode=1&apikey=522d9a5");
//        DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
//        System.out.println(dadosEpisodio);
    }
}