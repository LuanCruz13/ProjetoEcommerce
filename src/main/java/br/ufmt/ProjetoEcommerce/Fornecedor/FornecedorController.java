package br.ufmt.ProjetoEcommerce.Fornecedor;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fornecedor")
public class FornecedorController {

    private final FornecedorRepository repository;

    public FornecedorController(FornecedorRepository repository) {
        this.repository = repository;
    }

    //GET LISTA
    @GetMapping(path = "/")
    public List<Fornecedor> index() {
        return repository.findAll();
    }

    //GET BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable int id) {
        Optional<Fornecedor> found = repository.findById(id);

        if (found.isPresent()) {
            return ResponseEntity.ok().body(found.get());
        }

        return ResponseEntity.notFound().build();
    }

    //POST 
    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Fornecedor fornecedor) {
        try {
            repository.save(fornecedor);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }
    }

    //PUT
    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorOptional = repository.findById(id);
        if (fornecedorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        fornecedor.setId(id);

        try {
            repository.save(fornecedor);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }
}