-- Inicialização do esquema do banco BNDesigner
-- Este script é executado automaticamente quando o container Postgres é criado pela primeira vez.

-- Criar schema padrão (opcional, pois o public já existe)
CREATE SCHEMA IF NOT EXISTS public;

-- Exemplo: criar tabela de auditoria mínima (caso deseje seed inicial)
-- Você pode adicionar aqui seeds para ambiente de desenvolvimento.

-- CREATE TABLE IF NOT EXISTS exemplo_seed (
--     id SERIAL PRIMARY KEY,
--     descricao VARCHAR(100) NOT NULL,
--     criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );

-- INSERT INTO exemplo_seed (descricao) VALUES ('Seed de teste executado no init SQL');
