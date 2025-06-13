package com.example.demo.repositories;

import com.example.demo.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    public List<Transacao> findAllByOrderByDataHoraDesc();

}
