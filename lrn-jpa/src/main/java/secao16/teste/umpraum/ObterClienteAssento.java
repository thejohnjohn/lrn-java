package secao16.teste.umpraum;

import secao16.infra.DAO;
import secao16.umpraum.Cliente;

public class ObterClienteAssento {
    public static void main(String[] args) {
        DAO< Cliente> dao = new DAO<>(Cliente.class);

        Cliente cliente = dao.abrirT().obterporID(4D);
        dao.fecharT();
    }
}
