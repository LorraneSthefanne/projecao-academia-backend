package br.com.lorrane.services.impl;

import br.com.lorrane.entities.Frequencia;
import br.com.lorrane.entities.Pessoa;
import br.com.lorrane.entities.QFrequencia;
import br.com.lorrane.exceptions.Mensagem;
import br.com.lorrane.expression.BooleanExpressionBuilder;
import br.com.lorrane.models.ConfirmarFrequencia;
import br.com.lorrane.models.FrequenciaFiltro;
import br.com.lorrane.repositories.FrequenciaRepository;
import br.com.lorrane.services.FrequenciaService;
import br.com.lorrane.services.PessoaService;
import br.com.lorrane.validation.Assert;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FrequenciaServiceImpl implements FrequenciaService {

    private final PessoaService pessoaService;
    private final FrequenciaRepository frequenciaRepository;

    @Override
    @Transactional
    public void confirmar(ConfirmarFrequencia confirmarFrequencia) {
        Pessoa pessoa = pessoaService.buscar(confirmarFrequencia.getId());
        Boolean existe = frequenciaRepository.existsByPessoaAndDataPresenca(pessoa, confirmarFrequencia.getData());
        Assert.isFalse(existe, Mensagem.FREQUENCIA_JA_CONFIRMADA);
        Frequencia frequencia = Frequencia.builder()
                .pessoa(pessoa)
                .dataPresenca(confirmarFrequencia.getData())
                .build();
        frequenciaRepository.save(frequencia);
    }

    @Override
    public Page<Frequencia> buscar(FrequenciaFiltro filtro, int pagina, int tamanho) {
        QFrequencia frequencia = QFrequencia.frequencia;
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        BooleanExpression expression = new BooleanExpressionBuilder(frequencia.isNotNull())
                .notNullAnd(frequencia.pessoa.id::eq, filtro.getIdPessoa())
                .build();
        return frequenciaRepository.findAll(expression, pageRequest);
    }
}
