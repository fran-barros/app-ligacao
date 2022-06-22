package com.example.appligacao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ligacao implements Serializable {

    @Id
    private String id;
    private Date dataInicio;
    private Date dataFim;
    private Long duracao;
    private Double gasto;
    private Long pulsos;
    private RegistroTelefonema registroTelefonema;

    public Long buscarDuracaoMinutos(Date dataInicio, Date dataFim){
        Long diff = dataFim.getTime() - dataInicio.getTime();
        TimeUnit time = TimeUnit.MINUTES;
        long duracao = time.convert(diff, TimeUnit.MINUTES);
        return duracao;
    }

    public Long calcularPulsos(){

        Long duracao = buscarDuracaoMinutos(this.dataInicio, this.dataFim);
        Long pulsos =  (duracao / 4) + 1;
        return pulsos;
    }

    public Double calcularGasto(){
        Double gasto =  this.pulsos * 0.08;
        return gasto;
    }
}
