package com.guerra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guerra.domain.Turma;
import com.guerra.repositories.TurmaRepository;
import com.guerra.services.exceptions.ObjectNotFoundException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;

	public List<Turma> buscar() {
		List<Turma> obj = repo.findAll();
		return obj;
	}

	public Turma buscarPorId(Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Turma não encontrada!"));
	}

	public Turma adicionar(Turma obj) {
		return repo.save(obj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);

	}
}
