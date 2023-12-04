package com.guerra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guerra.domain.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
