package secao16.teste.muitospramuitos;

import secao16.infra.DAO;
import secao16.muitospramuitos.Sobrinho;
import secao16.muitospramuitos.Tio;

public class NovoTioSobrinho {
    public static void main(String[] args) {
        Tio tia = new Tio("Maria");
        Tio tio = new Tio("João");

        Sobrinho sobrinha = new Sobrinho("Ana");
        Sobrinho sobrinho = new Sobrinho("Davi");

        tia.getSobrinhos().add(sobrinho);
        sobrinho.getTios().add(tia);

        tia.getSobrinhos().add(sobrinha);
        sobrinha.getTios().add(tia);

        tio.getSobrinhos().add(sobrinho);
        sobrinho.getTios().add(tio);

        tio.getSobrinhos().add(sobrinha);
        sobrinha.getTios().add(tio);

        DAO<Object> dao = new DAO<>();

        dao.abrirT()
                .incluir(tia)
                .incluir(tio)
                .incluir(sobrinho)
                .incluir(sobrinha)
                .fecharT()
                .fechar();
    }
}
