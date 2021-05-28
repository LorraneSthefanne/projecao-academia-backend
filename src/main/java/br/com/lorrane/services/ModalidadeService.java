package br.com.lorrane.services;

import br.com.lorrane.entities.Modalidade;
import br.com.lorrane.models.ModalidadeFiltro;
import org.springframework.data.domain.Page;

public interface ModalidadeService {

    Page<Modalidade> pesquisar(ModalidadeFiltro filtro, int pagina, int tamanho);
}
