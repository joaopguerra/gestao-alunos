package com.guerra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guerra.domain.Aluno;
import com.guerra.repositories.AlunoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public List<Aluno> buscar() {
		List<Aluno> obj = repo.findAll();
		return obj;
	}
	
	public Aluno buscarPorId(Long id) throws ObjectNotFoundException {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Aluno não encontrado! Id: " + id + "Tipo: " + Aluno.class.getName()));
	}

}
