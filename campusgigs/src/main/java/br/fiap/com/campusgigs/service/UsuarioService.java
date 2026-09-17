package br.fiap.com.campusgigs.service;

import br.fiap.com.campusgigs.client.CepClient;
import br.fiap.com.campusgigs.dto.response.EnderecoResponse;
import br.fiap.com.campusgigs.entity.Usuario;
import br.fiap.com.campusgigs.enums.Papel;
import br.fiap.com.campusgigs.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CepClient cepClient;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, CepClient cepClient, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.cepClient = cepClient;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario cadastrar(Usuario usuario) {
        try {
            EnderecoResponse endereco = cepClient.buscarCep(usuario.getCep());
            if (endereco == null || Boolean.TRUE.equals(endereco.erro())) {
                throw new RuntimeException("CEP inválido ou não encontrado.");
            }
            usuario.setCidade(endereco.localidade());
            usuario.setUf(endereco.uf());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar o serviço de CEP ou CEP inexistente: " + e.getMessage());
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setRole(Papel.USER);
        return usuarioRepository.save(usuario);

    }
}