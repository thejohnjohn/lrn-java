package secao16.teste.umpramuitos;

import secao16.infra.DAO;
import secao16.umpramuitos.Pedido;

public class ObterPedido {
    public static void main(String[] args) {
        DAO<Pedido> dao = new DAO<>(Pedido.class);

        Pedido pedido = dao.obterporID(1L);
    }
}
