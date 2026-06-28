package br.com.caimbebasketball.service;

import br.com.caimbebasketball.model.Mensalidade;
import br.com.caimbebasketball.repository.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class MensalidadeService {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    // Método para gerar uma nova cobrança no sistema
    public Mensalidade criarMensalidade(Mensalidade mensalidade) {
        mensalidade.setPago(false); // Garante que toda mensalidade nova começa como Não Paga
        return mensalidadeRepository.save(mensalidade);
    }

    // LÓGICA DA BAIXA MANUAL: O professor/administrador clica no botão "Marcar como Pago"
    public Mensalidade registrarPagamentoManual(Long mensalidadeId) {
        // 1. Busca a mensalidade no banco. Se não achar, lança um erro.
        Mensalidade mensalidade = mensalidadeRepository.findById(mensalidadeId)
                .orElseThrow(() -> new RuntimeException("Mensalidade não encontrada com o ID: " + mensalidadeId));

        // 2. Altera o status para pago
        mensalidade.setPago(true);

        // 3. Registra a data exata em que o dinheiro/PIX foi recebido manualmente
        mensalidade.setDataPagamento(LocalDate.now());

        // 4. Salva a atualização de volta no banco de dados PostgreSQL
        return mensalidadeRepository.save(mensalidade);
    }

    // Listar o histórico de mensalidades de um aluno específico
    public List<Mensalidade> listarPorAtleta(Long atletaId) {
        return mensalidadeRepository.findByAtletaId(atletaId);
    }
}