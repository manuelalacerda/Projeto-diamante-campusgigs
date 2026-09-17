package br.fiap.com.campusgigs.controller;

import br.fiap.com.campusgigs.entity.Contratacao;
import br.fiap.com.campusgigs.entity.Usuario;
import br.fiap.com.campusgigs.service.ContratacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/contratacoes")
public class ContratacaoController {

    private final ContratacaoService contratacaoService;

    public ContratacaoController(ContratacaoService contratacaoService) {
        this.contratacaoService = contratacaoService;
    }

    @PostMapping("/{servicoId}")
    public ResponseEntity<Contratacao> contratar(@PathVariable UUID servicoId, @AuthenticationPrincipal Usuario usuarioLogado) {
        Contratacao novaContratacao = contratacaoService.contratar(servicoId, usuarioLogado);
        return ResponseEntity.ok(novaContratacao);
    }
}