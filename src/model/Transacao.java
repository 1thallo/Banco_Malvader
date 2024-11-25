package src.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {
    private Integer idTransacao;
    private TipoTransacao tipoTransacao;
    private BigDecimal valorTransacao;
    private LocalDateTime dataHoraTransacao;
    private Integer idConta;

    // enumeração para o tipo de transação
    public enum TipoTransacao {
        DEPOSITO, SAQUE, TRANSFERENCIA
    }

    // Construtor e Getters/Setters
    public Transacao() {
    }

    public Integer getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public LocalDateTime getDataHoraTransacao() {
        return dataHoraTransacao;
    }

    public void setDataHoraTransacao(LocalDateTime dataHoraTransacao) {
        this.dataHoraTransacao = dataHoraTransacao;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }
}