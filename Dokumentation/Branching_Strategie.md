## Branching Strategy 
Wir befolgen den Git-Flow strategie, weil wir die branches main, dev, feature und hotfix verwenden. 

- ### Main (Haupt-Branch):
  - Enthält die produktionsbereite Version der Anwendung. Alle Releases werden von diesem Branch getaggt.
  - Änderungen in den main-Branch erfolgen nur durch das Mergen von **release-** oder **hotfix-Branches**.
- ### Dev (Entwicklungs-Branch):
  - Dient als Integrationszweig für alle neuen Features.
- ### Der dev-Branch repräsentiert den aktuellen Stand der Entwicklung und wird regelmäßig in einem CI-Prozess getestet.
- ### Feature Branches:
  - Werden vom dev-Branch abgezweigt und dienen der Entwicklung neuer Features.
  - Sobald das Feature fertig ist und getestet wurde, wird es in den dev-Branch gemerged.
        Benennung: feature/<ticket-id>-<beschreibung>
        Beispiel: feature/4-d2-branchingStrategy
- ### Hotfix Branches:
  - Werden direkt vom main-Branch erstellt, wenn ein kritischer Bug in der Produktionsversion behoben werden muss.
        Benennung: hotfix/hotfix-name.

## Versionierung
Wir befolgen den semantic Versionierung durch das Schema **MAJOR.MINOR.PATCH**.

- Version 1.2.3:
  - **1**: Major (Grosse Änderungen)
  - **2**: Minor (neue Features)
  - **3**: Patch (Fehlerbehebungen)

## Commit-Messages
   Wir verwenden **Conventional Commits** für verständliche und maschinenlesbare Nachrichten:
   - `fix:` für Fehlerbehebungen.
   - `feat:` für neue Features.

    Zeitform: Befehlsform