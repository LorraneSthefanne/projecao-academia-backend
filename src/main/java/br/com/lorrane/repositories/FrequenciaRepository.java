package br.com.lorrane.repositories;

import br.com.lorrane.entities.Frequencia;
import br.com.lorrane.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, UUID>, QuerydslPredicateExecutor<Frequencia> {

    Boolean existsByPessoaAndDataPresenca(Pessoa pessoa, LocalDate data);
}
