# Fitora

**Fitora** è una piattaforma gestionale multi-tenant in progettazione, pensata per palestre e centri fitness. Il progetto nasce per centralizzare la gestione di iscritti, istruttori, lezioni, calendario, prenotazioni, presenze e abbonamenti.

> **Stato del progetto:** Product Discovery e definizione requisiti — versione documentale 0.1 (17 novembre 2026). Non è ancora presente un'implementazione applicativa.

## Obiettivo

Realizzare una piattaforma utilizzabile da più palestre indipendenti, con separazione dei dati e dei permessi. Gli operatori della palestra amministrano le attività; gli iscritti consultano il calendario e prenotano le lezioni attraverso un'interfaccia dedicata.

## Funzionalità previste

- Gestione di più palestre (multi-tenancy).
- Gestione di utenti e ruoli.
- Gestione di istruttori, corsi e lezioni.
- Calendario delle lezioni.
- Prenotazioni, cancellazioni e lista d'attesa.
- Registrazione di presenze e assenze.
- Configurazione delle tipologie di abbonamento da parte di ciascuna palestra.

Le funzionalità elencate sono in fase di definizione: consultare il PRD e lo Scope per distinguere requisiti confermati, proposte e questioni aperte.

## Stack tecnologico proposto

| Componente | Tecnologia | Stato |
|---|---|---|
| Frontend | React + TypeScript + Vite | Proposta da confermare in fase di progettazione tecnica |
| Backend | Java 21 + Spring Boot | Proposta da confermare in fase di progettazione tecnica |
| Database | PostgreSQL | Proposta da confermare in fase di progettazione tecnica |
| API | REST | Direzione proposta |
| Security | Spring Security | Proposta da confermare in fase di progettazione tecnica |
| Mini App integration | `@gemspace/gem-bridge-sdk` | SDK individuato; integrazione da validare |
| Frontend testing | Vitest + React Testing Library | Proposta |
| Backend testing | JUnit + Mockito | Proposta |
| Versionamento | Git + GitHub | Strumenti previsti |
| Containerizzazione | Docker | Da valutare durante il setup |

## Documentazione

| File | Descrizione |
|---|---|
| [PRODUCT_VISION.md](PRODUCT_VISION.md) | Visione, problema, destinatari e obiettivi del prodotto. |
| [PRD.md](PRD.md) | Requisiti funzionali e non funzionali, regole di business, criteri di accettazione e questioni aperte. |
| [SCOPE.md](SCOPE.md) | Perimetro candidato dell'MVP e funzionalità rinviate. |
| [GLOSSARY.md](GLOSSARY.md) | Terminologia condivisa del progetto. |

## Struttura del repository prevista

```text
fitora/
├── frontend/
├── backend/
├── docs/
│   ├── PRODUCT_VISION.md
│   ├── PRD.md
│   ├── SCOPE.md
│   └── GLOSSARY.md
├── README.md
└── .gitignore
```

La struttura è indicativa e potrà cambiare dopo la progettazione dell'architettura.

## Gem Space

Il frontend è destinato a essere integrato nell'ecosistema Gem Space tramite `@gemspace/gem-bridge-sdk`. Il README dello SDK indica l'uso di `bridge.app.init()`, `bridge.profile.get()`, `bridge.auth.getToken()` e `bridge.app.ready()`. Il token JWT fornito da Gem Space deve essere verificato lato backend. Prima di implementare l'autenticazione occorre consultare le istruzioni ufficiali complete per chiavi e parametri di validazione.

## Come leggere questa documentazione

- **Confermato:** scelta espressa durante la Product Discovery.
- **Proposto:** soluzione suggerita per costruire la prima versione, da approvare.
- **Da definire (TBD):** informazione ancora necessaria prima di fissare requisiti o modello dati.

Per le decisioni ancora aperte, fare riferimento alla sezione 11 del `PRD.md`.
