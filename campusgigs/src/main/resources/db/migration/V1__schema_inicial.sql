CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL,
                          cep VARCHAR(8) NOT NULL,
                          cidade VARCHAR(120),
                          uf VARCHAR(2),
                          role VARCHAR(20) NOT NULL DEFAULT 'USER'
);

CREATE TABLE servicos (
                          id BIGSERIAL PRIMARY KEY,
                          prestador_id BIGINT NOT NULL REFERENCES usuarios(id),
                          titulo VARCHAR(255) NOT NULL,
                          descricao VARCHAR(2000) NOT NULL,
                          categoria VARCHAR(100) NOT NULL,
                          preco NUMERIC(10,2) NOT NULL,
                          situacao VARCHAR(20) NOT NULL DEFAULT 'ATIVO'
);

CREATE TABLE contratacoes (
                              id BIGSERIAL PRIMARY KEY,
                              servico_id BIGINT NOT NULL REFERENCES servicos(id),
                              contratante_id BIGINT NOT NULL REFERENCES usuarios(id),
                              situacao VARCHAR(20) NOT NULL DEFAULT 'SOLICITADA',
                              criado_em TIMESTAMP NOT NULL DEFAULT now()
);

CREATE INDEX idx_servicos_situacao ON servicos(situacao);
CREATE INDEX idx_contratacoes_contratante ON contratacoes(contratante_id);
