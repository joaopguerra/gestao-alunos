package com.guerra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guerra.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
