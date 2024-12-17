### Continuous Deployment

**1. Was ist Continuous Deployment und wie wird es umgesetzt?**

Continuous Deployment (CD) ist eine Methode in der Softwareentwicklung, bei der Änderungen am Code automatisch nach dem erfolgreichen Bestehen von Tests in die Produktionsumgebung ausgerollt werden. Der Hauptzweck besteht darin, Softwareänderungen schnell, zuverlässig und kontinuierlich für Endbenutzer verfügbar zu machen.



*Umsetzung von Continuous Deployment:*

**Automatisierte Tests:**  Sicherstellen, dass alle Codeänderungen durch umfassende automatisierte Tests validiert werden, um die Qualität und Stabilität des Codes zu gewährleisten.

**CI/CD-Pipeline:** Implementierung einer Continuous Integration/Continuous Deployment-Pipeline, die den gesamten Prozess von der Code-Integration bis zur Bereitstellung automatisiert.

**Monitoring:** Etablierung von Überwachungsmechanismen, um die Leistung und Zuverlässigkeit der Anwendung nach dem Deployment zu überprüfen.

In unserem Projekt versionieren wir unseren Code auf Github, schreiben Unit Tests, setzen unsere Deployment Umgebung auf mit Docker und benutzen Github Actions für die Automatisierung. 

Quelle: https://mindsquare.de/knowhow/continuous-deployment

**2. Was ist der Unterschied zwischen Continuous Deployment und Continuous Delivery?**

- **Continuous Delivery:** Hierbei werden Codeänderungen automatisch gebaut, getestet und in eine Staging-Umgebung bereitgestellt. Die Entscheidung, wann diese Änderungen in die Produktionsumgebung überführt werden, erfolgt manuell. Dies ermöglicht zusätzliche Überprüfungen oder manuelle Freigaben vor dem Live-Gang. 


- **Continuous Deployment:** In diesem Ansatz werden Codeänderungen nach erfolgreichen automatisierten Tests ohne manuelle Eingriffe direkt in die Produktionsumgebung ausgerollt. Dies erfordert ein hohes Maß an Automatisierung und Vertrauen in die Qualität der Tests. 

Quelle: https://www.jetbrains.com/de-de/teamcity/ci-cd-guide/continuous-integration-vs-delivery-vs-deployment

**3. Was sind die Vor- und Nachteile von Continuous Delivery und Continuous Deployment?**

**Continuous Delivery**

*Vorteile*

- Flexibilität: Änderungen werden in einer Staging-Umgebung bereitgestellt, und das Team hat die Kontrolle über den Zeitpunkt des Produktionsreleases. 

- Risikominimierung: Manuelle Freigaben ermöglichen zusätzliche Überprüfungen, um Fehler in der Produktionsumgebung zu vermeiden.

*Nachteile*

- Verlangsamter Prozess: Das manuelle Freigabesystem kann zu Verzögerungen führen. 
- Zusätzliche Ressourcen: Erfordert dedizierte Ressourcen für Freigabe- und Staging-Management. 


**Continuous Deployment**

*Vorteile*

- Schnelligkeit: Jede Änderung wird automatisch und unmittelbar nach Bestehen der Tests in die Produktionsumgebung gebracht. 
- Automatisierung: Reduziert den manuellen Aufwand und beschleunigt die Iterationen. 

*Nachteile*

- Höheres Risiko: Fehler können schneller in die Produktionsumgebung gelangen, wenn die Tests nicht umfassend genug sind.
- Abhängigkeit von Tests: Die Qualität der Automatisierungstests bestimmt direkt die Stabilität der Produktion. 

Quelle: https://www.jetbrains.com/de-de/teamcity/ci-cd-guide/continuous-integration-vs-delivery-vs-deployment

**4. Was sind die folgenden Deployment Strategien und wie werden sie umgesetzt?**

*Blue/Green Deployment*
  
Es werden zwei identische Produktionsumgebungen betrieben – "Blue" (aktuell live) und "Green" (neue Version). Die neue Version wird in der Green-Umgebung bereitgestellt und getestet. Nach erfolgreichem Test wird der Datenverkehr auf die Green-Umgebung umgeschaltet, wodurch die Green-Umgebung zur neuen Live-Umgebung wird. Dies ermöglicht ein schnelles Rollback, indem der Traffic zurück auf die Blue-Umgebung geleitet wird. 

![](/Bilder/BlueGreenDeployment.png)

Bildquelle: https://candost.blog/images/content/posts/blue-green-deployment/BlueGreenDeployment5.png

*Canary Deployment*

Canary Deployment: Neue Softwareversionen werden schrittweise an eine kleine Benutzergruppe ausgerollt. Wenn keine Probleme auftreten, wird die Verteilung schrittweise auf die gesamte Benutzerbasis ausgeweitet. Dies minimiert das Risiko, da potenzielle Fehler nur einen kleinen Teil der Nutzer betreffen. 

![](/Bilder/canary.png)

Bildquelle: https://cdn.prod.website-files.com/5c9200c49b1194323aff7304/66b5cb5eb11a27792da63da7_63074d50cbaa553b731d81d6_Canary_Diagram-2.png

Quelle: https://harness.io/blog/blue-green-canary-deployment-strategies



**5. Was ist A/B Testing?**

A/B-Testing, auch bekannt als Split-Testing, ist eine Methode, bei der zwei Versionen einer Anwendung oder Funktion miteinander verglichen werden, um festzustellen, welche besser performt oder von den Nutzern bevorzugt wird. Dies wird erreicht, indem verschiedene Benutzergruppen unterschiedlichen Versionen ausgesetzt werden und deren Interaktionen analysiert werden.



Quelle: https://en.wikipedia.org/wiki/A/B_testing

**6. Was sind Feature Toggles?**

Feature Toggles sind Techniken, bei denen bestimmte Funktionen im Code durch Konfigurationsschalter aktiviert oder deaktiviert werden können. Dies ermöglicht es, unfertige Features im Code zu behalten, ohne sie den Endnutzern zugänglich zu machen, und erleichtert das Testen und schrittweise Ausrollen von Funktionen.

Quelle: https://en.wikipedia.org/wiki/Feature_toggle

**7. Was sind Rollback Strategien?**

Rollback-Strategien sind Methoden, um bei Problemen nach einem Deployment schnell auf eine vorherige stabile Version zurückzukehren. Dies kann durch Techniken wie Blue/Green Deployment oder durch das Bereithalten von Backups erreicht werden.

Quelle: https://appmaster.io/de/glossary/rollback-strategie-fur-die-bereitstellung

**8. Was ist Continous Monitoring?**

Continuous Monitoring (kontinuierliche Überwachung) ist ein Ansatz, bei dem Organisationen ihre IT-Systeme und Netzwerke fortlaufend überwachen, um Sicherheitsbedrohungen, Leistungsprobleme oder Compliance-Verstösse in Echtzeit zu erkennen. Ziel ist es, potenzielle Probleme frühzeitig zu identifizieren und schnell darauf reagieren zu können. 

Quelle: https://www.crowdstrike.com/de-de/cybersecurity-101/next-gen-siem/continuous-monitoring

*Umsetzung von Continuous Monitoring*

Definition von Überwachungszielen: Festlegung, welche Systeme, Anwendungen und Prozesse überwacht werden sollen, basierend auf organisatorischen Anforderungen und Risiken.

Einsatz automatisierter Tools: Implementierung von Softwarelösungen, die kontinuierlich Daten sammeln und analysieren, um Anomalien oder Verstöße zu erkennen. 

Quelle: https://www.atatus.com/glossary/continuous-monitoring

Echtzeit-Analyse: Verwendung von Technologien, die Daten in Echtzeit auswerten, um sofortige Einblicke in den Zustand der IT-Infrastruktur zu erhalten. 

Quelle: https://www.splunk.com/en_us/blog/learn/continuous-monitoring.html

**9. Wie werden Passwörter sicher gespeichert?**

Die sichere Speicherung von Passwörtern ist ein essenzieller Bestandteil moderner IT-Sicherheit. Passwörter im Klartext zu speichern, ist ein schwerwiegender Fehler, der bei einem Datenbankleck dazu führt, dass Angreifer sofort Zugriff auf sensible Konten erhalten. Daher ist es wichtig, Passwörter so zu schützen, dass sie selbst im Falle eines Datenbankangriffs unbrauchbar sind.

Ein bewährter Ansatz ist die Verwendung von Hashing. Hashing ist eine Einwegfunktion, die ein Passwort in eine scheinbar zufällige Zeichenfolge umwandelt. Dabei wird nur der Hashwert gespeichert, niemals das eigentliche Passwort. Sollte ein Nutzer später sein Passwort eingeben, wird es erneut gehasht und mit dem gespeicherten Wert verglichen. Neben dem Hashing wird das sogenannte Salting eingesetzt. Ein Salt ist eine zufällig generierte Zeichenfolge, die jedem Passwort hinzugefügt wird, bevor es gehasht wird. Dadurch wird verhindert, dass Angreifer vorgefertigte Tabellen von Hashwerten (sogenannte Rainbow Tables) nutzen können, um Passwörter zurückzurechnen. Selbst wenn zwei Nutzer dasselbe Passwort wählen, erzeugt der individuelle Salt unterschiedliche Hashes, was die Sicherheit weiter erhöht.

Zusätzlich kann ein Pepper verwendet werden. Ein Pepper ist ein geheimer globaler Schlüssel, der ebenfalls zum Passwort hinzugefügt wird, bevor es gehasht wird. Im Gegensatz zum Salt wird der Pepper nicht in der Datenbank gespeichert, sondern an einem sicheren Ort, wie z. B. in einem Hardware-Sicherheitsmodul. Dies bietet zusätzlichen Schutz, falls die Datenbank kompromittiert wird.

