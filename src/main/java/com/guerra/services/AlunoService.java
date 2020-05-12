package com.guerra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guerra.domain.Aluno;
import com.guerra.repositories.AlunoRepository;
import com.guerra.services.exceptions.ObjectNotFoundException;


@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public List<Aluno> buscar() {
		List<Aluno> obj = repo.findAll();
		return obj;
	}
	
	public Aluno buscarPorId(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Aluno não encontrado! Id: " + id ));
	}
	
	public Aluno adicionar(Aluno obj) {
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
}
