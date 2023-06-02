package br.ufmt.ProjetoEcommerce.Fornecedor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorResponse {
  private int id;
  private String nome;
  private String endereco;
  private String cidade;
  private String regiao;

  public static FornecedorResponse from(Fornecedor entidade) {
    FornecedorResponse response = new FornecedorResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setEndereco(entidade.getEndereco());
    response.setCidade(entidade.getCidade());
    response.setRegiao(entidade.getRegiao());
    return response;
  }
}