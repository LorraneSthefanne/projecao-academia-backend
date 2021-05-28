package br.com.lorrane.services.impl;

import br.com.lorrane.entities.Modalidade;
import br.com.lorrane.entities.QModalidade;
import br.com.lorrane.expression.BooleanExpressionBuilder;
import br.com.lorrane.models.ModalidadeFiltro;
import br.com.lorrane.repositories.ModalidadeRepository;
import br.com.lorrane.services.ModalidadeService;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModalidadeServiceImpl implements ModalidadeService {

    private final ModalidadeRepository modalidadeRepository;

    @Override
    public Page<Modalidade> pesquisar(ModalidadeFiltro filtro, int pagina, int tamanho) {
        QModalidade modalidade = QModalidade.modalidade;
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        BooleanExpression expression = new BooleanExpressionBuilder(modalidade.isNotNull())
                .notNullAnd(modalidade.nome::containsIgnoreCase, filtro.getNome())
                .build();
        return modalidadeRepository.findAll(expression, pageRequest);
    }
}
