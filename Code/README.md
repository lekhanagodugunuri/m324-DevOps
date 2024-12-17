Docker Image bauen

Anforderungen:
- Docker Desktop installiert und Gestartet
- Intellij gestartet und das Code Directory als Project geöffnet
- Intellij Terminal geöffnet und mit "cd db" in das db Directory
- dann folgende Commands

Im Verzeichnis Code/db/, in dem sich der Dockerfile und schema.sql befinden, führt du folgenden Befehl aus:

docker build -t my-postgres-db:latest .

Container starten
Wenn das Image erfolgreich erstellt wurde, kann ein Container daraus gestartet werden:

docker run -d --name my-postgres-db -p 5432:5432 my-postgres-db:latest

Als überprüfung ob die DB läuft:

docker ps

Dann folgende Schritte:

- nach den Commands bei Database rechts in Intellij auf das Plus und Data Source und Postgressql auswählen
- bei User und Password "postgres" und dann rechtsklick auf die neu stehende Database und reload