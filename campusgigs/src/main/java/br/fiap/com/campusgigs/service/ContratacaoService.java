package br.fiap.com.campusgigs.service;

import br.fiap.com.campusgigs.entity.Contratacao;
import br.fiap.com.campusgigs.entity.Servico;
import br.fiap.com.campusgigs.entity.Usuario;
import br.fiap.com.campusgigs.enums.SituacaoContratacao;
import br.fiap.com.campusgigs.enums.SituacaoServico;
import br.fiap.com.campusgigs.repository.ContratacaoRepository;
import br.fiap.com.campusgigs.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContratacaoService {

    private final ContratacaoRepository contratacaoRepository;
    private final ServicoRepository servicoRepository;

    public ContratacaoService(ContratacaoRepository contratacaoRepository, ServicoRepository servicoRepository) {
        this.contratacaoRepository = contratacaoRepository;
        this.servicoRepository = servicoRepository;
    }

    public Contratacao contratar(UUID servicoId, Usuario contratante) {
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado."));

        if (servico.getSituacao() != SituacaoServico.ATIVO) {
            throw new IllegalArgumentException("O serviço não está ativo para contratação.");
        }

        if (servico.getPrestador().getId().equals(contratante.getId())) {
            throw new IllegalArgumentException("Você não pode contratar o seu próprio serviço.");
        }

        Contratacao contratacao = new Contratacao();
        contratacao.setServico(servico);
        contratacao.setContratante(contratante);
        contratacao.setSituacao(SituacaoContratacao.SOLICITADA);

        return contratacaoRepository.save(contratacao);
    }
}