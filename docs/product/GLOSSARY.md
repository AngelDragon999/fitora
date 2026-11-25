# Fitora — Glossario

| Campo | Valore |
|---|---|
| Versione | 0.5 — Draft aggiornato |
| Data aggiornamento | 25 novembre 2026 |

| Termine | Definizione nel contesto Fitora |
|---|---|
| Fitora | Codename temporaneo di una piattaforma gestionale multi-tenant per palestre e centri fitness. Il nome commerciale definitivo è TBD. |
| Tenant | Organizzazione i cui dati sono logicamente isolati da quelli degli altri clienti; nell'MVP corrisponde a una palestra. |
| Gym | Palestra registrata in Fitora e corrispondente tenant dell'MVP. |
| Super Admin | Ruolo globale con responsabilità di amministrazione della piattaforma. |
| Gym Admin | Ruolo che amministra una specifica palestra nel rispetto dei confini tenant. |
| Instructor | Istruttore associato a una palestra e autorizzato a svolgere le operazioni assegnate, inclusa la registrazione delle presenze. |
| Member | Iscritto che utilizza le funzioni riservate agli utenti finali. Una stessa identità può essere associata a più palestre. |
| GymMembership | Associazione tra un'identità Fitora e una palestra. Contiene il contesto di appartenenza e il ruolo dell'utente in quella palestra. |
| Course | Tipologia di attività offerta dalla palestra (ad esempio yoga o spinning), distinta dalla singola occorrenza in calendario. |
| Lesson / Session | Singola occorrenza programmata di un corso, con data, orario, istruttore e capienza. La gestione delle ricorrenze è ancora da decidere. |
| Calendar | Vista delle lezioni programmate e disponibili per una palestra. |
| Booking | Prenotazione effettuata da un iscritto per una specifica lezione. |
| Cancellation deadline | Soglia temporale di 24 ore prima dell'inizio della lezione che distingue cancellazione tempestiva e tardiva. |
| Late cancellation | Cancellazione effettuata con meno di 24 ore di anticipo. È consentita; per un piano a crediti comporta il consumo del credito. |
| No-show | Mancata presentazione dell'iscritto a una lezione prenotata, registrata secondo la procedura operativa. Per un piano a crediti comporta il consumo del credito. |
| Waiting list | Elenco FIFO di iscritti in attesa di un posto che si libera in una lezione piena. |
| Waiting-list offer | Offerta temporanea del posto al primo iscritto eleggibile in lista d'attesa. Nell'MVP deve essere confermata entro 30 minuti. |
| Attendance | Registrazione dell'esito della partecipazione: presente o assente. Non coincide necessariamente con il consumo di un credito. |
| Membership plan | Tipologia di abbonamento configurata da una palestra. |
| Member subscription | Abbonamento concreto assegnato a un iscritto sulla base di un piano. |
| Time-based plan | Abbonamento temporale che consente accesso alle lezioni senza limite numerico durante il periodo di validità. |
| Credit-based plan | Abbonamento che mette a disposizione un numero definito di lezioni/crediti da utilizzare entro una scadenza. |
| Available credit | Credito disponibile e non ancora associato a una prenotazione. |
| Reserved credit | Credito temporaneamente riservato a una prenotazione confermata. |
| Consumed credit | Credito utilizzato a seguito della partecipazione, della cancellazione tardiva o del No-show secondo le regole concordate. |
| Consumption | Diminuzione del numero di crediti disponibili, secondo il ciclo di riserva, restituzione e consumo. |
| Multi-tenant | Architettura in cui più palestre utilizzano la stessa piattaforma mantenendo isolati i rispettivi dati e permessi. |
| RBAC | Role-Based Access Control: modello di autorizzazione basato su ruoli. In Fitora i ruoli devono essere applicati nel contesto della palestra, salvo il ruolo globale Super Admin. |
| Identity Provider (IdP) | Sistema che autentica l'identità dell'utente. Per l'MVP Fitora utilizza Gem Space come unico IdP. |
| Gem Space Mini App | Applicazione eseguita all'interno dell'ecosistema Gem Space e integrata tramite il relativo Bridge SDK. |
| Bridge SDK | Libreria `@gemspace/gem-bridge-sdk` utilizzata dal frontend per comunicare con l'ambiente Gem Space. |
| JWT | JSON Web Token; nel contesto dell'integrazione, lo SDK descrive un token firmato e a breve durata rilasciato da Gem Space e da verificare sul backend. |
| Audit trail | Traccia delle operazioni rilevanti, con informazioni come operatore, data/ora, azione e, quando richiesta, motivazione. |
| Administrative booking action | Operazione del Gym Admin eseguita per conto di un iscritto su prenotazioni o lista d'attesa, soggetta alle regole di business e alla tracciabilità. |
| FIFO | First In, First Out: criterio che assegna priorità in base all'ordine temporale di ingresso nella lista d'attesa. |
| MVP | Minimum Viable Product: prima versione con il set minimo di funzionalità necessario per dimostrare il valore principale del prodotto. |
| PRD | Product Requirements Document: documento che descrive requisiti, regole e criteri del prodotto. |
| User Flow | Sequenza di passaggi che un utente compie per completare un'operazione. |
| Wireframe | Rappresentazione schematica di una schermata, concentrata su struttura e contenuti piuttosto che sullo stile grafico. |
| TBD | To Be Defined: elemento ancora da definire o approvare. |

## Cronologia delle revisioni

| Versione | Data | Modifiche |
|---|---|---|
| 0.5 | 25/11/2026 | Aggiunti i termini relativi alle operazioni amministrative su prenotazioni/lista d'attesa e aggiornato l'audit trail. |
