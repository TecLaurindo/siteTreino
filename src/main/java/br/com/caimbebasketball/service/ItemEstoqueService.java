package br.com.caimbebasketball.service;

import br.com.caimbebasketball.model.ItemEstoque;
import br.com.caimbebasketball.repository.ItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemEstoqueService {

    @Autowired
    private ItemEstoqueRepository itemEstoqueRepository;

    // Cadastrar um novo lote de uniformes ou atualizar dados básicos
    public ItemEstoque salvar(ItemEstoque item) {
        return itemEstoqueRepository.save(item);
    }

    // Listar tudo o que tem no estoque (útil para a tabela do administrador)
    public List<ItemEstoque> listarTodos() {
        return itemEstoqueRepository.findAll();
    }

    // REGRA DE NEGÓCIO: Dar baixa no estoque quando um uniforme for entregue
    public ItemEstoque darBaixaNoEstoque(Long itemId, Integer quantidadeEntregue) {
        // 1. Busca o item no banco de dados
        ItemEstoque item = itemEstoqueRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item de estoque não encontrado! ID: " + itemId));

        // 2. Valida se temos quantidade suficiente para entregar
        if (item.getQuantidadeDisponivel() < quantidadeEntregue) {
            throw new RuntimeException("Estoque insuficiente para o item: " + item.getDescricao() +
                    ". Quantidade disponível: " + item.getQuantidadeDisponivel());
        }

        // 3. Subtrai a quantidade antiga pela quantidade entregue
        int novaQuantidade = item.getQuantidadeDisponivel() - quantidadeEntregue;
        item.setQuantidadeDisponivel(novaQuantidade);

        // 4. Salva a nova quantidade atualizada no PostgreSQL
        return itemEstoqueRepository.save(item);
    }
}