package br.ufmt.ProjetoEcommerce.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {
    private int id;
    private String nome;
    private float preco;
    private float peso;

    public static ProdutoResponse from(Produto entidade) {
        ProdutoResponse response = new ProdutoResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        response.setPreco(entidade.getPreco());
        response.setPeso(entidade.getPeso());
        return response;
    }
}