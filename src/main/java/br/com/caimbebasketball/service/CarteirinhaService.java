package br.com.caimbebasketball.service;

import br.com.caimbebasketball.model.Atleta;
import br.com.caimbebasketball.model.CarteirinhaDigital;
import br.com.caimbebasketball.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class CarteirinhaService {

    @Autowired
    private AtletaRepository atletaRepository;

    public CarteirinhaDigital gerarCarteirinha(Long atletaId) {
        // 1. Busca o atleta no banco de dados para garantir que ele existe
        Atleta atleta = atletaRepository.findById(atletaId)
                .orElseThrow(() -> new RuntimeException("Atleta não encontrado para gerar carteirinha. ID: " + atletaId));

        // 2. Cria o código personalizado de inscrição (Ex: ID 5 vira CAIMBE-005)
        String codigoInscricao = String.format("CAIMBE-%03d", atleta.getId());

        // 3. Define as datas de emissão (hoje) e validade (daqui a 1 ano)
        LocalDate hoje = LocalDate.now();
        LocalDate validade = hoje.plusYears(1);

        // 4. Monta o objeto da carteirinha digital com a identidade visual pronta para o front
        return new CarteirinhaDigital(
                atleta.getNome(),
                atleta.getFotoPerfilUrl(),
                atleta.getNivel().toString(),
                codigoInscricao,
                hoje,
                validade,
                atleta.getStatus().toString()
        );
    }
}