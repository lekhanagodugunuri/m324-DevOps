## **Projektbeschreibung: Immobilienplattform**
---
Die Immobilienmarkt-App ermöglicht es Nutzern, Immobilien zu suchen, anzubieten und Transaktionen abzuwickeln. Ziel des Projekts ist die Entwicklung einer modularen Anwendung zur Verwaltung von Immobilien, Ortschaften und Kunden, basierend auf zwei unabhängigen Microservices:

1. **Mikroservice 1: Verwaltung von Ortschaften**
2. **Mikroservice 2: Verwaltung von Immobilien**

## **Rahmenbedingungen**
---
- **Trennung der Microservices:** Beide Services werden als separate Projekte behandelt.
- **Datenbanken:** Jeder Service verwendet eine eigene Datenbank, auch wenn die gleiche Software genutzt wird.
- **Kommunikation:** Interaktionen zwischen Microservices erfolgen ausschließlich über REST-Endpoints.

## **Details zu den Microservices**
---
### **Mikroservice 1: Verwaltung von Ortschaften**

#### Funktionen

1. **Ortschaften erfassen**
    
    - API-Endpoint: **POST /api/locations**
    - Validierung:
        - Name: Pflichtfeld.
        - Postleitzahl: Gültiges Format erforderlich.
        - Einwohnerzahl und Gründungsdatum: Müssen valide sein.
    - Fehlerbehandlung:
        - Klare Fehlermeldungen wie "Name ist erforderlich".
    - Rückgabe: Übersicht der erfassten Ortschaften in JSON.
2. **Alle Ortschaften auslesen**
    
    - API-Endpoint: **GET /api/locations**
    - Pagination zur Unterstützung großer Datenmengen.
    - Rückgabe: Name, Postleitzahl, Gründungsdatum, Einwohnerzahl, ID.
    - Fehlerbehandlung: Z. B. "Keine Ortschaften vorhanden".

#### Beispielantwort

```json
{
  "id": 1,
  "name": "Musterstadt",
  "postalCode": "12345",
  "founded": "1900-01-01",
  "population": 50000
}
```


### **Mikroservice 2: Verwaltung von Immobilien**

#### Funktionen

1. **Immobilie erfassen**
    - API-Endpoint: **POST /api/properties**
    - Validierung:
        - Typ (z. B. Wohnung, Haus): Pflichtfeld.
        - Zimmeranzahl, Wohnfläche: Positive Zahlen erforderlich.
        - Ortschaft: Validierung über Mikroservice 1.
    - Fehlerbehandlung:
        - Klare Fehlermeldungen wie "Ungültige Zimmeranzahl".
        - Integration: Fehlermeldung, falls Ortschaft nicht existiert.
    - Rückgabe: Liste aller Immobilien in JSON.

#### Beispielantwort

```json
{
  "id": 1,
  "type": "Haus",
  "rooms": 5,
  "area": 120,
  "locationId": 1,
  "price": 500000,
  "saleDate": "2023-12-01"
}
```


## **Infrastruktur und Technologien**
---
- **Backend:** Java Spring Boot für die Entwicklung der REST-APIs.
- **Kommunikation:** REST über HTTP.
- **Datenbanken:**
    - Microservice 1: Datenbank für Ortschaften.
    - Microservice 2: Datenbank für Immobilien.
- **Fehlermeldungen:** Einheitliches JSON-Format mit Codes wie `{"error": "INVALID_INPUT", "message": "Name ist erforderlich"}`.

## **Containerisierung und Deployment**
---
- **Docker:** Jeder Microservice wird als eigenständiger Container betrieben.
- **Pipeline:** Automatisierte Tests und Bereitstellung über eine CI/CD-Pipeline.

## **Tests**
---
### **CI:**
- **Automatisierte Builds:**
    - Beide Mikroservices sollten bei jedem Commit automatisch gebaut werden, um sicherzustellen, dass der Code in einem kompilierbaren Zustand ist.
- **Automatisierte Tests:**
    - **Unit Tests:** Validierung der Geschäftslogik (z. B. Validierung der Eingaben in den Mikroservices).
    - **Integrationstests:** Sicherstellen, dass die Kommunikation zwischen den Mikroservices funktioniert (z. B. Ortschaften-Validierung aus Mikroservice 2).
- **Deployment-Vorbereitung:**
    - Artefakte (z. B. Docker-Images) erstellen und für das Deployment in einer Registry (z. B. Docker Hub) speichern.
- **Szenarien:**
    - Datenüberprüfung zwischen den Services.
    - End-to-End-Validierung von Nutzeraktionen.

## **Projektmanagement**
---
### **Ordnerstruktur**

- **Backend:** Microservices.
- **Shared:** Gemeinsame Ressourcen.
//TODO