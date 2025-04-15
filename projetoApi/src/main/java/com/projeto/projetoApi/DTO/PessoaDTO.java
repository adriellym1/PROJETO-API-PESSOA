package com.exemplo.universidade.dto;

import jakarta.validation.constraints.*;

public record PessoaDTO(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @NotBlank(message = "CPF é obrigatório") @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos") String cpf,
        @NotNull(message = "Idade é obrigatória") @Min(0) Integer idade
) {}