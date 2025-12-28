#!/usr/bin/env bash
# Script de backup do banco BNDesigner
# Uso: ./backup.sh

TIMESTAMP=$(date +"%Y%m%d_%H%M%S")
OUTPUT_DIR="./backups"
FILENAME="bndesigner_backup_$TIMESTAMP.sql"

# Criar diretório de backups se não existir
mkdir -p "$OUTPUT_DIR"

# Executar backup usando docker exec
# Ajuste o nome do container se necessário
CONTAINER_NAME="bndesigner_db"

if docker ps --format '{{.Names}}' | grep -q "^$CONTAINER_NAME$"; then
  echo "📦 Realizando backup do banco dentro do container '$CONTAINER_NAME'..."
  docker exec -t $CONTAINER_NAME pg_dump -U postgres -d bndesigner > "$OUTPUT_DIR/$FILENAME"
  echo "✅ Backup criado: $OUTPUT_DIR/$FILENAME"
else
  echo "❌ ERRO: Container '$CONTAINER_NAME' não está em execução."
  echo "Inicie a infraestrutura com: docker compose up -d"
fi
