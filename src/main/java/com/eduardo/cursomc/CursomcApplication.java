package com.eduardo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduardo.cursomc.domain.Categoria;
import com.eduardo.cursomc.domain.Cidade;
import com.eduardo.cursomc.domain.Cliente;
import com.eduardo.cursomc.domain.Endereco;
import com.eduardo.cursomc.domain.Estado;
import com.eduardo.cursomc.domain.Produto;
import com.eduardo.cursomc.domain.enums.TipoCliente;
import com.eduardo.cursomc.repositories.CategoriaRepository;
import com.eduardo.cursomc.repositories.CidadeRepository;
import com.eduardo.cursomc.repositories.ClienteRepository;
import com.eduardo.cursomc.repositories.EnderecoRepository;
import com.eduardo.cursomc.repositories.EstadoRepository;
import com.eduardo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));


		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2); 
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c1, c2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Eduardo Barros", "eduardbarross@gmail.com", "123.456.789.00", TipoCliente.PESSOAFISICA );
		
		cli1.getTelefones().addAll(Arrays.asList("62 99143-3211", "62 3248-3274"));
		
		Endereco e1 = new Endereco(null, "Titanita", "12", "quadra 40 lote 12", "Pontal Sul I", "74.955-470", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua 82", "400", "Praça Civica" ,"Centro", "74.000-000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
