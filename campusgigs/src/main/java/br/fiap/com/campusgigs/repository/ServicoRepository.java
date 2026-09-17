package br.fiap.com.campusgigs.repository;

import br.fiap.com.campusgigs.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}