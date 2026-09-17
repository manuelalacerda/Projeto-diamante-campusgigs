package br.fiap.com.campusgigs.entity;

import br.fiap.com.campusgigs.enums.SituacaoServico;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String descricao;
    private String categoria;
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private SituacaoServico situacao = SituacaoServico.ATIVO;

    @ManyToOne
    @JoinColumn(name = "prestador_id", nullable = false)
    private Usuario prestador;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public SituacaoServico getSituacao() { return situacao; }
    public void setSituacao(SituacaoServico situacao) { this.situacao = situacao; }
    public Usuario getPrestador() { return prestador; }
    public void setPrestador(Usuario prestador) { this.prestador = prestador; }
}