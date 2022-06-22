package com.example.appligacao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroTelefonema {
    @Id
    private String id;
    private String telefoneOrigem;
    private String telefoneDestino;
}
