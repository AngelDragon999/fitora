# Fitora — Scope e definizione dell'MVP

| Campo | Valore |
|---|---|
| Versione | 0.1 — Draft |
| Data | 17 novembre 2026 |
| Stato | Da validare |

## 1. Obiettivo dell'MVP

Dimostrare un flusso minimo completo per una piattaforma multi-tenant: una palestra configura la propria struttura e una lezione; un iscritto consulta il calendario e prenota; il sistema applica le regole di capienza e cancellazione; la palestra consulta le prenotazioni e registra l'esito della partecipazione.

Il multi-tenant deve essere previsto fin dalla prima versione, anche se la prima dimostrazione può utilizzare una sola palestra.

## 2. Funzionalità candidate per l'MVP

| Modulo | Funzionalità | Priorità proposta | Note |
|---|---|---|---|
| Palestra | Creazione/configurazione di una palestra | Must | Il provisioning globale e il flusso di onboarding vanno definiti. |
| Utenti | Associazione di utenti e ruoli a una palestra | Must | Matrice permessi da definire. |
| Lezioni | Creazione e modifica delle lezioni | Must | Data, orario, istruttore e capienza. |
| Calendario | Consultazione delle lezioni per data | Must | UI e filtri da progettare. |
| Prenotazioni | Prenotazione e prevenzione dei duplicati | Must | Verificare consistenza sotto concorrenza. |
| Capienza | Blocco quando i posti sono esauriti | Must | Regola confermata. |
| Cancellazione | Disdetta entro la finestra di 24 ore | Must | Interpretazione e conseguenze da confermare. |
| Lista d'attesa | Gestione dei posti liberati | Should | L'utente l'ha richiesta; automatismi e ordine da definire. |
| Presenze | Consultazione e registrazione di presenza/assenza | Must | Modalità manuale e ruolo responsabile da confermare. |
| Abbonamenti | Creazione di piani da parte della palestra e assegnazione agli iscritti | Must | Modelli di piano e consumo ancora da definire. |
| Sicurezza | Isolamento dei dati tra palestre | Must | Deve essere verificabile tramite test. |
| Gem Space | Avvio Mini App e autenticazione integrata | Must per rilascio su Gem Space | Verificare documentazione completa e prerequisiti. |

## 3. Non incluso nell'MVP

- Check-in e check-out tramite QR code.
- Sincronizzazione automatica con calendario nativo iOS/Android.
- Pagamenti online, fatture e ricevute.
- Gestione avanzata di rinnovi, sospensioni e proroghe, finché le regole non sono definite.
- Notifiche avanzate e campagne di comunicazione.
- Dashboard e analisi evolute.
- App native separate per iOS e Android: il canale iniziale previsto è la Gem Space Mini App.

## 4. Dipendenze e condizioni di uscita

Prima di dichiarare pronto l'MVP occorre:

1. Validare i dettagli di autenticazione Gem Space e il processo di pubblicazione.
2. Definire la matrice dei permessi.
3. Definire le regole di cancellazione e consumo della lezione.
4. Definire il comportamento della lista d'attesa.
5. Definire i campi e le tipologie minime degli abbonamenti.
6. Definire chi e come registra presenza e assenza.
7. Eseguire test di isolamento multi-tenant e concorrenza nelle prenotazioni.

## 5. Evoluzioni successive

Possibili evoluzioni, da ordinare sulla base dei feedback delle palestre:

- QR code per check-in/check-out.
- Calendario personale e integrazione con calendari esterni, se supportata dal contesto Mini App.
- Notifiche su prenotazioni, cancellazioni e lista d'attesa.
- Pagamenti e rinnovi online.
- Sospensioni e proroghe degli abbonamenti.
- Reportistica e statistiche per la palestra.
- Funzioni aggiuntive per istruttori e gestione di più sedi.
