package secao16.teste;

import secao16.infra.DAO;
import secao16.muitospramuitos.Ator;
import secao16.muitospramuitos.Filme;

import java.util.List;

public class ObterFilmes {

    public static void main(String[] args) {

        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.consultar(
                "obterFilmesComNotaMaiorQue", "nota", 8.5);

        for(Filme filme: filmes) {
            System.out.println(filme.getNome()
                    + " => " + filme.getNota());

            for(Ator ator: filme.getAtores()) {
                System.out.println(ator.getNome());
            }
        }
    }
}
