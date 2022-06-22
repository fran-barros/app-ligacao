package com.example.appligacao.repository;

import com.example.appligacao.domain.Ligacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigacaoRepository extends JpaRepository<Ligacao, String> {
}
