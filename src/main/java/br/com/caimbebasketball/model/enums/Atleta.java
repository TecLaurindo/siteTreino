package br.com.caimbebasketball.model.enums;

public class Atleta {
    private Long id;
    private String nome;
    private String fotoPerfilUrl;
    private LocalDate dataNascimento;

    // Saúde e Biometria
    private Double altura;
    private Double peso;
    private String tipoSanguineo;
    private String observacoesMedicas;

    // Escolar e Técnico
    private String escola;
    private String serie;
    private NivelBasquete nivel; // Ex: INICIANTE, INTERMEDIARIO, AVANCADO

    // Relacionamento com Financeiro
    private StatusFinanceiro status; // PAGO, PENDENTE, BOLSISTA
}