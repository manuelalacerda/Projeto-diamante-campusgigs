package br.fiap.com.campusgigs.controller;

import br.fiap.com.campusgigs.entity.Servico;
import br.fiap.com.campusgigs.entity.Usuario;
import br.fiap.com.campusgigs.repository.ServicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoRepository servicoRepository;

    public ServicoController(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @PostMapping
    public ResponseEntity<Servico> publicar(@RequestBody Servico servico, @AuthenticationPrincipal Usuario usuarioLogado) {
        servico.setPrestador(usuarioLogado);
        Servico novoServico = servicoRepository.save(servico);
        return ResponseEntity.ok(novoServico);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listar() {
        List<Servico> servicos = servicoRepository.findAll();
        return ResponseEntity.ok(servicos);
    }
}