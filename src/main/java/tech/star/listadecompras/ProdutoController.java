package tech.star.listadecompras;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final GerenciamentoDeLista produtos = new GerenciamentoDeLista();

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){

        produtos.adicionarProduto(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtos.listarProdutos();
    }

    @DeleteMapping("/{produto}")
    public ResponseEntity<?> removerProduto(@PathVariable String produto){
        boolean removido = produtos.removerProduto(produto);

        if (!removido){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", "Produto não encontrado."));
        }

        return ResponseEntity.ok(Map.of("mensagem", "Produto removido com sucesso."));
    }

    @PutMapping("/{produto}/comprado")
    public ResponseEntity<?> marcarComprado(@PathVariable String produto){

        Produto produtoEncontrado = produtos.marcarComprado(produto);

        if (produtoEncontrado == null){
            return ResponseEntity.ok(Map.of("mensagem", "Produto não encontrado."));
        }


        return ResponseEntity.ok(produtoEncontrado);
    }
    @GetMapping("/total")
    public ResponseEntity<?> quantidadeProdutos(){

        return ResponseEntity.ok(Map.of("total", produtos.quantidadeProdutos()));
    }
}
