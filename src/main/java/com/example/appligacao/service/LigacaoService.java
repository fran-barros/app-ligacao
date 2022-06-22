package com.example.appligacao.service;
import com.example.appligacao.domain.Ligacao;
import com.example.appligacao.repository.AgendaRepository;
import com.example.appligacao.repository.LigacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LigacaoService {

    private final LigacaoRepository ligacaoRepository;
    private final AgendaRepository agendaRepository;

    public Ligacao fazerLigacao(Ligacao request, boolean existeNaAgenda) {

        if(existeNaAgenda == true){
            agendaRepository.existsById(request.getRegistroTelefonema().getTelefoneDestino());

            Ligacao ligacao = Ligacao.builder()
                    .dataInicio(new Date())
                    .registroTelefonema(request.getRegistroTelefonema())
                    .build();

            return ligacaoRepository.save(ligacao);
        }
    }

    public Ligacao encerrarLigacao(String id) {

        Optional<Ligacao> ligacaoOptional = ligacaoRepository.findById(id);

        if(ligacaoOptional.isPresent()){
            Ligacao ligacao = ligacaoOptional.get();
            ligacao.setDataFim(new Date());
            ligacao.buscarDuracaoMinutos(ligacaoOptional.get().getDataInicio(), new Date());
            ligacao.calcularPulsos();
            ligacao.calcularGasto();
            return ligacaoRepository.save(ligacao);
        }
        return null;
    }
}
