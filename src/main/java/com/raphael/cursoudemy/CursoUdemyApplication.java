package com.raphael.cursoudemy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raphael.cursoudemy.domain.Categoria;
import com.raphael.cursoudemy.domain.Produto;
import com.raphael.cursoudemy.repositories.CategoriaRepository;
import com.raphael.cursoudemy.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUdemyApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRespository;
	
	@Autowired
	ProdutoRepository produtorepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escitório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));		
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		 categoriaRespository.saveAll(Arrays.asList(cat1, cat2));
		 produtorepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
	}

}
