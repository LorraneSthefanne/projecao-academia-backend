package br.com.lorrane.controllers;

import br.com.lorrane.controllers.dto.FrequenciaDTO;
import br.com.lorrane.controllers.dto.PaginaDTO;
import br.com.lorrane.mapper.FrequenciaMapper;
import br.com.lorrane.models.ConfirmarFrequencia;
import br.com.lorrane.models.FrequenciaFiltro;
import br.com.lorrane.services.FrequenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = FrequenciaController.PATH)
public class FrequenciaController {

    public static final String PATH = "/frequencias";

    private final FrequenciaMapper frequenciaMapper;
    private final FrequenciaService frequenciaService;

    @PostMapping
    public ResponseEntity<?> confirmar(@RequestBody ConfirmarFrequencia confirmar) {
        Optional.of(confirmar).ifPresent(frequenciaService::confirmar);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<PaginaDTO<FrequenciaDTO>> buscar(@Validated FrequenciaFiltro filtro,
                                                           @RequestParam(value = "pagina", defaultValue = "0") int pagina,
                                                           @RequestParam(value = "tamanho", defaultValue = "10") int tamanho) {
        return Optional.of(filtro)
                .map(f -> frequenciaService.buscar(f, pagina, tamanho))
                .map(frequenciaMapper::fromPage)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

}
