package br.fiap.com.campusgigs.entity;

import br.fiap.com.campusgigs.enums.SituacaoContratacao;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_contratacoes")
public class Contratacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "contratante_id", nullable = false)
    private Usuario contratante;

    @Enumerated(EnumType.STRING)
    private SituacaoContratacao situacao = SituacaoContratacao.SOLICITADA;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }
    public Usuario getContratante() { return contratante; }
    public void setContratante(Usuario contratante) { this.contratante = contratante; }
    public SituacaoContratacao getSituacao() { return situacao; }
    public void setSituacao(SituacaoContratacao situacao) { this.situacao = situacao; }
}