package br.com.caimbebasketball.model;

import br.com.caimbebasketball.model.enums.NivelBasquete;
import br.com.caimbebasketball.model.enums.StatusFinanceiro;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity // Diz ao Spring que esta classe será uma tabela no PostgreSQL
@Table(name = "tb_atleta") // Define o nome da tabela no banco de dados
public class Atleta {

    @Id // Define que este campo é a Chave Primária (ID único)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O PostgreSQL vai auto-incrementar o ID (1, 2, 3...)
    private Long id;

    @Column(nullable = false, length = 150) // Campo obrigatório e com limite de caracteres
    private String nome;

    private String fotoPerfilUrl;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    // --- Saúde e Biometria ---
    private Double altura;
    private Double peso;

    @Column(name = "tipo_sanguineo", length = 3)
    private String tipoSanguineo;

    @Column(columnDefinition = "TEXT") // Permite textos longos para histórico médico
    private String observacoesMedicas;

    // --- Escolar e Técnico ---
    private String escola;
    private String serie;

    @Enumerated(EnumType.STRING) // Salva o texto do Enum (ex: "INICIANTE") no banco
    private NivelBasquete nivel;

    // --- Financeiro ---
    @Enumerated(EnumType.STRING)
    private StatusFinanceiro status;

    // --- Construtores (Obrigatório para o JPA) ---
    public Atleta() {
    }

    // --- Getters e Setters ---
    // (Você pode gerar automaticamente na sua IDE com Alt+Insert ou usando o Lombok no futuro)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public Double getAltura() { return altura; }
    public void setAltura(Double altura) { this.altura = altura; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public String getTipoSanguineo() { return tipoSanguineo; }
    public void setTipoSanguineo(String tipoSanguineo) { this.tipoSanguineo = tipoSanguineo; }

    public String getObservacoesMedicas() { return observacoesMedicas; }
    public void setObservacoesMedicas(String observacoesMedicas) { this.observacoesMedicas = observacoesMedicas; }

    public String getEscola() { return escola; }
    public void setEscola(String escola) { this.escola = escola; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public NivelBasquete getNivel() { return nivel; }
    public void setNivel(NivelBasquete nivel) { this.nivel = nivel; }

    public StatusFinanceiro getStatus() { return status; }
    public void setStatus(StatusFinanceiro status) { this.status = status; }

    public String getFotoPerfilUrl() { return fotoPerfilUrl; }
    public void setFotoPerfilUrl(String fotoPerfilUrl) { this.fotoPerfilUrl = fotoPerfilUrl; }
}