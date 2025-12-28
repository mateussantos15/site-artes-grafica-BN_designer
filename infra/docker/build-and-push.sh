#!/usr/bin/env bash
# Script para buildar e publicar a imagem Docker do BNDesigner
# Uso: ./build-and-push.sh <versão> <registro/opcional>
# Exemplo: ./build-and-push.sh 1.0.0 mateus/bndesigner

set -e

VERSION=${1:-latest}
IMAGE_NAME=${2:-bndesigner}
FULL_IMAGE_NAME="$IMAGE_NAME:$VERSION"

# Caminho do Dockerfile
DOCKERFILE_PATH="infra/docker/Dockerfile"

if [ ! -f "$DOCKERFILE_PATH" ]; then
  echo "❌ ERRO: Dockerfile não encontrado em $DOCKERFILE_PATH"
  exit 1
fi

# Build da imagem
echo "🐳 Construindo imagem Docker: $FULL_IMAGE_NAME"
docker build -f $DOCKERFILE_PATH -t $FULL_IMAGE_NAME .

echo "✅ Build concluído: $FULL_IMAGE_NAME"

# Push opcional
read -p "Deseja enviar a imagem para um registro remoto? (y/N): " RESP

if [[ "$RESP" =~ ^[Yy]$ ]]; then
  echo "🚀 Enviando imagem para o registro..."
  docker push $FULL_IMAGE_NAME
  echo "✅ Push realizado: $FULL_IMAGE_NAME"
else
  echo "ℹ Push ignorado. Imagem mantida localmente."
fi
