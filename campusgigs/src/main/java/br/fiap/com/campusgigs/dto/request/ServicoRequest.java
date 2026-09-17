package br.fiap.com.campusgigs.dto.request;

import java.math.BigDecimal;

public record ServicoRequest(String titulo, String descricao, String categoria, BigDecimal preco) {}