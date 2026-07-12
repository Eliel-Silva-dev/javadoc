package com.hydrahtec.dsaula05.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDto(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,
        @NotBlank(message = "O nome da categoria é obrigatório")
        @Size(min = 3, max = 80, message = "O nome da categoria deve conter entre 3 e 80 caracteres")
        String name) {
}
