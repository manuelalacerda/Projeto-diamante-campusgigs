package br.fiap.com.campusgigs.repository;

import br.fiap.com.campusgigs.entity.Contratacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ContratacaoRepository extends JpaRepository<Contratacao, UUID> {
}