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
    private final List<Produto> produtos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){

        produtos.add(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtos;
    }

    @DeleteMapping("/{produto}")
    public ResponseEntity<?> removerProduto(@PathVariable String produto){
        boolean removido = produtos.removeIf(p -> p.getNome().equalsIgnoreCase(produto));

        if (!removido){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", "Produto não encontrado."));
        }

        return ResponseEntity.ok(Map.of("mensagem", "Produto removido com sucesso."));
    }

    @PutMapping("/{produto}/comprado")
    public ResponseEntity<?> marcarComprado(@PathVariable String produto){

        for (Produto p : produtos){
            if (p.getNome().equalsIgnoreCase(produto)){
                p.setComprado(true);
                return ResponseEntity.ok(Map.of("mensagem", "Produto marcado como comprado."));
            }
        }

        return ResponseEntity.ok(Map.of("mensagem", "Produto não encontrado."));
    }
    @GetMapping("/total")
    public ResponseEntity<?> quantidadeProdutos(){

        return ResponseEntity.ok(Map.of("total", produtos.size()));
    }
}
