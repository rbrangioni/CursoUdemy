package com.raphael.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.cursoudemy.domain.Categoria;
import com.raphael.cursoudemy.repositories.CategoriaRepository;


@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null); 
		
		
	}

}
