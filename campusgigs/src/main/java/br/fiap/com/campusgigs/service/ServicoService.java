package br.fiap.com.campusgigs.service;

import br.fiap.com.campusgigs.entity.Servico;
import br.fiap.com.campusgigs.entity.Usuario;
import br.fiap.com.campusgigs.enums.Papel;
import br.fiap.com.campusgigs.enums.SituacaoServico;
import br.fiap.com.campusgigs.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico publicar(Servico servico, Usuario prestador) {
        servico.setPrestador(prestador);
        servico.setSituacao(SituacaoServico.ATIVO);
        return servicoRepository.save(servico);
    }

    public void encerrar(UUID servicoId, Usuario usuarioLogado) {
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado."));

        boolean isDono = servico.getPrestador().getId().equals(usuarioLogado.getId());
        boolean isAdmin = usuarioLogado.getRole() == Papel.ADMIN;

        if (!isDono && !isAdmin) {
            throw new SecurityException("Acesso negado: você não tem permissão para encerrar este serviço.");
        }

        servico.setSituacao(SituacaoServico.ENCERRADO);
        servicoRepository.save(servico);
    }
}