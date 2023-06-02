package br.ufmt.ProjetoEcommerce.categoria;

public class CategoriaRequest {
    
    private String nome;

    public void setNome(String nome){
      this.nome = nome;
    }
  
    public String getNome(){
      return nome;

    }

    public static Categoria transcribe(CategoriaRequest request) {
        return null;
    }
}
