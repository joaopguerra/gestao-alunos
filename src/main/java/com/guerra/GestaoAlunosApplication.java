package com.guerra;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guerra.domain.Aluno;
import com.guerra.repositories.AlunoRepository;

@SpringBootApplication
public class GestaoAlunosApplication implements CommandLineRunner {
	
	@Autowired
	private AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestaoAlunosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno a1 = new Aluno(1, "Aluno 1");
		Aluno a2 = new Aluno(2, "Aluno 2");
		Aluno a3 = new Aluno(3, "Aluno 3");
		Aluno a4 = new Aluno(4, "Aluno 4");
		
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4));
		
	}

}
