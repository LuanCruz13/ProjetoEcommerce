package br.ufmt.ProjetoEcommerce.Produto;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufmt.ProjetoEcommerce.categoria.CategoriaRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {
    
    private String nome;
    private float preco;
    private float peso;
    private Integer idCategoria;
    private Integer idFornecedor;

    public static void update(Produto produto, ProdutoRequest request) {
    }
}