package br.com.caimbebasketball.repository;

import br.com.caimbebasketball.model.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEstoqueRepository extends JpaRepository<ItemEstoque, Long> {
    // Pronto! Esta interface já tem tudo o que precisa para controlar o estoque de uniformes.
}