package br.com.caimbebasketball.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_mensalidade")
public class Mensalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento: Muitas mensalidades pertencem a um Atleta
    @ManyToOne
    @JoinColumn(name = "atleta_id", nullable = false)
    private Atleta atleta;

    @Column(name = "mes_referencia", nullable = false, length = 7)
    private String mesReferencia; // Salvaremos no formato "AAAA-MM", ex: "2026-06"

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Boolean pago = false; // Começa como falso (não pago) por padrão

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento; // Registra o dia em que o administrador marcou como pago

    // Construtor padrão obrigatório para o JPA
    public Mensalidade() {
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Atleta getAtleta() { return atleta; }
    public void setAtleta(Atleta atleta) { this.atleta = atleta; }

    public String getMesReferencia() { return mesReferencia; }
    public void setMesReferencia(String mesReferencia) { this.mesReferencia = mesReferencia; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Boolean getPago() { return pago; }
    public void setPago(Boolean pago) { this.pago = pago; }

    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }
}