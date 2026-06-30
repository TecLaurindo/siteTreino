package br.com.caimbebasketball.repository;

import br.com.caimbebasketball.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Diz ao Spring que esta é uma classe de acesso ao banco de dados
public interface AtletaRepository extends JpaRepository<Atleta, Long> {

    // O JpaRepository precisa saber:
    // 1. Qual é a classe (Atleta)
    // 2. Qual o tipo do ID dela (Long)

    // Se no futuro você quiser buscar um atleta pelo nome exato, basta declarar assim:
    // List<Atleta> findByNomeContainingIgnoreCase(String nome);
}