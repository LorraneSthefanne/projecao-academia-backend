package br.com.lorrane.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FrequenciaFiltro {

    @NotNull(message = "ID da pessoa n\u00E3o pode ser nulo.")
    private UUID idPessoa;
    private LocalDate data;
}
