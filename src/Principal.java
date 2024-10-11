import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme theBatman = new Filme("The batman", 2022);
        theBatman.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + theBatman.getDuracaoEmMinutos());

        theBatman.exibeFichaTecnica();
        theBatman.avalia(8);
        theBatman.avalia(5);
        theBatman.avalia(10);
        System.out.println("Total de avaliações: " + theBatman.getTotalDeAvaliacoes());
        System.out.println(theBatman.pegaMedia());


        Serie smallVile = new Serie("Smallvile", 2001);
        smallVile.exibeFichaTecnica();
        smallVile.setTemporadas(10);
        smallVile.setEpisodiosPorTemporada(10);
        smallVile.setMinutosPorEpisodio(50);
        System.out.println("Tempo estimado para maratonar Smallvile: " + smallVile.getDuracaoEmMinutos());

        Filme filmeFav = new Filme("Guardiões da galaxia Vol.3", 2023);
        filmeFav.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(theBatman);
        calculadora.inclui(filmeFav);
        calculadora.inclui(smallVile);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(theBatman);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(smallVile);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(theBatman);
        listaDeFilmes.add(filmeFav);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());


    }
}