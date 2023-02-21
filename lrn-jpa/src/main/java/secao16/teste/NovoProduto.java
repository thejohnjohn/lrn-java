package secao16.teste;

import secao16.Produto;
import secao16.infra.DAO;

public class NovoProduto {
    public static void main(String[] args) {
        Produto produto = new Produto("IPad", 876.98);

        DAO< Produto> dao = new DAO<>(Produto.class);
        dao.incluirAtomico(produto);
    }
}
