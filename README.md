# Fitora — Documentazione v0.5

Pacchetto documentale aggiornato al 25 novembre 2026.

> Stato: baseline funzionale consolidata sulla base delle decisioni prese durante la discovery. Il documento resta una bozza di prodotto da validare con una palestra cliente; le questioni aperte e le dipendenze sono esplicitate nei documenti.

## Contenuto
- `PRODUCT_VISION.md` — visione e obiettivi del prodotto.
- `PRD.md` — requisiti funzionali e non funzionali, matrice RBAC, regole e criteri di accettazione.
- `SCOPE.md` — perimetro MVP, esclusioni e condizioni di uscita.
- `DECISIONS_AND_OPEN_QUESTIONS.md` — decisioni, questioni aperte e tracciabilità.
- `GLOSSARY.md` — terminologia condivisa.

## Modifiche v0.5
- Aggiunta D-023 e chiusa Q-023.
- Definite le operazioni del Gym Admin su prenotazioni e lista d'attesa: consultazione, creazione/cancellazione per conto degli iscritti e aggiunta/rimozione dalla lista.
- Confermato il rispetto della capienza, dell'idoneità degli abbonamenti, delle regole di cancellazione e dell'ordine FIFO.
- Esclusi riordino manuale della lista, promozione fuori sequenza e modifiche manuali dei crediti volte ad aggirare le regole di consumo.
- Resa obbligatoria la tracciabilità delle operazioni amministrative con operatore, data/ora, azione e motivazione.
- Allineati PRD, Scope, Product Vision e Glossario.

## Cronologia delle versioni documentali
- **v0.1** — Prima bozza della discovery.
- **v0.2** — Consolidate le decisioni iniziali su cancellazioni, lista d'attesa, abbonamenti, consumo crediti, presenze, multi-gym, onboarding e autenticazione; introdotte le proposte RBAC.
- **v0.3** — Approvata la baseline RBAC D-021 e chiariti i confini del Super Admin.
- **v0.4** — Confermato con D-022 che nell'MVP soltanto il Gym Admin crea/modifica corsi e lezioni; l'Instructor consulta le lezioni assegnate e registra presenze autorizzate.
- **v0.5** — Definite con D-023 le operazioni amministrative Gym Admin su prenotazioni e lista d'attesa; chiusa Q-023 e completato l'allineamento documentale.

## Principi di lettura
- Le decisioni indicate come confermate costituiscono la baseline funzionale corrente dell'MVP.
- Le questioni ancora aperte non devono essere implementate come comportamenti definitivi.
- Le decisioni sono soggette a validazione con una palestra cliente.
- I requisiti non determinano automaticamente l'architettura tecnica: questa sarà descritta nella successiva fase di Software Architecture.
