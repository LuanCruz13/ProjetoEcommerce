package br.ufmt.ProjetoEcommerce.Produto;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepository repository;
    private final ProdutoService produtoService;

    

    @GetMapping("/")
    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable int id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<String> createProduto(@RequestBody ProdutoRequest request) {
        try {
            Produto produto = produtoService.transcribe(request);
            repository.save(produto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduto(@PathVariable int id, @RequestBody ProdutoRequest request) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            ProdutoRequest.update(produto, request);
            repository.save(produto);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}