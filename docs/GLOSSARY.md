# Fitora — Glossario

| Termine | Definizione nel contesto Fitora |
|---|---|
| Fitora | Piattaforma gestionale multi-tenant per palestre e centri fitness. |
| Tenant | Organizzazione/struttura i cui dati sono logicamente isolati dagli altri clienti della piattaforma; nel progetto corrisponde a una palestra o, se deciso in futuro, a un'organizzazione con più sedi. |
| Gym | Palestra registrata in Fitora. |
| Super Admin | Ruolo con responsabilità di amministrazione globale della piattaforma. |
| Gym Admin | Ruolo che amministra una specifica palestra. |
| Instructor | Istruttore associato a una palestra e coinvolto nella gestione/conduzione delle lezioni. |
| Member | Iscritto alla palestra che utilizza le funzioni riservate agli utenti finali. |
| Course | Tipologia di attività o corso offerto dalla palestra (es. yoga, spinning). Da distinguere dalla singola lezione in calendario. |
| Lesson / Session | Singola occorrenza programmata di un corso, con data, orario, istruttore e capienza. La terminologia definitiva sarà uniformata nel modello dati e nell'interfaccia. |
| Calendar | Vista delle lezioni programmate e disponibili. |
| Booking | Prenotazione effettuata da un iscritto per una specifica lezione. |
| Cancellation deadline | Termine entro il quale è consentito annullare una prenotazione senza applicare la regola di consumo tardivo. La finestra ipotizzata è di 24 ore prima dell'inizio. |
| Waiting list | Elenco degli iscritti in attesa di un posto che si libera in una lezione piena. |
| Attendance | Registrazione dell'esito della partecipazione: presente o assente. Non coincide necessariamente con il consumo di un ingresso/lezione. |
| Membership plan | Tipologia di abbonamento configurata dalla palestra. |
| Member subscription | Abbonamento concreto assegnato a un iscritto, basato su una tipologia/piano. |
| Consumption | Diminuzione del numero di ingressi o lezioni disponibili, quando il piano e le regole prevedono un contatore. |
| Multi-tenant | Architettura in cui più palestre utilizzano la stessa piattaforma mantenendo isolati i rispettivi dati e permessi. |
| Gem Space Mini App | Applicazione eseguita all'interno dell'ecosistema Gem Space e integrata tramite il relativo Bridge SDK. |
| Bridge SDK | Libreria `@gemspace/gem-bridge-sdk` utilizzata dal frontend per comunicare con l'ambiente Gem Space. |
| JWT | JSON Web Token; nel contesto dell'integrazione, il README dello SDK descrive un token firmato e a breve durata rilasciato da Gem Space e da verificare sul backend. |
| MVP | Minimum Viable Product: prima versione con il set minimo di funzionalità necessario per dimostrare il valore principale del prodotto. |
| PRD | Product Requirements Document: documento che descrive requisiti, regole e criteri del prodotto. |
| User Flow | Sequenza di passaggi che un utente compie per completare un'operazione. |
| Wireframe | Rappresentazione schematica di una schermata, concentrata su struttura e contenuti piuttosto che sullo stile grafico. |
