package secao16.teste;

import secao16.muitospramuitos.NotaFilme;
import secao16.infra.DAO;

public class ObterMediaFilmes {

    public static void main(String[] args) {

        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");

        System.out.println(nota.getMedia());

        dao.fechar();
    }
}