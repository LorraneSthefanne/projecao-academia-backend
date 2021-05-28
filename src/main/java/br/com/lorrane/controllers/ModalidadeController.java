package br.com.lorrane.controllers;

import br.com.lorrane.controllers.dto.ModalidadeDTO;
import br.com.lorrane.controllers.dto.PaginaDTO;
import br.com.lorrane.mapper.ModalidadeMapper;
import br.com.lorrane.models.ModalidadeFiltro;
import br.com.lorrane.services.ModalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ModalidadeController.PATH)
public class ModalidadeController {

    public static final String PATH = "/modalidades";

    private final ModalidadeService modalidaService;
    private final ModalidadeMapper modalidadeMapper;

    @GetMapping
    public ResponseEntity<PaginaDTO<ModalidadeDTO>> pesquisar(ModalidadeFiltro filtro,
                                                              @RequestParam(value = "pagina", defaultValue = "0") int pagina,
                                                              @RequestParam(value = "tamanho", defaultValue = "10") int tamanho) {
        return Optional.of(filtro)
                .map(f -> modalidaService.pesquisar(f, pagina, tamanho))
                .map(modalidadeMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

}
