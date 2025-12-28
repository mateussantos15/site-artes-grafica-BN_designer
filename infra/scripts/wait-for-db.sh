#!/bin/sh
HOST=${1:-db}
PORT=${2:-5432}
TIMEOUT=${3:-60}

echo "Aguardando $HOST:$PORT por até $TIMEOUT segundos..."
i=0
while ! nc -z "$HOST" "$PORT" >/dev/null 2>&1; do
  i=$((i+1))
  if [ "$i" -ge "$TIMEOUT" ]; then
    echo "Timeout aguardando $HOST:$PORT"
    exit 1
  fi
  sleep 1
done

echo "$HOST:$PORT disponível — iniciando app"
exec java -jar /app/app.jar
