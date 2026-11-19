# Fitora — Decisioni e questioni aperte

| Campo | Valore |
|---|---|
| Versione | 0.1 — Draft |
| Data | 17 novembre 2026 |

Questo registro evita di trasformare ipotesi in requisiti senza una decisione esplicita.

## Decisioni prese

| ID | Decisione | Nota |
|---|---|---|
| D-001 | Fitora è una piattaforma gestionale per palestre. | Visione iniziale. |
| D-002 | La piattaforma deve supportare più palestre indipendenti. | Multi-tenant. |
| D-003 | Le palestre gestiscono i propri dati e gli iscritti utilizzano un'interfaccia dedicata. | Separazione tra gestione palestra e area iscritto. |
| D-004 | Ruoli di base: Super Admin, Gym Admin, Instructor, Member. | Permessi di dettaglio ancora da definire. |
| D-005 | L'iscritto può consultare il calendario e prenotare una lezione. | Prenotazione tramite azione esplicita. |
| D-006 | Ogni lezione ha una capienza massima e il sistema non deve permettere di superarla. | La gestione concorrente va progettata e testata. |
| D-007 | È prevista una lista d'attesa per i posti che si liberano. | Regole di priorità e promozione da definire. |
| D-008 | La cancellazione è consentita entro la soglia temporale di 24 ore prima dell'inizio. | Interpretazione da confermare e formalizzare. |
| D-009 | Una cancellazione oltre la soglia può comportare il consumo della lezione. | Effetto esatto e relazione con la presenza da definire. |
| D-010 | Il QR code non è necessario per l'MVP. | Possibile evoluzione futura. |
| D-011 | Ogni palestra deve poter scegliere e configurare le proprie tipologie di abbonamento. | Tipi di piano e regole ancora da definire. |
| D-012 | Il canale applicativo iniziale previsto è Gem Space Mini App. | Requisiti e pubblicazione da verificare. |

## Questioni aperte

| ID | Domanda | Impatto |
|---|---|---|
| Q-001 | Quali tipologie di abbonamento sono supportate: durata, ingressi, lezioni, illimitato o combinazioni? | Modello dati e logica di consumo. |
| Q-002 | Si gestiscono pagamenti, rinnovi, ricevute o soltanto dati e stato dell'abbonamento? | Perimetro e integrazioni. |
| Q-003 | Quali sono i campi e gli stati di un abbonamento assegnato? | Modello dati e interfaccia. |
| Q-004 | Chi può registrare le presenze e con quale modalità? | Ruoli e flusso operativo. |
| Q-005 | La lista d'attesa è FIFO? Il passaggio è automatico o richiede conferma? | Regole di business e notifiche. |
| Q-006 | La mancata disdetta entro 24 ore consuma sempre una lezione? Sono previste eccezioni? | Regole abbonamenti/prenotazioni. |
| Q-007 | Un utente può essere associato a più palestre? | Identità e modello multi-tenant. |
| Q-008 | Come viene associato un account Gem Space a un iscritto Fitora? | Onboarding e autenticazione. |
| Q-009 | La palestra gestisce corsi ricorrenti, lezioni singole o entrambi? | Modello calendario. |
| Q-010 | È richiesta la sincronizzazione con il calendario nativo del telefono? | Fattibilità Mini App e scope. |
| Q-011 | Quali notifiche e report sono indispensabili nel primo rilascio? | Scope e integrazioni. |
| Q-012 | Quali sono i requisiti e i limiti di pubblicazione delle Mini App Gem Space? | Dipendenza esterna e piano di rilascio. |

## Assunzioni da non dare per confermate

- Non è ancora deciso se la gestione delle presenze sarà manuale tramite istruttore, tramite Gym Admin o con più modalità.
- Non è ancora deciso se i pagamenti saranno gestiti da Fitora.
- Non è ancora deciso se gli abbonamenti potranno combinare durata e quantità di ingressi/lezioni.
- Non è ancora verificata la sincronizzazione con il calendario del dispositivo.
- Non sono ancora definiti i dettagli crittografici e di validazione del JWT Gem Space.
