package tech.star.listadecompras;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoDeLista {
    private final List<Produto> produtoslist = new ArrayList<>();

    public List<Produto> listarProdutos() {
        return produtoslist;
    }

    public void adicionarProduto(Produto produto){
        this.produtoslist.add(produto);
    }

    public boolean removerProduto(String nome){
        return produtoslist.removeIf(produto -> produto.getNome().equalsIgnoreCase(nome));

    }

    public Produto marcarComprado(String nome){
        for (Produto produto : produtoslist){
            if (produto.getNome().equalsIgnoreCase(nome)){
                produto.setComprado(true);
                return produto;
            }
        }
        return null;
    }

    public int quantidadeProdutos(){
        return produtoslist.size();
    }
}
