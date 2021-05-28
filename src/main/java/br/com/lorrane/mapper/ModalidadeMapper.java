package br.com.lorrane.mapper;

import br.com.lorrane.controllers.dto.ModalidadeDTO;
import br.com.lorrane.controllers.dto.PaginaDTO;
import br.com.lorrane.entities.Modalidade;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModalidadeMapper {

    Modalidade fromDTO(ModalidadeDTO modalidadeDTO);

    ModalidadeDTO toDTO(ModalidadeDTO modalidadeDTO);

    List<ModalidadeDTO> toDTO(List<Modalidade> modalidades);

    default PaginaDTO<ModalidadeDTO> toDTO(Page<Modalidade> modalidades) {
        return new PaginaDTO<>(toDTO(modalidades.getContent()), modalidades.getTotalElements(), modalidades.getTotalPages());
    }
}
