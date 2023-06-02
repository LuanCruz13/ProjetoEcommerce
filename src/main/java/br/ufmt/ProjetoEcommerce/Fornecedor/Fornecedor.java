package br.ufmt.ProjetoEcommerce.Fornecedor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ufmt.ProjetoEcommerce.Produto.Produto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fornecedor")

@Getter
@Setter

public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String nome;

    @Column(length = 200)
    private String endereco;

    @Column(length = 100)
    private String cidade;

    @Column(length = 100)
    private String regiao;

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> Produtos;


    // equals, hashCode e toString

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Fornecedor other = (Fornecedor) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Fornecedor [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + ", regiao="
                + regiao + "]";
    }
}