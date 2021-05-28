package br.com.lorrane.mapper;

import br.com.lorrane.controllers.dto.FrequenciaDTO;
import br.com.lorrane.controllers.dto.PaginaDTO;
import br.com.lorrane.entities.Frequencia;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = UsuarioMapper.class)
public interface FrequenciaMapper {

    FrequenciaDTO toDTO(Frequencia frequencia);

    List<FrequenciaDTO> toDTO(List<Frequencia> frequencias);

    default PaginaDTO<FrequenciaDTO> fromPage(Page<Frequencia> frequencias) {
        return new PaginaDTO<>(toDTO(frequencias.getContent()), frequencias.getTotalElements(), frequencias.getTotalPages());
    }
}
