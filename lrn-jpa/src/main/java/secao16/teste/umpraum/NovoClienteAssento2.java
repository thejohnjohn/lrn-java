package secao16.teste.umpraum;

import secao16.infra.DAO;
import secao16.umpraum.Assento;
import secao16.umpraum.Cliente;
public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Rodrigo", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);

        dao.incluirAtomico(cliente);
    }

}
