package secao16.teste.umpramuitos;

import secao16.Produto;
import secao16.infra.DAO;
import secao16.umpramuitos.ItemPedido;
import secao16.umpramuitos.Pedido;

public class NovoPedido {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        Pedido pedido = new Pedido();
        Produto produto = new Produto("Geladeira", 6789.98);
        ItemPedido itemPedido = new ItemPedido(pedido, produto, 10);

        dao.abrirT().incluir(produto).incluir(pedido). incluir(itemPedido).fecharT();
    }
}
