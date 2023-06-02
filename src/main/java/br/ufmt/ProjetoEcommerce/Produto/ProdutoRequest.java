package br.ufmt.ProjetoEcommerce.Produto;

public class ProdutoRequest {
    
    private String nome;
    private float preco;
    private float peso;

    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public String getNome() {
        return nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
  
    public float getPreco() {
        return preco;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
  
    public float getPeso() {
        return peso;
    }

    public static Produto transcribe(ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setPeso(request.getPeso());
        return produto;
    }

    public static void update(Produto produto, ProdutoRequest request) {
    }
}