# Fitora — Product Requirements Document (PRD)

| Campo | Valore |
|---|---|
| Versione | 0.1 — Draft |
| Data | 17 novembre 2026 |
| Stato | Bozza: requisiti e regole da validare |
| Product owner | Da assegnare |
| Piattaforma | Gem Space Mini App (integrazione da validare) |

> **Nota sullo stato dei requisiti:** il documento distingue le decisioni già espresse durante la discovery dalle proposte e dai dettagli ancora da definire. Un requisito non va considerato definitivo solo perché è presente in questa bozza.

## 1. Introduzione

Fitora è una piattaforma gestionale multi-tenant per palestre e centri fitness. La palestra utilizza gli strumenti amministrativi; gli iscritti utilizzano una mini-app per consultare e prenotare le attività. La piattaforma deve consentire a più strutture indipendenti di operare nello stesso sistema mantenendo separati i rispettivi dati.

## 2. Obiettivi

- Centralizzare la gestione di palestre, iscritti, istruttori, lezioni, prenotazioni, presenze e abbonamenti.
- Ridurre il lavoro manuale legato alla pianificazione e alla gestione delle lezioni.
- Offrire agli iscritti un modo semplice per consultare il calendario e prenotare.
- Applicare in modo coerente le regole di capienza e cancellazione.
- Mantenere isolati i dati di ogni palestra.

## 3. Utenti e stakeholder

| Attore | Descrizione | Stato |
|---|---|---|
| Super Admin | Gestisce la piattaforma nel suo complesso e le palestre registrate. | Ruolo proposto e accettato come base; permessi da dettagliare. |
| Gym Admin | Gestisce la propria palestra, gli utenti e la configurazione operativa. | Ruolo proposto e accettato come base; permessi da dettagliare. |
| Instructor | Gestisce o conduce le lezioni e partecipa alla gestione delle presenze. | Ruolo proposto e accettato come base; permessi da dettagliare. |
| Member | Iscritto alla palestra, consulta e prenota le lezioni. | Ruolo proposto e accettato come base; permessi da dettagliare. |

Le autorizzazioni dovranno essere contestuali alla palestra. La stessa identità potrebbe, in futuro, avere rapporti differenti con più strutture: il modello dovrà evitare di vincolare necessariamente ogni utente a una sola palestra.

## 4. Ambito del prodotto

### 4.1 Moduli funzionali previsti

1. Gestione delle palestre (tenant).
2. Gestione utenti e ruoli.
3. Gestione istruttori.
4. Gestione corsi e lezioni programmate.
5. Calendario delle lezioni.
6. Prenotazioni, cancellazioni e lista d'attesa.
7. Gestione delle presenze e delle assenze.
8. Definizione delle tipologie di abbonamento e assegnazione agli iscritti.

### 4.2 Fuori dall'ambito iniziale o da valutare

- Check-in tramite QR code.
- Sincronizzazione automatica con il calendario nativo del telefono.
- Pagamenti online, fatturazione e generazione di ricevute.
- Notifiche push o messaggistica, oltre alle capacità effettivamente verificate della piattaforma.
- Analisi avanzate, dashboard e reportistica evoluta.

Queste voci sono candidate per versioni successive; la loro priorità sarà rivalutata dopo la validazione dell'MVP.

## 5. Requisiti funzionali

Le priorità utilizzate sono: **Must** (necessario per il flusso MVP), **Should** (importante, da pianificare), **Could** (facoltativo o successivo). Le priorità sono proposte e dovranno essere confermate durante la definizione dello scope.

### 5.1 Multi-tenancy e gestione palestra

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-TEN-001 | Il sistema deve supportare più palestre indipendenti nella stessa piattaforma. | Must | Decisione confermata. |
| FR-TEN-002 | Il sistema deve associare i dati gestionali alla palestra di appartenenza. | Must | Necessario per l'isolamento dei tenant. |
| FR-TEN-003 | Un utente non autorizzato di una palestra non deve poter leggere o modificare dati di un'altra palestra. | Must | Da tradurre in controlli backend e test. |
| FR-TEN-004 | Il Super Admin deve poter amministrare le palestre registrate. | Should | Perimetro esatto da definire. |

### 5.2 Utenti e ruoli

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-USR-001 | Il sistema deve supportare i ruoli Super Admin, Gym Admin, Instructor e Member. | Must | Ruoli di base concordati; matrice permessi da completare. |
| FR-USR-002 | Il Gym Admin deve poter gestire gli utenti appartenenti alla propria palestra, nei limiti dei permessi assegnati. | Must | Dettagli da definire. |
| FR-USR-003 | Il sistema deve associare un iscritto alla palestra di riferimento. | Must | Il modello deve poter supportare più associazioni per utente, se richiesto. |
| FR-USR-004 | Il sistema deve consentire di consultare e aggiornare i dati di profilo autorizzati. | Should | Campi e responsabilità da definire. |

### 5.3 Corsi, lezioni e istruttori

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-CLS-001 | Un utente autorizzato della palestra deve poter creare e modificare le lezioni. | Must | Ruoli autorizzati da specificare. |
| FR-CLS-002 | Una lezione deve essere associata a una palestra. | Must | Isolamento multi-tenant. |
| FR-CLS-003 | Una lezione deve contenere almeno attività/corso, data, orario, istruttore e capienza massima. | Must | Campi iniziali proposti; eventuali altri campi da definire. |
| FR-CLS-004 | Il sistema deve mostrare agli iscritti le lezioni disponibili della propria palestra. | Must | Canale e filtri da definire. |

### 5.4 Calendario e prenotazioni

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-BKG-001 | L'iscritto deve poter consultare il calendario e selezionare una data. | Must | Decisione confermata. |
| FR-BKG-002 | L'iscritto deve poter prenotare una lezione disponibile tramite un'azione esplicita (es. pulsante “Prenota”). | Must | Decisione confermata. |
| FR-BKG-003 | Il sistema deve impedire prenotazioni oltre la capienza massima della lezione. | Must | Decisione confermata. Implementazione concorrente da progettare. |
| FR-BKG-004 | L'iscritto deve poter annullare una prenotazione fino a 24 ore prima dell'inizio della lezione. | Must | Interpretazione della regola da confermare formalmente. |
| FR-BKG-005 | Oltre il termine di cancellazione, la prenotazione deve essere trattata secondo la regola di consumo/penalità definita dalla palestra. | Must | Intenzione espressa; effetto preciso su abbonamento da definire. |
| FR-BKG-006 | Se un posto si libera, il sistema deve poter consentire l'ingresso a un iscritto in lista d'attesa. | Should | Lista d'attesa richiesta; ordine, promozione e scadenze da definire. |
| FR-BKG-007 | Il sistema deve impedire allo stesso iscritto di creare prenotazioni duplicate per la stessa lezione. | Must | Proposta tecnica da confermare. |
| FR-BKG-008 | Il sistema dovrebbe consentire la sincronizzazione con il calendario personale del dispositivo. | Could | Non inclusa nell'MVP finché la fattibilità nella Mini App non è verificata. |

### 5.5 Presenze e assenze

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-ATT-001 | La palestra deve poter consultare gli iscritti prenotati a una lezione e il relativo stato. | Must | Da dettagliare. |
| FR-ATT-002 | Il sistema deve supportare la registrazione della presenza e dell'assenza. | Must | Modalità e ruolo autorizzato da confermare. |
| FR-ATT-003 | Il sistema deve distinguere la presenza fisica dall'eventuale consumo della lezione dovuto a una cancellazione tardiva o mancata disdetta. | Must | Distinzione necessaria per evitare dati ambigui. |
| FR-ATT-004 | Il check-in tramite QR code potrà essere introdotto in una versione successiva. | Could | Esplicitamente rinviato. |

### 5.6 Abbonamenti

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-MEM-001 | Ogni palestra deve poter definire le proprie tipologie di abbonamento. | Must | Decisione confermata: la palestra sceglie e configura i propri piani. |
| FR-MEM-002 | Il sistema deve consentire di associare un piano a un iscritto. | Must | Funzionalità di base prevista. |
| FR-MEM-003 | Il sistema deve registrare le informazioni essenziali dell'abbonamento assegnato, inclusi almeno piano e periodo di validità, se applicabile. | Must | Campi e regole da definire. |
| FR-MEM-004 | Il sistema deve consentire di verificare lo stato dell'abbonamento dell'iscritto. | Must | Stati possibili da definire. |
| FR-MEM-005 | Il sistema deve supportare piani a durata, a ingressi, a lezioni e/o illimitati. | TBD | Proposta da confermare: non ancora approvata dall'utente. |
| FR-MEM-006 | Il sistema deve aggiornare il residuo di ingressi/lezioni quando una regola di consumo lo prevede. | TBD | Dipende dai tipi di piano e dalle regole di consumo. |
| FR-MEM-007 | Il sistema può supportare sospensioni, rinnovi e proroghe degli abbonamenti. | Could | Da confermare. |
| FR-MEM-008 | Il sistema può gestire pagamenti, fatture o ricevute. | Out of scope / TBD | Non è stata ancora presa una decisione. |

## 6. Regole di business

| ID | Regola | Stato |
|---|---|---|
| BR-001 | Una lezione ha una capienza massima. | Confermata. |
| BR-002 | Le prenotazioni non possono superare la capienza massima. | Confermata. |
| BR-003 | L'iscritto può annullare la prenotazione fino a 24 ore prima dell'inizio della lezione. | Interpretazione da confermare: chiarire la formula esatta della finestra temporale. |
| BR-004 | Se la cancellazione avviene oltre il termine consentito, la lezione può essere conteggiata come utilizzata. | Intenzione espressa; confermare eccezioni e modalità di consumo. |
| BR-005 | La lista d'attesa permette a un iscritto di subentrare quando un posto si libera. | Obiettivo confermato; priorità e automatismi da definire. |
| BR-006 | Ogni palestra definisce le proprie tipologie di abbonamento. | Confermata. |
| BR-007 | I dati di una palestra devono rimanere separati da quelli delle altre. | Confermata come requisito fondamentale del modello multi-tenant. |

## 7. Requisiti non funzionali

I seguenti requisiti sono obiettivi iniziali; i valori misurabili andranno definiti dopo aver chiarito utenti attesi e infrastruttura.

| ID | Requisito | Criterio da definire |
|---|---|---|
| NFR-001 | Sicurezza e autorizzazione server-side. | Modello di autenticazione, sessione, ruoli e test di accesso. |
| NFR-002 | Isolamento dei dati tra tenant. | Test automatici per accessi cross-tenant in lettura e scrittura. |
| NFR-003 | Consistenza delle prenotazioni in caso di richieste concorrenti. | Test concorrenti sull'ultimo posto disponibile. |
| NFR-004 | Usabilità su dispositivi mobili e nel contenitore Gem Space. | Verifica su piattaforme e dimensioni supportate. |
| NFR-005 | Manutenibilità ed estendibilità. | Struttura modulare, convenzioni e test. |
| NFR-006 | Protezione dei dati personali. | Definire dati raccolti, finalità, conservazione, accessi e informativa con adeguata revisione. |
| NFR-007 | Affidabilità e gestione degli errori. | Comportamento in caso di indisponibilità backend/SDK e retry. |

## 8. Autenticazione e integrazione Gem Space

L'integrazione prevista utilizza `@gemspace/gem-bridge-sdk`. Il README del pacchetto fornito per la discovery descrive, tra le altre, queste API:

- `bridge.app.init()` per ottenere informazioni sull'app e sul contesto della piattaforma.
- `bridge.profile.get()` per ottenere il profilo dell'utente Gem Space.
- `bridge.auth.getToken()` per ottenere un JWT firmato e a breve durata.
- `bridge.app.ready()` come chiamata richiesta per comunicare che la mini-app è pronta.

Il token dovrà essere inviato al backend e la sua firma verificata lato server. Il token è a breve durata e il client deve richiederne uno nuovo quando scade. I dettagli esatti di verifica (chiavi, algoritmo, issuer, audience e ulteriori claim attesi) devono essere verificati nella documentazione ufficiale di autenticazione prima dell'implementazione.

L'identità Gem Space dovrà essere collegata a un'identità Fitora e alle relative associazioni con le palestre. Non si deve assumere che l'identificativo Gem Space contenga già il ruolo o il tenant Fitora.

La sincronizzazione del calendario del telefono e le altre capacità native non sono confermate dal README SDK esaminato: vanno verificate separatamente e non sono prerequisiti dell'MVP.

## 9. Criteri di accettazione iniziali dell'MVP

L'MVP potrà essere considerato dimostrabile quando:

1. È possibile configurare almeno una palestra e i relativi utenti autorizzati.
2. Un utente autorizzato può creare una lezione con data, orario, istruttore e capienza.
3. Un iscritto associato alla palestra può visualizzare la lezione e prenotarla.
4. Il sistema impedisce il superamento della capienza anche in presenza di richieste concorrenti.
5. Il sistema applica la finestra di cancellazione concordata.
6. La palestra può consultare prenotazioni e registrare la presenza/assenza con la modalità definita.
7. È possibile creare una tipologia di abbonamento e associarla a un iscritto secondo le regole approvate.
8. I test dimostrano che un tenant non può accedere ai dati di un altro tenant.

Questi criteri dovranno essere aggiornati quando saranno definiti i dettagli ancora aperti.

## 10. Assunzioni, dipendenze e vincoli

- Fitora è progettata come piattaforma multi-tenant.
- Il canale iniziale previsto è una Gem Space Mini App.
- La disponibilità e i limiti dell'SDK e del processo di pubblicazione devono essere verificati attraverso la documentazione ufficiale.
- La sincronizzazione con calendari esterni non è ancora verificata.
- Le regole di abbonamento non sono ancora sufficientemente dettagliate per fissare il modello dati definitivo.
- La gestione dei pagamenti non è stata decisa.

## 11. Questioni aperte da risolvere

1. I piani supportano durata, ingressi, lezioni e illimitato? Quali combinazioni sono ammesse?
2. Gli abbonamenti hanno data di inizio/fine, quantità residua, fasce orarie o restrizioni per attività?
3. Fitora gestisce solo lo stato degli abbonamenti o anche pagamenti, rinnovi e ricevute?
4. Cosa succede esattamente se l'iscritto non disdice entro la scadenza: consumo automatico, penale o gestione manuale?
5. La finestra “24 ore” significa cancellazione consentita fino a 24 ore prima dell'orario di inizio? Ci sono eccezioni decise dalla palestra?
6. La lista d'attesa è FIFO? L'iscritto viene promosso automaticamente oppure riceve una finestra per confermare?
7. Chi registra presenza e assenza: istruttore, Gym Admin o entrambi? La registrazione è manuale per l'MVP?
8. Un iscritto può appartenere a più palestre contemporaneamente?
9. Come vengono invitati o associati gli iscritti alla palestra e collegati al loro account Gem Space?
10. Sono richieste lezioni ricorrenti, corsi con più sessioni o soltanto singole sessioni programmate?
11. Quali statistiche, esportazioni e notifiche sono necessarie nel primo rilascio?
12. Quali sono i limiti e le condizioni di pubblicazione e utilizzo della Mini App Gem Space?

## 12. Cronologia delle revisioni

| Versione | Data | Modifiche |
|---|---|---|
| 0.1 | 17/11/2026 | Prima bozza redatta sulla base della discovery iniziale. |
