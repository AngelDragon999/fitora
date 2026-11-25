# Fitora — Decisioni e questioni aperte

| Campo | Valore |
|---|---|
| Versione | 0.2 — Draft aggiornato |
| Data aggiornamento | 25 novembre 2026 |
| Scopo | Tracciare decisioni approvate, decisioni provvisorie e questioni ancora aperte |

Questo registro è la fonte di tracciabilità delle decisioni di prodotto. Una proposta presente nel PRD non diventa una decisione confermata finché non viene approvata esplicitamente.

## 1. Decisioni prese

| ID | Decisione | Stato / Nota |
|---|---|---|
| D-001 | Fitora è una piattaforma gestionale per palestre e centri fitness. | Confermata. |
| D-002 | La piattaforma deve supportare più palestre indipendenti. | Confermata; modello multi-tenant. |
| D-003 | Le palestre gestiscono i propri dati e gli iscritti utilizzano un'interfaccia dedicata. | Confermata. |
| D-004 | Ruoli di base: Super Admin, Gym Admin, Instructor e Member. | Confermati; matrice dei permessi ancora da validare. |
| D-005 | L'iscritto può consultare il calendario e prenotare una lezione tramite un'azione esplicita. | Confermata. |
| D-006 | Ogni lezione ha una capienza massima e il sistema non deve permettere di superarla. | Confermata; consistenza sotto concorrenza da progettare e testare. |
| D-007 | È prevista una lista d'attesa per i posti che si liberano. | Confermata. |
| D-008 | La cancellazione senza consumo è consentita fino a 24 ore prima dell'inizio, inclusa la soglia esatta delle 24 ore. | Confermata. |
| D-009 | La cancellazione con meno di 24 ore di anticipo è consentita ma comporta il consumo del credito per gli abbonamenti a crediti. | Confermata; il posto viene comunque liberato. Effetto sui piani temporali TBD. |
| D-010 | Il QR code non è necessario per l'MVP. | Confermata; possibile evoluzione futura. |
| D-011 | Ogni palestra deve poter scegliere e configurare le proprie tipologie di abbonamento. | Confermata. |
| D-012 | Il canale applicativo iniziale previsto è Gem Space Mini App. | Confermata come direzione di prodotto; requisiti e pubblicazione da verificare. |
| D-013 | Fitora è il nome di lavoro/codename temporaneo del progetto. | Confermata come codename; nome commerciale definitivo da decidere. |
| D-014 | La lista d'attesa usa un criterio FIFO; il primo iscritto riceve un'offerta da confermare entro 30 minuti (MVP). | Confermata. In caso di rifiuto o mancata conferma si passa al successivo. La futura configurabilità per palestra è un'evoluzione da valutare. |
| D-015 | L'MVP supporta abbonamenti temporali e abbonamenti a crediti. | Confermata. Temporale: accesso alle lezioni senza limite numerico durante la validità. A crediti: numero definito di lezioni da usare entro una scadenza. |
| D-016 | Per gli abbonamenti a crediti, la prenotazione confermata riserva un credito; la partecipazione lo consuma; la cancellazione tempestiva lo restituisce; la cancellazione tardiva o il No-show lo consumano. | Confermata. Il semplice ingresso in lista d'attesa non riserva crediti. |
| D-017 | Instructor autorizzati e Gym Admin possono registrare manualmente presenza e assenza. | Confermata. L'operazione deve essere contestuale alla palestra e alle autorizzazioni. |
| D-018 | Una stessa identità utente può appartenere contemporaneamente a più palestre tramite `GymMembership` distinte. | Confermata. Ruolo e dati operativi sono contestuali alla singola palestra. |
| D-019 | Per l'MVP il Gym Admin crea manualmente il profilo Member nella propria palestra. | Confermata. L'invito tramite link è rinviato a una versione futura. |
| D-020 | Gem Space è l'unico Identity Provider (IdP) per l'autenticazione nell'MVP. | Confermata. Fitora gestisce internamente ruoli, autorizzazioni e associazioni alle palestre. |

## 2. Questioni aperte

Le domande qui elencate non sono decisioni. Non devono essere codificate come regole definitive prima della loro risoluzione.

| ID | Domanda | Impatto | Priorità |
|---|---|---|---|
| Q-002 | Confermare con il cliente che pagamenti online, fatture e ricevute restino fuori dall'MVP. | Scope e integrazioni. | Media |
| Q-003 | Quali campi minimi, stati e date di validità hanno il piano e l'abbonamento assegnato? | Modello dati e regole di eleggibilità. | Alta |
| Q-008 | Come viene collegato in modo sicuro il profilo Fitora creato dal Gym Admin all'identità Gem Space dell'iscritto? | Identity mapping e sicurezza. | Bloccante per autenticazione end-to-end |
| Q-009 | L'MVP gestisce lezioni singole soltanto oppure anche serie ricorrenti? | Modello Course/Lesson e calendario. | Alta |
| Q-011 | Come viene avvisato tempestivamente l'iscritto dell'offerta di lista d'attesa con scadenza di 30 minuti? | Fattibilità del flusso waiting list. | Bloccante per la waiting list end-to-end |
| Q-012 | Quali sono i requisiti tecnici, i limiti, i claim JWT, le chiavi di verifica e i passaggi di pubblicazione ufficiali di Gem Space? | Autenticazione e rilascio. | Bloccante per integrazione Gem Space |
| Q-013 | La matrice iniziale dei permessi proposta nel PRD è corretta? In particolare, quali operazioni possono eseguire Instructor e Super Admin? | RBAC, API e sicurezza. | Alta |
| Q-014 | Chi crea/provisiona una palestra e come viene creato o assegnato il primo Gym Admin? | Onboarding del tenant. | Alta |
| Q-015 | Qual è l'effetto di una cancellazione tardiva o di un No-show su un abbonamento temporale, che non ha crediti da consumare? | Regole di business. | Alta |
| Q-016 | Un iscritto può avere più abbonamenti attivi nella stessa palestra? Se sì, quale viene usato per prenotare? | Consumo crediti e modello dati. | Alta |
| Q-017 | I piani possono limitare corsi, attività, fasce orarie o sedi? | Eleggibilità e modello dati. | Media |
| Q-018 | Quali dati anagrafici sono obbligatori per un Member e chi può modificarli? | Privacy, UX e modello dati. | Alta |
| Q-019 | Quali stati e regole di attivazione/disattivazione deve avere `GymMembership`? | Autorizzazioni e ciclo di vita. | Alta |
| Q-020 | Chi può correggere una presenza già registrata e con quali motivazioni/tracciamento? | Audit e gestione operativa. | Media |
| Q-021 | L'interfaccia amministrativa per Gym Admin e Instructor sarà una console web separata, la stessa Mini App o un altro canale? | Frontend, UX, architettura e scope. | Alta |

## 3. Questioni chiuse o parzialmente chiuse

| Tema | Esito | Riferimento |
|---|---|---|
| Finestra di cancellazione | Almeno 24 ore: cancellazione senza consumo; meno di 24 ore: cancellazione consentita e credito consumato sui piani a crediti. | D-008, D-009 |
| Lista d'attesa | FIFO, offerta individuale, 30 minuti per confermare, poi passaggio al successivo. | D-007, D-014 |
| Tipologie di abbonamento | Temporale e a crediti. | D-015 |
| Ciclo dei crediti | Disponibile → riservato → consumato; restituzione in caso di cancellazione tempestiva. | D-016 |
| Registrazione presenze | Manuale, effettuabile da Instructor autorizzato e Gym Admin. | D-017 |
| Utente su più palestre | Supportato tramite `GymMembership` distinte. | D-018 |
| Creazione profilo Member | Creazione manuale da parte del Gym Admin; invito via link rinviato. | D-019 |
| Identity Provider | Gem Space unico IdP per l'MVP. | D-020 |
| Metodo di collegamento identità | Non deciso; la questione rimane aperta. | Q-008 |
| Sincronizzazione calendario dispositivo | Non inclusa nell'MVP; fattibilità futura da verificare. | Scope / PRD |
| QR code | Non incluso nell'MVP. | D-010 |

## 4. Assunzioni e proposte da non considerare decisioni

- La matrice dei permessi presente nel PRD è una proposta di lavoro, non una decisione approvata.
- L'uso di un codice temporaneo monouso per collegare l'identità Gem Space al profilo Fitora è soltanto un'ipotesi da valutare; non è stata adottata.
- Non è ancora deciso se gli Instructor possano creare o modificare corsi e lezioni.
- Non è ancora definito il canale di comunicazione per le offerte della lista d'attesa.
- Non è ancora definita la gestione di più abbonamenti attivi per lo stesso iscritto nella stessa palestra.
- I dettagli JWT (issuer, audience, algoritmo, chiavi e claim) devono provenire dalla documentazione ufficiale Gem Space.
- Non sono ancora definiti i dati personali minimi, la conservazione e le regole di cancellazione dei dati.
- Non è ancora deciso se gli operatori della palestra useranno una console web separata o la stessa Mini App degli iscritti.

## 5. Regola di manutenzione del registro

Quando una questione viene risolta:
1. si registra la decisione in una nuova riga D-XXX;
2. si aggiorna il PRD e, quando necessario, lo Scope;
3. si sposta la questione da "Questioni aperte" a "Questioni chiuse o parzialmente chiuse";
4. non si riutilizza l'ID di una decisione o questione già esistente.
