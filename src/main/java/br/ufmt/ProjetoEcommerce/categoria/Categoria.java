package br.ufmt.ProjetoEcommerce.categoria;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.ufmt.ProjetoEcommerce.Produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "seqCategoria", sequenceName = "seq_categoria_id", allocationSize = 1)

@Getter
@Setter
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(generator = "seqCategoria", strategy = GenerationType.SEQUENCE)

    private int id;
    private String nome;

    @Column(name = "nome", length = 200)

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Produto> Produtos;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    //verifica se sao iguals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return ("nome=" + nome + "]");
        //return "categoria []";
    }


}
