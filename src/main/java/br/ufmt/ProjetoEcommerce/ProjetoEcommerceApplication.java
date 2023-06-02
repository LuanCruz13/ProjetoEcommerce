package br.ufmt.ProjetoEcommerce;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ufmt.ProjetoEcommerce.Fornecedor.Fornecedor;
import br.ufmt.ProjetoEcommerce.Fornecedor.FornecedorRepository;
import br.ufmt.ProjetoEcommerce.Produto.Produto;
import br.ufmt.ProjetoEcommerce.Produto.ProdutoRepository;
import br.ufmt.ProjetoEcommerce.categoria.Categoria;
import br.ufmt.ProjetoEcommerce.categoria.CategoriaRepository;

@SpringBootApplication
public class ProjetoEcommerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEcommerceApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args){
		
		var categoria = new Categoria();
		categoria.setId(1);
		categoria.setNome("Categoria 1");

		var categoria2 = new Categoria();
		categoria2.setId(1);
		categoria2.setNome("Categoria 2");

		var fornecedor = new Fornecedor();
		fornecedor.setId(1);
		fornecedor.setNome("Fornecedor 1");

		var fornecedor2 = new Fornecedor();
		fornecedor2.setId(1);
		fornecedor2.setNome("Fornecedor 2");

		var produto = new Produto();
		produto.setId(1);
		produto.setNome("Produto 1");
		produto.setPeso(3.5F);
		produto.setPreco(10F);
		produto.setCategoria(categoria);

		var produto2 = new Produto();
		produto2.setId(2);
		produto2.setNome("Produto 2");
		produto2.setPeso(3.5F);
		produto2.setPreco(10F);
		produto2.setCategoria(categoria2);

		categoriaRepository.saveAll(Arrays.asList(categoria, categoria2));
		fornecedorRepository.saveAll(Arrays.asList(fornecedor, fornecedor2));
		produtoRepository.saveAll(Arrays.asList(produto, produto2));
		
	}

}
