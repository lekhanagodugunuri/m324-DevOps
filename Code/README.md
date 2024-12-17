Docker Image bauen
Im Verzeichnis Code/db/, in dem sich der Dockerfile und schema.sql befinden, führt du folgenden Befehl aus:

docker build -t my-postgres-db:latest .

Container starten
Wenn das Image erfolgreich erstellt wurde, kann ein Container daraus gestartet werden:

docker run -d --name my-postgres-db -p 5432:5432 my-postgres-db:latest