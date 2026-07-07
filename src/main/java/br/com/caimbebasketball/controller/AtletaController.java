package br.com.caimbebasketball.controller;

import br.com.caimbebasketball.model.Atleta;
import br.com.caimbebasketball.model.CarteirinhaDigital; // 👈 FALTAVA ESSE IMPORT
import br.com.caimbebasketball.service.AtletaService;
import br.com.caimbebasketball.service.CarteirinhaService; // 👈 FALTAVA ESSE IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/atletas")
@CrossOrigin(origins = "*")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @Autowired // Uma boa prática profissional é agrupar os @Autowired no topo da classe
    private CarteirinhaService carteirinhaService;

    // Rota para cadastrar um atleta (POST http://localhost:8080/api/atletas)
    @PostMapping
    public ResponseEntity<Atleta> cadastrar(@RequestBody Atleta atleta) {
        Atleta novoAtleta = atletaService.salvar(atleta);
        return ResponseEntity.ok(novoAtleta);
    }

    // Rota para listar todos (GET http://localhost:8080/api/atletas)
    @GetMapping
    public ResponseEntity<List<Atleta>> listarTodos() {
        return ResponseEntity.ok(atletaService.listarTodos());
    }

    // Rota para buscar um por ID (GET http://localhost:8080/api/atletas/1)
    @GetMapping("/{id}")
    public ResponseEntity<Atleta> buscarPorId(@PathVariable Long id) {
        return atletaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Rota para deletar (DELETE http://localhost:8080/api/atletas/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        atletaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Rota para buscar a carteirinha digital (GET http://localhost:8080/api/atletas/1/carteirinha)
    @GetMapping("/{id}/carteirinha")
    public ResponseEntity<CarteirinhaDigital> obterCarteirinhaDigital(@PathVariable Long id) {
        CarteirinhaDigital carteirinha = carteirinhaService.gerarCarteirinha(id);
        return ResponseEntity.ok(carteirinha);
    }
}