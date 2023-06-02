package br.ufmt.ProjetoEcommerce.categoria;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

//import br.ufmt.mibanca.tipoata.TipoAta;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/categoria")
@RequiredArgsConstructor //cria um metodo construtor com o conteudo da linha 13 obrigatorio
public class CategoriaController {

    private final CategoriaRepository repository;

    @GetMapping(path = "/")
    //o endpoint vai retornar tudo que esta no banco (a 1° endpoint)
    public List<Categoria> index() {
        return repository.findAll();
    }

    // Get ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriaResponse> getById(@PathVariable int id) {
        Optional<Categoria> found = repository.findById(id);

        if (found.isPresent()) {
            CategoriaResponse response = CategoriaResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "pk") int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    //endpoint transcrição (entrada e saida de informação) 
    public ResponseEntity cadastrar(@RequestBody CategoriaRequest request) {
        Categoria categoria = new Categoria(); // Renomeado "Categoria" para "categoria"
        categoria.setNome(request.getNome());

        try {
            repository.save(categoria);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody CategoriaRequest request) {
        Optional<Categoria> categoriaOptional = repository.findById(id);
        if (categoriaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Categoria categoria = categoriaOptional.get();
        categoria.setNome(request.getNome());

        try {
            repository.save(categoria);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
    ///teste
}