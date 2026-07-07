package br.com.caimbebasketball.model;

import java.time.LocalDate;

public class CarteirinhaDigital {

    private String nomeAtleta;
    private String fotoPerfilUrl;
    private String nivelBasquete;
    private String codigoInscricao; // ID formatado (ex: CAIMBE-001)
    private LocalDate dataEmissao;
    private LocalDate dataValidade;
    private String statusAtleta; // PAGO, BOLSISTA, etc.

    // Construtor completo
    public CarteirinhaDigital(String nomeAtleta, String fotoPerfilUrl, String nivelBasquete,
                              String codigoInscricao, LocalDate dataEmissao, LocalDate dataValidade, String statusAtleta) {
        this.nomeAtleta = nomeAtleta;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.nivelBasquete = nivelBasquete;
        this.codigoInscricao = codigoInscricao;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
        this.statusAtleta = statusAtleta;
    }

    // Getters e Setters
    public String getNomeAtleta() { return nomeAtleta; }
    public void setNomeAtleta(String nomeAtleta) { this.nomeAtleta = nomeAtleta; }

    public String getFotoPerfilUrl() { return fotoPerfilUrl; }
    public void setFotoPerfilUrl(String fotoPerfilUrl) { this.fotoPerfilUrl = fotoPerfilUrl; }

    public String getNivelBasquete() { return nivelBasquete; }
    public void setNivelBasquete(String nivelBasquete) { this.nivelBasquete = nivelBasquete; }

    public String getCodigoInscricao() { return codigoInscricao; }
    public void setCodigoInscricao(String codigoInscricao) { this.codigoInscricao = codigoInscricao; }

    public LocalDate getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(LocalDate dataEmissao) { this.dataEmissao = dataEmissao; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

    public String getStatusAtleta() { return statusAtleta; }
    public void setStatusAtleta(String statusAtleta) { this.statusAtleta = statusAtleta; }
}