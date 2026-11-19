# Fitora — Product Vision

| Campo | Valore |
|---|---|
| Prodotto | Fitora |
| Versione documento | 0.1 — Draft |
| Data | 17 novembre 2026 |
| Stato | Bozza da validare |
| Tipologia | Piattaforma gestionale multi-tenant per palestre |
| Canale previsto | Gem Space Mini App |

## 1. Visione

Fitora è una piattaforma digitale pensata per aiutare palestre e centri fitness a organizzare in un unico ambiente le attività quotidiane: iscritti, istruttori, lezioni, calendario, prenotazioni, presenze e abbonamenti.

Gli iscritti utilizzano un'interfaccia dedicata per consultare le lezioni disponibili, prenotare o disdire una sessione e visualizzare le informazioni che la palestra mette a loro disposizione.

La piattaforma è concepita per essere utilizzata da più palestre indipendenti. Ogni palestra gestisce i propri dati e i propri utenti senza poter accedere ai dati appartenenti alle altre strutture.

## 2. Problema da affrontare

Le palestre hanno la necessità di coordinare più attività e informazioni: programmazione delle lezioni, capienza, prenotazioni, iscritti, presenze e condizioni degli abbonamenti. Fitora intende centralizzare questi processi e rendere più semplice la collaborazione tra la struttura, gli istruttori e gli iscritti.

Questa descrizione è una prima ipotesi di problema, da verificare con una palestra utilizzatrice durante la fase di discovery.

## 3. Destinatari

- Palestre e centri fitness che adottano la piattaforma.
- Amministratori e personale incaricato della gestione.
- Istruttori che organizzano o conducono le lezioni.
- Iscritti che consultano il calendario e prenotano le attività.
- Amministratori globali della piattaforma Fitora.

## 4. Obiettivi del prodotto

1. Centralizzare le informazioni operative della palestra.
2. Consentire la gestione delle lezioni e del relativo calendario.
3. Consentire agli iscritti di prenotare e disdire le lezioni secondo regole definite.
4. Gestire la capienza e l'eventuale lista d'attesa.
5. Supportare la registrazione delle presenze e delle assenze.
6. Consentire a ogni palestra di definire le proprie tipologie di abbonamento e associarle agli iscritti.
7. Garantire l'isolamento dei dati tra palestre differenti.

## 5. Principi guida

- **Semplicità:** le operazioni frequenti devono essere comprensibili e rapide.
- **Isolamento:** i dati di una palestra non devono essere accessibili da un'altra palestra.
- **Sicurezza:** autenticazione e autorizzazioni devono essere verificate dal backend.
- **Manutenibilità:** il software deve poter essere modificato ed esteso senza introdurre dipendenze inutili.
- **Evoluzione progressiva:** le funzionalità avanzate saranno introdotte dopo aver validato il flusso essenziale.

## 6. Visione futura

Dopo il rilascio dell'MVP, Fitora potrà essere estesa con funzionalità quali check-in tramite QR code, sincronizzazione con calendari personali, notifiche, pagamenti online e ulteriori strumenti di amministrazione. Queste possibilità non fanno parte automaticamente dell'MVP e dovranno essere valutate separatamente.

## 7. Criterio iniziale di successo

La prima versione dovrà dimostrare almeno un flusso completo e affidabile: una palestra gestisce una lezione, un iscritto la visualizza e la prenota, il sistema applica la regola di capienza e la palestra può consultare e gestire le informazioni relative alla prenotazione e alla presenza.
