package br.fiap.com.campusgigs.dto.response;

public record EnderecoResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        Boolean erro
) {}