package br.com.lorrane.services;

import br.com.lorrane.entities.Frequencia;
import br.com.lorrane.models.ConfirmarFrequencia;
import br.com.lorrane.models.FrequenciaFiltro;
import org.springframework.data.domain.Page;

public interface FrequenciaService {

    void confirmar(ConfirmarFrequencia confirmarFrequencia);

    Page<Frequencia> buscar(FrequenciaFiltro filtro, int pagina, int tamanho);
}
