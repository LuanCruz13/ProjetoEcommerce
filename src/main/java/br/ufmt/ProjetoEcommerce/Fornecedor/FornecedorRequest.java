package br.ufmt.ProjetoEcommerce.Fornecedor;

public class FornecedorRequest {
    
    private String nome;
    private String endereco;
    private String cidade;
    private String regiao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getRegiao() {
        return regiao;
    }

    public static Fornecedor transcribe(FornecedorRequest request) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(request.getNome());
        fornecedor.setEndereco(request.getEndereco());
        fornecedor.setCidade(request.getCidade());
        fornecedor.setRegiao(request.getRegiao());
        return fornecedor;
    }
}