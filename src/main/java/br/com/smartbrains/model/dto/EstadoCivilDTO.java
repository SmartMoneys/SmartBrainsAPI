package br.com.smartbrains.model.dto;

import br.com.smartbrains.model.entity.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstadoCivilDTO {

    private Integer id;

    @NotNull
    @Size(max = 50)
    private String descricao;
    
    public EstadoCivilDTO(EstadoCivil estadoCivil) {
        this.id = estadoCivil.getId();
        this.descricao = estadoCivil.getDescricao();
    }
}