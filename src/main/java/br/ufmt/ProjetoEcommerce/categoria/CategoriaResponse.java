package br.ufmt.ProjetoEcommerce.categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {
  private int id;
  private String nome;

  public static CategoriaResponse from(Categoria entidade){
    CategoriaResponse response = new CategoriaResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    return response;
  }
}
