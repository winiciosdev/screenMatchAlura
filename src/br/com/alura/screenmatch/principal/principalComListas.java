package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class principalComListas {
    public static void main(String[] args) {
        Filme theBatman = new Filme("The batman", 2022);
        theBatman.avalia(10);
        Filme filmeFav = new Filme("Guardiões da galaxia Vol.3", 2023);
        filmeFav.avalia(8);
        Filme filmeDoLucas = new Filme("Bad boys", 1995);
        filmeDoLucas.avalia(5);
        Serie smallVile = new Serie("Smallvile", 2001);



        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoLucas);
        lista.add(theBatman);
        lista.add(filmeFav);
        lista.add(smallVile);
        for(Titulo item: lista){
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("classificação :" + filme.getClassificacao());
            }


        }
    }
}
