# Fitora — Product Vision

| Campo | Valore |
|---|---|
| Prodotto | Fitora (codename temporaneo) |
| Versione documento | 0.2 — Draft aggiornato |
| Data aggiornamento | 25 novembre 2026 |
| Stato | Visione aggiornata; da validare con una palestra cliente |
| Tipologia | Piattaforma gestionale multi-tenant per palestre |
| Canale iniziale previsto | Gem Space Mini App |

> **Nota sul nome:** Fitora è il nome di lavoro del progetto. Il nome commerciale definitivo non è ancora stato approvato.

## 1. Visione

Fitora è una piattaforma digitale pensata per aiutare palestre e centri fitness a organizzare in un unico ambiente le attività quotidiane: iscritti, istruttori, corsi, lezioni, calendario, prenotazioni, presenze e abbonamenti.

La palestra utilizza gli strumenti amministrativi per configurare la propria attività e gestire gli iscritti. Gli iscritti utilizzano un'interfaccia dedicata, inizialmente una Gem Space Mini App, per consultare le lezioni disponibili, prenotare o disdire una sessione e visualizzare le informazioni che la palestra mette a loro disposizione.

La piattaforma è concepita per essere utilizzata da più palestre indipendenti. Ogni palestra gestisce i propri dati e i propri utenti senza poter accedere ai dati appartenenti alle altre strutture. Una stessa identità Fitora può essere associata a più palestre tramite relazioni distinte.

## 2. Problema da affrontare

Le palestre hanno la necessità di coordinare più attività e informazioni: programmazione delle lezioni, capienza, prenotazioni, iscritti, presenze e condizioni degli abbonamenti. Fitora intende centralizzare questi processi e rendere più semplice la collaborazione tra la struttura, gli istruttori e gli iscritti.

Questa descrizione è una prima ipotesi di problema, da verificare con una palestra utilizzatrice durante la fase di discovery.

## 3. Destinatari

- Palestre e centri fitness che adottano la piattaforma.
- Super Admin responsabili dell'amministrazione globale della piattaforma.
- Gym Admin e personale incaricato della gestione della singola palestra.
- Instructor che conducono le lezioni e registrano le presenze.
- Member che consultano il calendario e prenotano le attività.

## 4. Obiettivi del prodotto

1. Centralizzare le informazioni operative della palestra.
2. Consentire la gestione di corsi, lezioni e relativo calendario.
3. Consentire agli iscritti di prenotare e disdire le lezioni secondo regole definite.
4. Gestire capienza, lista d'attesa e conferma dei posti liberati.
5. Supportare la registrazione manuale delle presenze e delle assenze.
6. Consentire a ogni palestra di definire le proprie tipologie di abbonamento e associarle agli iscritti.
7. Gestire abbonamenti temporali e abbonamenti a crediti.
8. Garantire l'isolamento dei dati e delle autorizzazioni tra palestre differenti.
9. Utilizzare Gem Space come unico Identity Provider per l'autenticazione nell'MVP, mantenendo in Fitora la gestione di ruoli e autorizzazioni.

## 5. Principi guida

- **Semplicità:** le operazioni frequenti devono essere comprensibili e rapide.
- **Isolamento:** i dati di una palestra non devono essere accessibili da un'altra palestra.
- **Sicurezza:** autenticazione e autorizzazioni devono essere verificate dal backend.
- **Tracciabilità:** le operazioni amministrative rilevanti, come la registrazione di una presenza, devono essere riconducibili all'operatore che le ha eseguite.
- **Manutenibilità:** il software deve poter essere modificato ed esteso senza introdurre dipendenze inutili.
- **Evoluzione progressiva:** le funzionalità avanzate saranno introdotte dopo aver validato il flusso essenziale.

## 6. Perimetro iniziale e visione futura

L'MVP è orientato a un flusso operativo completo: una palestra è configurata, il personale crea le lezioni, un iscritto consulta il calendario e prenota, il sistema applica capienza e regole di cancellazione, la lista d'attesa gestisce i posti liberati, e la palestra registra l'esito della partecipazione.

Le funzionalità successive potranno includere check-in tramite QR code, sincronizzazione con calendari personali, inviti tramite link, notifiche push o messaggistica, pagamenti online, rinnovi automatici, sospensioni, reportistica evoluta e gestione avanzata di più sedi. Queste possibilità non fanno parte automaticamente dell'MVP e dovranno essere valutate separatamente.

## 7. Criterio iniziale di successo

La prima versione dovrà dimostrare un flusso completo e verificabile per almeno una palestra, mantenendo già nel modello e nei controlli backend la separazione multi-tenant: gestione di una lezione, consultazione da parte di un iscritto associato, prenotazione entro la capienza, applicazione della regola di cancellazione e del consumo dei crediti, gestione della lista d'attesa e registrazione delle presenze.

Il rilascio su Gem Space richiederà inoltre la verifica dell'autenticazione, del collegamento tra identità Gem Space e identità Fitora e dei prerequisiti di pubblicazione.
