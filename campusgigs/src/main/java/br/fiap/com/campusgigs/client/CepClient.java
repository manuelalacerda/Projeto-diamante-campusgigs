package br.fiap.com.campusgigs.client;

import br.fiap.com.campusgigs.dto.response.EnderecoResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface CepClient {

    @GetExchange("/{cep}/json")
    EnderecoResponse buscarCep(@PathVariable("cep") String cep);

}