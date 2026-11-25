# Fitora — Product Requirements Document (PRD)

| Campo | Valore |
|---|---|
| Versione | 0.5 — Draft aggiornato |
| Data aggiornamento | 25 novembre 2026 |
| Stato | Requisiti consolidati sulla base della discovery; restano questioni aperte e validazione cliente |
| Product owner | Da assegnare |
| Canale iniziale | Gem Space Mini App |
| Nome prodotto | Fitora è un codename temporaneo |

> **Come leggere questo documento**
>
> - **Confermato:** decisione già presa durante la discovery.
> - **Proposta da validare:** raccomandazione utile a completare la specifica, non ancora approvata.
> - **TBD / Aperto:** informazione o regola che deve essere decisa prima dell'implementazione interessata.
>
> Le scelte tecniche non devono essere dedotte automaticamente dai requisiti. L'architettura e il modello dati saranno definiti nella fase successiva.

## 1. Introduzione

Fitora è una piattaforma gestionale multi-tenant per palestre e centri fitness. La palestra utilizza gli strumenti amministrativi; gli iscritti utilizzano un'interfaccia dedicata, inizialmente una Gem Space Mini App, per consultare e prenotare le attività.

La piattaforma deve consentire a più palestre indipendenti di operare nello stesso sistema mantenendo separati i rispettivi dati e permessi. Una stessa identità utente può essere associata a più palestre tramite associazioni distinte (`GymMembership`).

## 2. Obiettivi

- Centralizzare la gestione di palestre, iscritti, istruttori, corsi, lezioni, prenotazioni, presenze e abbonamenti.
- Ridurre il lavoro manuale legato alla pianificazione e alla gestione delle lezioni.
- Offrire agli iscritti un modo semplice per consultare il calendario e prenotare.
- Applicare in modo coerente le regole di capienza, cancellazione, lista d'attesa e consumo dei crediti.
- Consentire a ciascuna palestra di configurare i propri piani di abbonamento.
- Mantenere isolati i dati e le autorizzazioni di ogni palestra.

## 3. Utenti e stakeholder

| Attore | Descrizione | Stato |
|---|---|---|
| Super Admin | Gestisce la piattaforma nel suo complesso e il ciclo di vita delle palestre. | Ruolo globale confermato: gestisce il ciclo di vita delle palestre e il provisioning; nessun accesso ordinario ai dati operativi delle singole palestre. |
| Gym Admin | Gestisce una specifica palestra, gli utenti e la configurazione operativa. | Ruolo confermato; amministra esclusivamente la propria palestra secondo la matrice RBAC approvata. |
| Instructor | Istruttore associato a una palestra, conduce le lezioni e registra le presenze autorizzate. | Ruolo confermato; consulta le lezioni assegnate e registra le presenze autorizzate. Nell'MVP non crea né modifica corsi o lezioni (D-022). |
| Member | Iscritto a una o più palestre; consulta il calendario e gestisce le proprie prenotazioni. | Ruolo confermato; opera sui propri dati, sulle proprie prenotazioni e sui servizi pubblicati dalle palestre a cui è associato. |

Le autorizzazioni devono essere contestuali alla palestra. I ruoli assegnati a un utente nell'ambito di una palestra non devono attribuire automaticamente gli stessi privilegi presso un'altra palestra. Il ruolo Super Admin è invece globale.

## 4. Ambito del prodotto

### 4.1 Moduli funzionali previsti

1. Gestione delle palestre (tenant).
2. Gestione identità, associazioni `GymMembership` e ruoli.
3. Gestione degli iscritti e degli istruttori.
4. Gestione dei corsi e delle lezioni programmate.
5. Calendario delle lezioni.
6. Prenotazioni, cancellazioni e lista d'attesa.
7. Gestione delle presenze e delle assenze.
8. Definizione dei piani di abbonamento e assegnazione degli abbonamenti agli iscritti.
9. Autenticazione tramite Gem Space e autorizzazione applicativa Fitora.

### 4.2 Fuori dall'ambito dell'MVP

- Check-in e check-out tramite QR code.
- Sincronizzazione automatica con il calendario nativo del telefono.
- Pagamenti online, gestione transazioni, fatture e ricevute.
- Rinnovi automatici, sospensioni e proroghe degli abbonamenti.
- Inviti agli iscritti tramite link, salvo diversa decisione successiva.
- Notifiche push, campagne e messaggistica avanzata, finché capacità e integrazioni non siano verificate.
- Analisi avanzate, dashboard e reportistica evoluta.
- App native separate per iOS e Android: il canale iniziale previsto è la Gem Space Mini App.

La lista d'attesa richiede comunque che l'offerta del posto e la relativa scadenza siano visibili all'iscritto. Il canale concreto di avviso (ad esempio notifica in-app, push o altro canale supportato) è ancora da definire e costituisce una dipendenza da risolvere prima del rilascio.

## 5. Requisiti funzionali

Le priorità sono:
- **Must:** necessario per il flusso MVP.
- **Should:** importante, da pianificare se compatibile con tempi e dipendenze.
- **Could:** possibile evoluzione.
- **Out of scope:** escluso dall'MVP.

### 5.1 Multi-tenancy e gestione palestra

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-TEN-001 | Il sistema deve supportare più palestre indipendenti nella stessa piattaforma. | Must | Confermato. |
| FR-TEN-002 | I dati gestionali devono essere associati alla palestra di appartenenza. | Must | Confermato. |
| FR-TEN-003 | Un utente di una palestra non deve poter leggere o modificare dati di un'altra palestra senza un'autorizzazione globale esplicita. | Must | Confermato; da tradurre in controlli backend e test. |
| FR-TEN-004 | Il Super Admin deve poter gestire il ciclo di vita delle palestre registrate. | Must | Direzione funzionale; operazioni e processo di provisioning da validare. |
| FR-TEN-005 | Il sistema deve consentire di associare una stessa identità a più palestre tramite `GymMembership` distinte. | Must | Confermato. |

### 5.2 Utenti, associazioni e ruoli

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-USR-001 | Il sistema deve supportare i ruoli Super Admin, Gym Admin, Instructor e Member. | Must | Ruoli base confermati. |
| FR-USR-002 | Il Gym Admin deve poter gestire gli iscritti della propria palestra entro i permessi assegnati. | Must | Confermato per la registrazione manuale degli iscritti; operazioni ulteriori da dettagliare. |
| FR-USR-003 | Un'identità utente deve poter avere una o più associazioni `GymMembership`, ciascuna con ruolo e stato nel contesto della relativa palestra. | Must | Confermato il multi-gym; stati e vincoli puntuali da definire. |
| FR-USR-004 | Il sistema deve consentire la consultazione e l'aggiornamento dei dati di profilo autorizzati. | Must | Campi, titolarità e possibilità di modifica da definire; applicare minimizzazione dei dati. |
| FR-USR-005 | Il Gym Admin deve poter creare manualmente un profilo Member nella propria palestra. | Must | Confermato per l'MVP. |
| FR-USR-006 | Il sistema deve collegare il profilo Fitora creato dal Gym Admin all'identità Gem Space dell'iscritto. | Must | Obiettivo confermato; procedura sicura di associazione ancora TBD. |

#### 5.2.1 Matrice RBAC — baseline approvata per l'MVP

La seguente matrice è stata approvata come baseline funzionale per l'MVP. I permessi sono applicati lato backend e, salvo il Super Admin, sono sempre circoscritti alla palestra associata tramite `GymMembership`.

| Operazione | Super Admin | Gym Admin | Instructor | Member |
|---|---|---|---|---|
| Creare, attivare, sospendere e gestire il ciclo di vita delle palestre | Sì, globale | No | No | No |
| Eseguire provisioning della palestra e assegnare il primo Gym Admin | Sì, globale | No | No | No |
| Consultare i dati operativi della palestra (iscritti, prenotazioni, abbonamenti) | No, non nell'operatività ordinaria | Sì, propria palestra | Solo le informazioni necessarie alle lezioni assegnate | Solo i propri dati e le informazioni pubblicate |
| Creare/modificare corsi | No | Sì, propria palestra | No nell'MVP | No |
| Creare/modificare lezioni | No | Sì, propria palestra | No nell'MVP | No |
| Gestire iscritti e istruttori | No, salvo gestione dell'account del Gym Admin nell'ambito del provisioning | Sì, propria palestra | No | No; può consultare/aggiornare solo i campi del proprio profilo che saranno autorizzati |
| Creare/modificare piani e assegnare abbonamenti | No | Sì, propria palestra | No | No |
| Consultare e gestire prenotazioni | No | Consulta tutte le prenotazioni della propria palestra; può creare o cancellare prenotazioni per conto di un iscritto, rispettando capienza, idoneità e regole di cancellazione | Consulta le prenotazioni delle lezioni assegnate e le informazioni operative necessarie | Sì, proprie prenotazioni |
| Entrare/uscire dalla lista d'attesa e confermare/rifiutare un'offerta | No | Consulta la lista d'attesa; può aggiungere o rimuovere un iscritto per suo conto, senza modificare l'ordine FIFO né saltare la coda | No | Sì, per sé |
| Registrare presenza/assenza | No | Sì, propria palestra | Sì, per le lezioni autorizzate | No |
| Consultare il proprio abbonamento | No | Sì, per gli iscritti della propria palestra | No | Sì, il proprio |
| Modificare manualmente i crediti per aggirare le regole di consumo | No | No | No | No |

**Confini del Super Admin.** Il Super Admin ha privilegi globali limitati all'amministrazione della piattaforma: gestione del ciclo di vita dei tenant, provisioning e assegnazione del primo Gym Admin. Non dispone di accesso ordinario ai dati personali e operativi delle singole palestre (iscritti, prenotazioni, presenze e abbonamenti). Eventuali accessi eccezionali per assistenza non fanno parte dei permessi ordinari dell'MVP e richiederebbero una policy separata, autorizzazione e tracciamento.

**Confini del Gym Admin.** Il Gym Admin amministra la propria palestra e non può accedere ai dati o alle operazioni di altri tenant.

Il Gym Admin può consultare tutte le prenotazioni e la lista d'attesa della propria palestra; può inoltre creare o cancellare prenotazioni e aggiungere o rimuovere iscritti dalla lista d'attesa per conto dell'iscritto. Queste operazioni devono rispettare le stesse regole di capienza, idoneità dell'abbonamento, cancellazione e FIFO applicate alle operazioni dell'iscritto. L'inserimento manuale in lista d'attesa avviene in coda, in base al momento dell'operazione. Il Gym Admin non può riordinare manualmente la lista, promuovere un iscritto saltando la coda né modificare manualmente i crediti per aggirare le regole di consumo. Ogni intervento amministrativo su prenotazioni o lista d'attesa deve registrare operatore, data/ora, azione e motivazione.

**Confini dell'Instructor.** L'Instructor consulta le lezioni a cui è assegnato e le informazioni necessarie alla conduzione della lezione; può registrare presenza/assenza per le lezioni per cui è autorizzato. Nell'MVP non può creare o modificare corsi né lezioni; queste operazioni sono riservate al Gym Admin (D-022).

**Confini del Member.** Il Member può operare esclusivamente sul proprio profilo, sulle proprie prenotazioni, sulla propria posizione in lista d'attesa e consultare il proprio abbonamento e le informazioni pubblicate dalla palestra.

> **Vincolo di sicurezza:** nessuna schermata o controllo frontend sostituisce l'autorizzazione backend. Il contesto palestra deve derivare da una membership autenticata e autorizzata, non essere accettato ciecamente da un parametro fornito dal client. I controlli devono essere verificati anche con test negativi cross-tenant.

### 5.3 Corsi, lezioni e istruttori

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-CLS-001 | Il Gym Admin deve poter creare e modificare le lezioni della propria palestra. | Must | Nell'MVP la creazione e modifica di corsi e lezioni è riservata al Gym Admin; l'Instructor non dispone di questi permessi (D-022). |
| FR-CLS-002 | Ogni corso e lezione devono essere associati a una palestra. | Must | Confermato dal modello multi-tenant. |
| FR-CLS-003 | Una lezione deve contenere almeno attività/corso, data, orario di inizio e fine o durata, istruttore e capienza massima. | Must | Campi minimi proposti; durata vs orario finale da uniformare nel design. |
| FR-CLS-004 | Il sistema deve mostrare agli iscritti le lezioni pubblicate e disponibili della propria palestra. | Must | Confermato come flusso. |
| FR-CLS-005 | Il sistema dovrebbe supportare la programmazione ricorrente delle lezioni. | TBD | Da decidere se ricorrenza e serie di lezioni sono necessarie nell'MVP; vedi Q-009. |

Distinzione terminologica: un `Course` rappresenta la tipologia di attività (ad esempio yoga); una `Lesson` è una singola occorrenza programmata nel calendario. La gestione delle serie ricorrenti non è ancora confermata.

### 5.4 Calendario, prenotazioni e lista d'attesa

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-BKG-001 | L'iscritto deve poter consultare il calendario e selezionare una data. | Must | Confermato. |
| FR-BKG-002 | L'iscritto deve poter prenotare una lezione disponibile tramite un'azione esplicita. | Must | Confermato. |
| FR-BKG-003 | Il sistema deve impedire prenotazioni oltre la capienza massima, anche in presenza di richieste concorrenti. | Must | Regola confermata; implementazione e test concorrenti da progettare. |
| FR-BKG-004 | L'iscritto deve poter cancellare una prenotazione in qualsiasi momento prima dell'inizio della lezione; il trattamento economico/crediti dipende dalla soglia delle 24 ore. | Must | La cancellazione tardiva è consentita; vedi BR-003/004. |
| FR-BKG-005 | Il sistema deve applicare le regole di consumo dell'abbonamento in caso di cancellazione tardiva o No-show. | Must | Confermato per gli abbonamenti a crediti; effetto sui piani temporali da definire. |
| FR-BKG-006 | Il sistema deve gestire una lista d'attesa FIFO e proporre il posto liberato al primo iscritto in coda. | Must | Confermato per l'MVP. |
| FR-BKG-007 | L'iscritto deve poter confermare o rifiutare l'offerta entro 30 minuti; in assenza di conferma entro il termine, l'offerta scade e il posto viene proposto al successivo. | Must | Confermato per l'MVP; canale di notifica/avviso da definire. |
| FR-BKG-008 | Il sistema dovrebbe impedire allo stesso iscritto di effettuare prenotazioni duplicate per la stessa lezione. | Must | Regola proposta da validare; raccomandata per integrità operativa. |
| FR-BKG-009 | Il sistema potrebbe consentire la sincronizzazione con il calendario personale del dispositivo. | Out of scope | Non inclusa nell'MVP; fattibilità Mini App da verificare per una versione successiva. |
| FR-BKG-010 | Il Gym Admin deve poter consultare tutte le prenotazioni e la lista d'attesa della propria palestra. | Must | Accesso limitato al tenant di appartenenza. |
| FR-BKG-011 | Il Gym Admin deve poter creare o cancellare prenotazioni per conto di un iscritto della propria palestra. | Must | Le operazioni devono rispettare capienza, idoneità dell'abbonamento e regole temporali di cancellazione; è obbligatoria una motivazione. |
| FR-BKG-012 | Il Gym Admin deve poter aggiungere o rimuovere un iscritto dalla lista d'attesa per suo conto. | Must | L'inserimento avviene in coda; non è consentito modificare l'ordine FIFO né saltare la coda. |

Regole operative della lista d'attesa:
- L'ordine è FIFO, basato sul momento di ingresso nella lista.
- Quando si libera un posto, il sistema crea un'offerta per il primo iscritto eleggibile.
- L'offerta deve avere una scadenza di 30 minuti.
- Durante la finestra di conferma il posto è temporaneamente riservato all'iscritto che ha ricevuto l'offerta, così da non poter essere assegnato contemporaneamente a un altro iscritto.
- Se l'iscritto rifiuta o non conferma entro la scadenza, la riserva temporanea viene rilasciata e il sistema passa al successivo.
- Il credito di un abbonamento a crediti non viene riservato per il solo fatto di essere in lista d'attesa; viene riservato quando l'iscritto conferma e la prenotazione diventa effettiva.
- Il sistema deve ricontrollare capienza e idoneità dell'abbonamento nel momento della conferma.

L'ultimo punto è una regola tecnica proposta per evitare che una promozione superi la capienza o utilizzi un abbonamento non più valido; il comportamento preciso in caso di abbonamento non idoneo va validato.

### 5.5 Presenze e assenze

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-ATT-001 | La palestra deve poter consultare l'elenco degli iscritti prenotati a una lezione e il relativo stato. | Must | Previsto. |
| FR-ATT-002 | Il sistema deve consentire la registrazione manuale di presenza e assenza da parte di Instructor autorizzati e Gym Admin della palestra. | Must | Decisione confermata. |
| FR-ATT-003 | Il sistema deve distinguere la presenza fisica dall'eventuale consumo di un credito. | Must | Confermato come requisito di dominio. |
| FR-ATT-004 | Ogni registrazione o modifica di presenza deve conservare almeno l'operatore e la data/ora dell'operazione. | Must | Proposta di audit trail da validare nel dettaglio; raccomandata. |
| FR-ATT-005 | Il check-in tramite QR code potrà essere introdotto in una versione successiva. | Out of scope | Esplicitamente rinviato. |

La presenza fisica e il consumo dell'abbonamento sono concetti distinti. Un No-show può comportare il consumo di un credito anche se l'esito della presenza è "assente".

### 5.6 Abbonamenti

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-MEM-001 | Ogni palestra deve poter definire le proprie tipologie di abbonamento. | Must | Confermato: configurazione indipendente per palestra. |
| FR-MEM-002 | Il sistema deve consentire al Gym Admin di assegnare un piano a un iscritto della propria palestra. | Must | Previsto. |
| FR-MEM-003 | Il sistema deve registrare per ogni abbonamento assegnato almeno il piano di riferimento e il periodo di validità. | Must | Le date sono necessarie per i piani temporali e per eventuali piani a crediti con scadenza. |
| FR-MEM-004 | Il sistema deve consentire di verificare lo stato dell'abbonamento e la sua utilizzabilità al momento della prenotazione. | Must | Stati specifici e regole per scadenza da definire. |
| FR-MEM-005 | Il sistema deve supportare abbonamenti temporali e abbonamenti a crediti. | Must | Decisione confermata per l'MVP. |
| FR-MEM-006 | Per gli abbonamenti a crediti, il sistema deve distinguere crediti disponibili, riservati e consumati. | Must | Decisione confermata. |
| FR-MEM-007 | Il sistema può supportare sospensioni, rinnovi automatici e proroghe. | Out of scope | Rinviati oltre l'MVP. |

Modelli confermati:
- **Temporale:** consente accesso alle lezioni senza un limite numerico durante il periodo di validità. Eventuali restrizioni per corso, fascia oraria o sede sono ancora da definire.
- **A crediti:** mette a disposizione un numero definito di lezioni da utilizzare entro un periodo di validità/scadenza.

Ciclo di vita dei crediti per i piani a crediti:
1. Prenotazione confermata: un credito viene riservato.
2. Partecipazione: il credito riservato diventa consumato.
3. Cancellazione almeno 24 ore prima dell'inizio: il credito riservato viene restituito tra i disponibili.
4. Cancellazione con meno di 24 ore prima dell'inizio: il credito viene consumato.
5. No-show registrato: il credito viene consumato.
6. Semplice ingresso in lista d'attesa: nessun credito viene riservato.
7. Conferma di un'offerta di lista d'attesa: viene riservato un credito, se l'abbonamento è valido e dispone di credito disponibile.

Per i piani temporali non esiste un contatore di crediti. L'effetto della cancellazione tardiva e del No-show su questi piani è ancora da definire: non si deve inventare una detrazione di crediti che il piano non possiede.

Sono inoltre da definire:
- Se un iscritto possa avere più abbonamenti attivi contemporaneamente nella stessa palestra.
- Come viene scelto l'abbonamento da utilizzare se ne esiste più di uno valido.
- Gli stati dell'abbonamento e il comportamento alle date di inizio e scadenza.
- Le eventuali limitazioni per corso, sede o fascia oraria.

### 5.7 Autenticazione e integrazione Gem Space

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-AUTH-001 | Per l'MVP, Gem Space deve essere l'unico Identity Provider utilizzato per autenticare gli utenti. | Must | Decisione confermata. |
| FR-AUTH-002 | Il backend deve verificare la validità e la firma del JWT ricevuto da Gem Space prima di riconoscere l'identità. | Must | Confermato come requisito di sicurezza; dettagli tecnici da verificare su documentazione ufficiale. |
| FR-AUTH-003 | Fitora deve associare l'identità Gem Space a un'identità Fitora e alle relative `GymMembership`. | Must | Obiettivo confermato; procedura di linking ancora aperta. |

Il README dello SDK fornito durante la discovery descrive le seguenti API:
- `bridge.app.init()` per inizializzare/ottenere informazioni sul contesto applicativo, se necessario.
- `bridge.profile.get()` per ottenere il profilo Gem Space, se necessario.
- `bridge.auth.getToken()` per ottenere un JWT firmato e a breve durata.
- `bridge.app.ready()` per comunicare che la Mini App è pronta.

Il token deve essere trasmesso al backend e verificato lato server. Non si devono inventare issuer, audience, algoritmo, claim o URL delle chiavi: questi parametri devono essere ricavati dalla documentazione ufficiale Gem Space prima dell'implementazione.

Per l'MVP non è previsto un login autonomo Fitora con username/password né un secondo Identity Provider.

### 5.8 Notifiche e comunicazioni

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-NOT-001 | Il sistema deve rendere visibile all'iscritto un'offerta di posto proveniente dalla lista d'attesa e la relativa scadenza. | Must | Necessario per il flusso di conferma da 30 minuti; modalità tecnica da definire. |
| FR-NOT-002 | Il sistema può inviare notifiche push o messaggi esterni per prenotazioni, cancellazioni e offerte. | Out of scope / TBD | Non assumere che Gem Space supporti le capacità necessarie; verificare SDK e piattaforma. |

La conferma entro 30 minuti è una regola funzionale approvata, ma non è ancora definito come l'iscritto venga avvisato in tempo utile. Questo è un punto bloccante per la progettazione completa del flusso di lista d'attesa.

### 5.9 Tracciabilità delle operazioni amministrative

| ID | Requisito | Priorità | Stato / Note |
|---|---|---|---|
| FR-AUD-001 | Il sistema deve registrare le operazioni amministrative del Gym Admin su prenotazioni e lista d'attesa. | Must | Registrare almeno operatore, data/ora, azione e motivazione. Accesso e conservazione dei log saranno dettagliati nel design. |

## 6. Regole di business

| ID | Regola | Stato |
|---|---|---|
| BR-001 | Ogni lezione ha una capienza massima. | Confermata. |
| BR-002 | Il numero di prenotazioni effettive non può superare la capienza massima. | Confermata; la consistenza sotto concorrenza deve essere testata. |
| BR-003 | La cancellazione è gratuita rispetto al consumo di crediti se richiesta almeno 24 ore prima dell'inizio della lezione. | Confermata. |
| BR-004 | La cancellazione è consentita anche a meno di 24 ore dall'inizio; per un abbonamento a crediti, il credito prenotato viene consumato. | Confermata. |
| BR-005 | Ogni posto liberato può essere proposto al primo iscritto eleggibile in lista d'attesa, in ordine FIFO. | Confermata. |
| BR-006 | L'offerta della lista d'attesa scade dopo 30 minuti (MVP); in caso di rifiuto o mancata conferma si passa al successivo. | Confermata. |
| BR-007 | Ogni palestra definisce le proprie tipologie di abbonamento. | Confermata. |
| BR-008 | I dati e i permessi di una palestra devono rimanere separati da quelli delle altre. | Confermata. |
| BR-009 | La prenotazione confermata riserva un credito per un abbonamento a crediti. | Confermata. |
| BR-010 | La cancellazione almeno 24 ore prima restituisce il credito riservato. | Confermata. |
| BR-011 | La cancellazione tardiva o il No-show comportano il consumo del credito per un abbonamento a crediti. | Confermata. |
| BR-012 | La partecipazione trasforma il credito riservato in credito consumato. | Confermata. |
| BR-013 | Un semplice inserimento in lista d'attesa non riserva crediti; la riserva avviene alla conferma dell'offerta. | Confermata nel flusso concordato. |
| BR-014 | Instructor autorizzati e Gym Admin possono registrare presenza/assenza nella palestra di appartenenza secondo i rispettivi permessi. | Confermata. |
| BR-015 | La stessa identità può essere associata a più palestre tramite `GymMembership` distinte. | Confermata. |
| BR-016 | Il Gym Admin crea manualmente il profilo dell'iscritto per la propria palestra; il linking con Gem Space avviene con una procedura da definire. | Prima parte confermata; procedura di linking aperta. |
| BR-017 | Gem Space è l'unico Identity Provider dell'MVP; ruoli e autorizzazioni applicative sono gestiti da Fitora. | Confermata. |
| BR-018 | Il Gym Admin può creare o cancellare prenotazioni per conto di un iscritto della propria palestra, applicando le stesse regole di capienza, idoneità e cancellazione previste per l'iscritto. | Confermata (D-023). |
| BR-019 | Il Gym Admin può aggiungere o rimuovere un iscritto dalla lista d'attesa per suo conto; l'inserimento avviene in coda e l'ordine FIFO non può essere alterato manualmente né aggirato con promozioni fuori sequenza. | Confermata (D-023). |
| BR-020 | Le operazioni amministrative su prenotazioni e lista d'attesa devono essere tracciate con operatore, data/ora, azione e motivazione; non è consentito modificare manualmente i crediti per aggirare le regole di consumo. | Confermata (D-023). |

**Precisazione sul posto liberato:** una cancellazione, anche tardiva, libera il posto per una possibile assegnazione alla lista d'attesa. Il consumo del credito dell'iscritto che cancella e la disponibilità fisica del posto sono due aspetti distinti.

**Precisazione sui piani temporali:** BR-004 e BR-011 definiscono il consumo per piani a crediti. L'eventuale penalità o conseguenza per i piani temporali in caso di cancellazione tardiva/No-show è TBD.

## 7. Requisiti non funzionali

I requisiti seguenti sono obiettivi iniziali. I valori quantitativi dovranno essere stabiliti quando saranno noti utenti attesi, infrastruttura e condizioni di rilascio.

| ID | Requisito | Criterio di verifica / Stato |
|---|---|---|
| NFR-001 | Autenticazione e autorizzazione devono essere applicate lato backend. | Test di accesso autenticato/non autenticato e verifica dei ruoli. |
| NFR-002 | Isolamento dei dati tra tenant. | Test automatici di lettura e scrittura cross-tenant. |
| NFR-003 | Consistenza delle prenotazioni sotto concorrenza. | Test concorrenti sull'ultimo posto disponibile e sui crediti residui. |
| NFR-004 | Protezione dei dati personali e minimizzazione. | Inventario dati, finalità, accessi, conservazione e informativa da definire con le parti competenti; non equivale a dichiarazione di conformità legale. |
| NFR-005 | Manutenibilità ed estendibilità. | Struttura modulare, convenzioni condivise e test automatici. |
| NFR-006 | Usabilità su dispositivi mobili nel contenitore Gem Space. | Verifica su dispositivi, viewport e versioni supportate. |
| NFR-007 | Affidabilità e gestione degli errori. | Definire comportamento in caso di indisponibilità backend/SDK, scadenza token e retry. |
| NFR-008 | Tracciabilità delle operazioni sensibili. | Registrazione dell'operatore e timestamp per modifiche rilevanti, con accesso ai log limitato. |
| NFR-009 | Prestazioni adeguate al volume atteso. | Soglie e profilo di carico TBD dopo aver definito il contesto di utilizzo. |

## 8. Criteri di accettazione iniziali dell'MVP

L'MVP potrà essere considerato dimostrabile quando:

1. È possibile predisporre almeno una palestra e un Gym Admin autorizzato.
2. Il Gym Admin può creare un profilo Member e associarlo alla palestra.
3. Un'identità Gem Space autenticata può essere collegata a un'identità Fitora tramite una procedura approvata e sicura.
4. Un utente autorizzato può creare una lezione con corso/attività, data, orario, istruttore e capienza.
5. Un iscritto associato alla palestra può consultare la lezione e prenotarla.
6. Il sistema impedisce il superamento della capienza anche in presenza di richieste concorrenti.
7. Il sistema applica correttamente la soglia delle 24 ore: esattamente 24 ore prima la cancellazione restituisce il credito; sotto le 24 ore il credito viene consumato per i piani a crediti.
8. Una cancellazione libera il posto e attiva il flusso FIFO della lista d'attesa.
9. L'offerta di lista d'attesa scade dopo 30 minuti se non confermata; il sistema passa al successivo.
10. I crediti sono riservati alla prenotazione confermata e restituiti/consumati secondo le regole approvate.
11. Instructor autorizzati e Gym Admin possono registrare presenza/assenza; l'operazione è tracciabile.
12. È possibile configurare e assegnare un piano temporale e un piano a crediti.
13. I test dimostrano che un tenant non può accedere ai dati di un altro tenant.
14. I test verificano che un utente non possa utilizzare più volte lo stesso credito o occupare più posti per la stessa lezione in violazione delle regole approvate.
15. Il Gym Admin può consultare e gestire prenotazioni/lista d'attesa esclusivamente nella propria palestra e per conto degli iscritti secondo D-023.
16. Le operazioni amministrative rispettano capienza, idoneità, regole di cancellazione e ordine FIFO; non è possibile saltare la coda o alterare manualmente i crediti per aggirare le regole.
17. Ogni intervento amministrativo su prenotazioni/lista d'attesa registra operatore, data/ora, azione e motivazione.

I criteri 3 e 8-9 dipendono dalla risoluzione rispettivamente del linking Gem Space e del canale di avviso dell'offerta della lista d'attesa.

## 9. Assunzioni, dipendenze e vincoli

- Fitora è progettata come piattaforma multi-tenant; l'MVP può essere dimostrato inizialmente con una palestra, ma i confini tenant devono essere presenti fin dall'inizio.
- Il canale applicativo iniziale è una Gem Space Mini App.
- Gem Space è l'unico Identity Provider previsto per l'MVP.
- La verifica JWT deve essere implementata sul backend, usando esclusivamente parametri e chiavi documentati ufficialmente.
- L'identità Gem Space deve essere collegata a un'identità Fitora; il metodo è ancora da progettare.
- La sincronizzazione con calendari esterni non è inclusa nell'MVP.
- Pagamenti online, fatture e ricevute sono indicati come fuori ambito nella bozza Scope; la decisione commerciale va confermata con il cliente.
- La configurabilità futura della finestra della lista d'attesa è un'evoluzione; nell'MVP si applicano 30 minuti.
- Il nome Fitora è temporaneo.

## 10. Questioni aperte

Le seguenti questioni non sono state ancora approvate come requisiti definitivi e devono rimanere tracciate nel registro decisionale.

La precedente Q-023 è stata chiusa con D-023: le azioni amministrative del Gym Admin su prenotazioni e lista d'attesa sono definite per l'MVP.

| ID | Questione | Impatto | Quando risolvere |
|---|---|---|---|
| Q-002 | Confermare con il cliente che pagamenti online, fatture e ricevute restino fuori dall'MVP. | Scope, integrazioni, implicazioni amministrative. | Validazione scope. |
| Q-003 | Definire i campi minimi, gli stati e le date di validità dei piani e degli abbonamenti assegnati. | Modello dati e regole di accesso. | Prima del database design. |
| Q-008 | Definire il collegamento sicuro tra il profilo Fitora creato dal Gym Admin e l'identità Gem Space dell'iscritto. | Identity mapping, sicurezza e onboarding. | Prima dell'autenticazione end-to-end. |
| Q-009 | Decidere se l'MVP gestisce solo lezioni singole o anche la creazione di serie ricorrenti. | Modello Course/Lesson, calendario e UX. | Prima del database design. |
| Q-011 | Definire il canale che rende tempestivamente visibile un'offerta di lista d'attesa con scadenza di 30 minuti. | Fattibilità del flusso waiting list e dipendenze Gem Space. | Prima di implementare la waiting list. |
| Q-012 | Verificare requisiti, limiti, documentazione di autenticazione e processo di pubblicazione delle Mini App Gem Space. | Dipendenza esterna, sicurezza e rilascio. | Prima dell'integrazione e pubblicazione. |
| Q-014 | Definire il provisioning della palestra e la creazione/assegnazione del primo Gym Admin. | Onboarding tenant e amministrazione globale. | Prima del flusso di onboarding. |
| Q-015 | Definire l'effetto di cancellazione tardiva e No-show sugli abbonamenti temporali, che non hanno un contatore di crediti. | Regole di business e consistenza degli abbonamenti. | Prima della subscription logic. |
| Q-016 | Definire se un iscritto può avere più abbonamenti attivi nella stessa palestra e quale viene utilizzato per una prenotazione. | Selezione piano, consumo crediti e modello dati. | Prima del database design. |
| Q-017 | Definire se un abbonamento limita attività, corsi, fasce orarie o sedi. | Modello piano e verifica di eleggibilità alla prenotazione. | Prima del database design. |
| Q-018 | Definire i dati anagrafici minimi del Member e chi può modificarli. | Privacy, UX e modello dati. | Prima del database design. |
| Q-019 | Definire gli stati e le regole di attivazione/disattivazione di GymMembership. | Autorizzazioni e ciclo di vita dell'utente. | Prima del database design. |
| Q-020 | Definire i casi in cui il personale può correggere una presenza già registrata e le relative regole di audit. | Tracciabilità e gestione operativa. | Prima del modulo presenze. |
| Q-021 | Definire se l'interfaccia amministrativa per Gym Admin e Instructor sarà una console web separata, la stessa Mini App o un diverso canale. | Architettura frontend, UX, autenticazione e scope. | Prima della progettazione UX/architetturale. |

## 11. Cronologia delle revisioni

| Versione | Data | Modifiche |
|---|---|---|
| 0.1 | 17/11/2026 | Prima bozza della discovery. |
| 0.2 | 25/11/2026 | Consolidate le decisioni su cancellazioni, lista d'attesa, abbonamenti, consumo crediti, presenze, multi-gym, onboarding amministrativo e autenticazione Gem Space; aggiunte proposte RBAC e questioni aperte tracciate. |
| 0.3 | 25/11/2026 | Approvata la baseline RBAC D-021; chiariti i confini del Super Admin e mantenute aperte le decisioni di dettaglio Q-022 e Q-023. |
| 0.4 | 25/11/2026 | Confermato con D-022 che nell'MVP solo il Gym Admin può creare/modificare corsi e lezioni; l'Instructor consulta le lezioni assegnate e registra le presenze autorizzate. |
| 0.5 | 25/11/2026 | Definite con D-023 le azioni amministrative del Gym Admin su prenotazioni e lista d'attesa, i vincoli FIFO e di business e la relativa tracciabilità; chiusa Q-023. |
