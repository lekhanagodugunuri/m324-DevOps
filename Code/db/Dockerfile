# Als Basis das offizielle Postgres-Image verwenden
FROM postgres:15-alpine

# Umgebungsvariablen für Postgres (kannst du nach Bedarf anpassen)
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=postgres

# Schema-Datei in das Initialisierungsverzeichnis von Postgres kopieren
COPY schema.sql /docker-entrypoint-initdb.d/

# Der Postgres-Standardport
EXPOSE 5432

# Wenn du noch weitere Initialisierungen brauchst, kannst du weitere SQL-Skripte hinzufügen
# Die werden dann beim ersten Containerstart ausgeführt.

# Der Entrypoint und CMD kommen aus dem Basis-Image
