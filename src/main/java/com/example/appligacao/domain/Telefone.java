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
public class Telefone {
    @Id
    private String numero;
    private String nome;
    private Operadora operadora;
}
