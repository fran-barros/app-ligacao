package com.example.appligacao.repository;


import com.example.appligacao.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Telefone, String> {
}
