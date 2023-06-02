package br.ufmt.ProjetoEcommerce.Produto;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.ufmt.ProjetoEcommerce.Fornecedor.Fornecedor;
import br.ufmt.ProjetoEcommerce.Fornecedor.FornecedorRepository;
import br.ufmt.ProjetoEcommerce.categoria.Categoria;
import br.ufmt.ProjetoEcommerce.categoria.CategoriaRepository;
import lombok.AllArgsConstructor;

/**
 * Classe de serviço para manipulação de produtos.
 */
@AllArgsConstructor
@Service
public class ProdutoService {
    private final CategoriaRepository categoriaRepository;
    private final FornecedorRepository fornecedorRepository;

    /**
     * Converte uma requisição de produto em um objeto Produto.
     *
     * @param request a requisição de produto
     * @return o objeto Produto criado a partir da requisição
     * @throws EntityNotFoundException se a categoria ou fornecedor não forem encontrados
     */
    public Produto transcribe(ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setPeso(request.getPeso());
        produto.setCategoria(buscaCategoria(request.getIdCategoria()));
        produto.setFornecedor(buscaFornecedor(request.getIdFornecedor()));
        return produto;
    }

    /**
     * Busca uma categoria pelo seu ID.
     *
     * @param id o ID da categoria
     * @return a categoria encontrada
     * @throws EntityNotFoundException se a categoria não for encontrada
     */
    private Categoria buscaCategoria(final Integer id){
        return categoriaRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
    }

    /**
     * Busca um fornecedor pelo seu ID.
     *
     * @param id o ID do fornecedor
     * @return o fornecedor encontrado
     * @throws EntityNotFoundException se o fornecedor não for encontrado
     */
    private Fornecedor buscaFornecedor(final Integer id){
        return fornecedorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));
    }
}
