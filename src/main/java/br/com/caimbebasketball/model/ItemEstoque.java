package br.com.caimbebasketball.model;

import br.com.caimbebasketball.model.enums.Tamanho;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_item_estoque")
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String descricao; // Ex: "Camisa Oficial de Treino"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Tamanho tamanho; // P, M, G, etc.

    @Column(name = "quantidade_disponivel", nullable = false)
    private Integer quantidadeDisponivel;

    @Column(name = "valor_unitario")
    private Double valorUnitario; // Caso seja vendido ou para controle de custo

    // Construtor padrão obrigatório para o JPA
    public ItemEstoque() {
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Tamanho getTamanho() { return tamanho; }
    public void setTamanho(Tamanho tamanho) { this.tamanho = tamanho; }

    public Integer getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) { this.quantidadeDisponivel = quantidadeDisponivel; }

    public Double getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(Double valorUnitario) { this.valorUnitario = valorUnitario; }
}