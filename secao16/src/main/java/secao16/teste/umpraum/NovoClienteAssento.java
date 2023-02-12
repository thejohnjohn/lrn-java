package secao16.teste.umpraum;

import secao16.infra.DAO;
import secao16.umpraum.Assento;
import secao16.umpraum.Cliente;

public class NovoClienteAssento {
    public static void main(String[] args) {
        Assento assento = new Assento("16C");
        Cliente cliente = new Cliente("Ana", assento);

        DAO<Object> dao = new DAO<>();

        dao.abrirT().incluir(cliente).incluir(assento).fecharT();
    }
}
