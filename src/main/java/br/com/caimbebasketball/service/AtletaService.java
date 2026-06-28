package br.com.caimbebasketball.service;

import br.com.caimbebasketball.model.Atleta;
import br.com.caimbebasketball.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    // Regra para salvar ou atualizar um atleta
    public Atleta salvar(Atleta atleta) {
        // Aqui você poderia colocar validações no futuro (ex: verificar se o aluno é menor de idade)
        return atletaRepository.save(atleta);
    }

    // Listar todos os atletas matriculados
    public List<Atleta> listarTodos() {
        return atletaRepository.findAll();
    }

    // Buscar um atleta específico pelo ID
    public Optional<Atleta> buscarPorId(Long id) {
        return atletaRepository.findById(id);
    }

    // Excluir um atleta do sistema
    public void deletar(Long id) {
        atletaRepository.deleteById(id);
    }
}