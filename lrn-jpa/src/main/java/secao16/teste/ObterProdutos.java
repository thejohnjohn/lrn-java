package secao16.teste;

import java.util.List;

import secao16.Produto;
import secao16.infra.ProdutoDAO;

public class ObterProdutos {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        List<Produto> produtos = produtoDAO.obterTodos();

        for (Produto produto: produtos) {
            System.out.println("ID: "+produto.getNome()+" Nome: "+produto.getPreco());
        }

        double precoTotal = produtos.stream().map(p -> p.getPreco()).reduce(0.0, (t, p) -> {return t + p;}).doubleValue();

        System.out.format("Valor total R$: %.2f\n", precoTotal);
    }
}
