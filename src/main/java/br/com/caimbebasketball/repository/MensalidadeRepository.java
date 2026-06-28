package br.com.caimbebasketball.repository;

import br.com.caimbebasketball.model.Mensalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {

    // Esse método vai permitir buscar todas as mensalidades de um aluno específico
    List<Mensalidade> findByAtletaId(Long atletaId);
}