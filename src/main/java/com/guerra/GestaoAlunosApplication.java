package com.guerra;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guerra.domain.Aluno;
import com.guerra.domain.Escola;
import com.guerra.domain.Turma;
import com.guerra.repositories.AlunoRepository;
import com.guerra.repositories.EscolaRepository;
import com.guerra.repositories.TurmaRepository;

@SpringBootApplication
public class GestaoAlunosApplication implements CommandLineRunner {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;	

	public static void main(String[] args) {
		SpringApplication.run(GestaoAlunosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Escola e1 = new Escola(1, "Escola de Ensino Fundamental 1");
		Escola e2 = new Escola(2, "Escola Municipal 2");
		
		escolaRepository.saveAll(Arrays.asList(e1, e2));

		Turma t1 = new Turma(1, "8", "A", e1);
		Turma t2 = new Turma(2, "8", "B", e2);
		Turma t3 = new Turma(3, "8", "C", e2);
		
		turmaRepository.saveAll(Arrays.asList(t1, t2, t3));
		
		Aluno a1 = new Aluno(1, "Aluno 1", 8.0, 7.5, t2);
		Aluno a2 = new Aluno(2, "Aluno 2", 6.5, 5.0, t1);
		Aluno a3 = new Aluno(3, "Aluno 3", 5.5, 9.0, t1);
		Aluno a4 = new Aluno(4, "Aluno 4", 7.8, 5.5, t3);
		
		alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4));		
		
	}

}
