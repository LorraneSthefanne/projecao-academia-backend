package br.com.lorrane.repositories;

import br.com.lorrane.entities.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, UUID>, QuerydslPredicateExecutor<Modalidade> {
}
