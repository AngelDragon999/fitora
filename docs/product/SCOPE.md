# Fitora — Scope e definizione dell'MVP

| Campo | Valore |
|---|---|
| Versione | 0.4 — Draft aggiornato |
| Data aggiornamento | 25 novembre 2026 |
| Stato | Perimetro aggiornato; validazione cliente ancora necessaria |

## 1. Obiettivo dell'MVP

Dimostrare un flusso operativo minimo completo per una piattaforma multi-tenant: una palestra viene configurata e riceve un Gym Admin; il Gym Admin crea gli iscritti e programma le lezioni; un iscritto autenticato tramite Gem Space consulta il calendario e prenota; il sistema applica capienza, cancellazione e regole di consumo; la lista d'attesa gestisce i posti liberati; il personale autorizzato registra presenza o assenza.

Il multi-tenant deve essere previsto fin dalla prima versione, anche se la prima dimostrazione può utilizzare una sola palestra. L'isolamento dei tenant non può essere rinviato.

## 2. Funzionalità incluse nell'MVP

| Modulo | Funzionalità | Priorità | Stato / Note |
|---|---|---|---|
| Palestra | Provisioning e configurazione di una palestra | Must | Il Super Admin gestisce provisioning, ciclo di vita del tenant e assegnazione del primo Gym Admin; accesso ordinario ai dati operativi escluso. |
| Utenti | Ruoli base e associazioni `GymMembership` | Must | Un'identità può appartenere a più palestre. Baseline RBAC approvata (D-021); nell'MVP la creazione/modifica di corsi e lezioni è riservata al Gym Admin (D-022). Le azioni amministrative puntuali su prenotazioni/lista d'attesa restano TBD (Q-023). |
| Iscritti | Creazione manuale del profilo da parte del Gym Admin | Must | Decisione confermata; link Gem Space da progettare. |
| Autenticazione | Gem Space come unico Identity Provider | Must | Decisione confermata; verifica JWT e linking da completare. |
| Corsi/lezioni | Gestione corsi e programmazione delle lezioni | Must | Campi minimi definiti; ricorrenze da decidere. |
| Calendario | Consultazione delle lezioni per data | Must | Filtri e dettagli UX da progettare. |
| Prenotazioni | Prenotazione esplicita e prevenzione del superamento capienza | Must | Gestire consistenza sotto concorrenza. |
| Cancellazione | Disdetta almeno 24 ore prima senza consumo; disdetta tardiva consentita con consumo del credito sui piani a crediti | Must | Regola approvata. |
| Lista d'attesa | FIFO e offerta al primo iscritto; 30 minuti per confermare | Must | Regola approvata; canale di avviso da definire. |
| Abbonamenti | Piani temporali e a crediti configurabili dalla palestra | Must | Modelli approvati; stati/campi dettagliati da definire. |
| Crediti | Riserva, restituzione e consumo dei crediti | Must | Regole approvate. |
| Presenze | Consultazione e registrazione manuale di presenza/assenza da Instructor autorizzato e Gym Admin | Must | Decisione approvata; audit trail da dettagliare. |
| Sicurezza | Isolamento dei dati e delle autorizzazioni tra palestre | Must | Verificabile tramite test automatici. |

## 3. Non incluso nell'MVP

- Check-in e check-out tramite QR code.
- Sincronizzazione automatica con calendario nativo iOS/Android.
- Pagamenti online, fatture e ricevute (da confermare con il cliente come esclusione definitiva).
- Rinnovi automatici, sospensioni e proroghe degli abbonamenti.
- Invito degli iscritti tramite link: l'MVP prevede creazione manuale da parte del Gym Admin.
- Notifiche push o messaggistica avanzata, finché capacità e limiti della piattaforma Gem Space non siano verificati.
- Dashboard, statistiche e reportistica evoluta.
- App native separate per iOS e Android.
- Configurabilità per singola palestra della finestra di conferma della lista d'attesa: nell'MVP il termine è fisso a 30 minuti.

**Nota:** l'offerta della lista d'attesa deve comunque essere resa visibile all'iscritto in tempo utile. Il canale minimo per farlo è una dipendenza da risolvere; non può essere considerato automaticamente coperto dall'esclusione delle notifiche push.

## 4. Regole MVP confermate

### 4.1 Cancellazione

- Almeno 24 ore prima dell'inizio: cancellazione consentita e credito restituito per i piani a crediti.
- Meno di 24 ore prima: cancellazione consentita, credito consumato per i piani a crediti.
- Il posto viene liberato anche in caso di cancellazione tardiva e può essere proposto alla lista d'attesa.
- L'effetto della cancellazione tardiva sui piani temporali è ancora da definire.

### 4.2 Lista d'attesa

- Ordinamento FIFO.
- Quando si libera un posto, il sistema propone l'offerta al primo iscritto eleggibile.
- L'iscritto ha 30 minuti per confermare.
- Rifiuto o mancata conferma comportano il passaggio al successivo.
- Il credito non viene riservato durante la sola permanenza in lista; viene riservato quando la promozione viene confermata.
- Il canale di avviso deve essere deciso e verificato.

### 4.3 Abbonamenti e crediti

- Piani temporali: accesso senza limite numerico durante il periodo di validità.
- Piani a crediti: numero definito di lezioni utilizzabili entro una scadenza.
- Prenotazione confermata: credito riservato.
- Partecipazione: credito consumato.
- Cancellazione tempestiva: credito restituito.
- Cancellazione tardiva o No-show: credito consumato.
- L'effetto sui piani temporali e il caso di più abbonamenti attivi sono ancora da definire.

### 4.4 Presenze

- Registrazione manuale.
- Possono registrare Instructor autorizzati e Gym Admin della palestra.
- Presenza/assenza non coincide automaticamente con consumo del credito.
- È raccomandata la tracciabilità dell'operatore e del timestamp.

## 5. Dipendenze e condizioni di uscita
1. Validare con il cliente le regole e il perimetro proposto.
2. Implementare e testare la baseline RBAC approvata (D-021) e la regola di programmazione lezioni definita da D-022; risolvere Q-023 prima delle relative funzioni amministrative.
3. Definire il processo operativo di provisioning della palestra e di creazione/assegnazione del primo Gym Admin.
4. Definire la procedura sicura di collegamento identità Gem Space / Fitora.
5. Verificare documentazione ufficiale, JWT e processo di pubblicazione Gem Space.
6. Definire il canale che rende visibile l'offerta della lista d'attesa entro la finestra di 30 minuti.
7. Decidere quale interfaccia utilizzeranno Gym Admin e Instructor per le funzioni amministrative.
8. Decidere se l'MVP gestisce lezioni ricorrenti.
9. Definire stati e dati minimi degli abbonamenti, comportamento dei piani temporali in caso di cancellazione tardiva/No-show e gestione di più abbonamenti attivi.
10. Definire dati anagrafici minimi e ciclo di vita di `GymMembership`.
11. Eseguire test di isolamento multi-tenant, concorrenza sulla capienza e concorrenza sui crediti.

### 5.1 Baseline RBAC approvata

- Super Admin: gestione globale del ciclo di vita dei tenant, provisioning e assegnazione del primo Gym Admin; nessun accesso ordinario ai dati operativi delle palestre.
- Gym Admin: amministrazione della propria palestra.
- Instructor: consultazione delle lezioni assegnate e registrazione delle presenze autorizzate; non può creare o modificare corsi o lezioni nell'MVP (D-022).
- Member: consultazione delle informazioni pubblicate, gestione delle proprie prenotazioni e della propria posizione in lista d'attesa, consultazione del proprio abbonamento.
- Tutti i permessi tenant-scoped devono essere verificati dal backend.

## 6. Evoluzioni successive

Possibili evoluzioni, da ordinare sulla base dei feedback delle palestre:

- QR code per check-in/check-out.
- Calendario personale e integrazione con calendari esterni, se supportata dal contesto Mini App.
- Inviti tramite link e procedure self-service di onboarding.
- Notifiche push e messaggistica, se supportate e approvate.
- Finestra lista d'attesa configurabile per palestra.
- Pagamenti, fatture, ricevute e rinnovi online.
- Sospensioni e proroghe degli abbonamenti.
- Reportistica e statistiche per la palestra.
- Gestione avanzata di più sedi e ulteriori funzioni per istruttori.

## 7. Cronologia delle revisioni

| Versione | Data | Modifiche |
|---|---|---|
| 0.3 | 25/11/2026 | Perimetro MVP aggiornato sulla base della discovery e baseline RBAC D-021. |
| 0.4 | 25/11/2026 | Confermata D-022: solo Gym Admin crea/modifica corsi e lezioni nell'MVP; Instructor consulta lezioni assegnate e registra presenze autorizzate. |
