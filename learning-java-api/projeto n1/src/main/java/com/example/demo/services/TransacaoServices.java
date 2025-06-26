package com.example.demo.services;

import com.example.demo.models.Transacao;
import com.example.demo.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoServices {
    @Autowired
    TransacaoRepository transacaoRepository;
    public void salvar(Transacao transacao){ transacaoRepository.save(transacao);}
    
    public Optional<Transacao> buscarPeloId(int id){return transacaoRepository.findById(id);}
    
    public List<Transacao> buscarTodas(){return transacaoRepository.findAllByOrderByDataHoraDesc();}
    
    public void deletar(int id){transacaoRepository.deleteById(id);}
    
    public void apagar(int id){
        transacaoRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Transação não encontrada"));
        
        transacaoRepository.deleteById(id);
    }

    public void editar(Transacao transacao) {

    }
        public DoubleSummaryStatistics calcularEstatisticas() {
        // Calcula o momento exato de 60 segundos atrás
        OffsetDateTime sessentaSegundosAtras = OffsetDateTime.now().minusSeconds(60);

        // Busca no banco apenas as transações relevantes (dos últimos 60s)
        List<Transacao> transacoesRecentes = transacaoRepository.findByDataHoraAfter(sessentaSegundosAtras);

        // Usa a classe DoubleSummaryStatistics para fazer todos os cálculos de uma só vez
        return transacoesRecentes.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }
    public void apagarTodasAsTransacoes() {
    transacaoRepository.deleteAll();
}
}
