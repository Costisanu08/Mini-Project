
# Mini-Proiect Sistem Multi-Agent cu JADE

## Descriere

Acest proiect este un exemplu de sistem multi-agent realizat folosind platforma JADE (Java Agent DEvelopment Framework). Sistemul simulează un sistem de bibliotecă în care agenții colaborează pentru a gestiona catalogul de cărți, împrumuturile, utilizatorii și notificările.

## Cerințe

- Java 8 sau o versiune ulterioară
- JADE 4.5.3 sau o versiune ulterioară
- Maven pentru gestionarea dependențelor

## Structura Proiectului

- `src/main/java/ex1/AgentBibliotecar.java` - Agent care se ocupă de gestionarea catalogului de cărți.
- `src/main/java/ex1/AgentCatalog.java` - Agent care se ocupă de căutarea și actualizarea informațiilor despre cărți.
- `src/main/java/ex1/AgentÎmprumut.java` - Agent care se ocupă de gestionarea împrumuturilor de cărți.
- `src/main/java/ex1/AgentNotificare.java` - Agent care trimite notificări utilizatorilor.
- `src/main/java/ex1/AgentStatistici.java` - Agent care generează statistici de utilizare.
- `src/main/java/ex1/AgentUtilizator.java` - Agent care gestionează utilizatorii bibliotecii.
- `src/main/java/ex1/AgentMain.java` - Agent principal care coordonează activitățile celorlalți agenți.
- `src/main/java/ex1/Blackboard.java` - Clasă utilizată pentru comunicarea între agenți prin modelul blackboard.

## Instalare și Rulare

1. **Clonare repository**

    ```sh
    git clone https://github.com/username/mini-project.git
    cd mini-project
    ```

2. **Compilare proiect**

    Este necesar de asigurat că ai Maven instalat și configurat corect pe sistemul tău.

    ```sh
    mvn clean install
    ```

3. **Rulare proiect**

    Poți rula proiectul din linia de comandă sau folosind un IDE precum IntelliJ IDEA.

    **Linia de comandă:**

    ```sh
    mvn exec:java -Dexec.mainClass="ex1.LibrarySystem"
    ```

    **IntelliJ IDEA:**

    - Deschide proiectul în IntelliJ IDEA.
    - Navighează la clasa `LibrarySystem`.
    - Click dreapta pe clasa `LibrarySystem` și selectează `Run 'LibrarySystem.main()'`.

## Cum de utilizat

- După ce s-a rulat proiectul, agenții vor începe să interacționeze între ei pentru a simula diferite funcționalități ale unui sistem de bibliotecă.
- AgentMain coordonează activitățile agenților prin trimiterea de sarcini la intervale regulate.
- Fiecare agent (AgentBibliotecar, AgentCatalog, AgentÎmprumut, etc.) are roluri specifice în sistem:
  - AgentBibliotecar actualizează catalogul de cărți.
  - AgentCatalog caută și actualizează informațiile despre cărți.
  - AgentÎmprumut gestionează împrumuturile de cărți.
  - AgentNotificare trimite notificări utilizatorilor.
  - AgentStatistici generează rapoarte și statistici de utilizare.
  - AgentUtilizator gestionează înregistrarea și datele utilizatorilor.
- Poți modifica comportamentul agenților prin modificarea codului sursă și recompilarea proiectului.
- Pentru oprirea proiectului, AgentMain coordonează oprirea tuturor agenților și a platformei JADE după o perioadă de timp prestabilită.

## Funcționalități

- **AgentBibliotecar**: Actualizează catalogul de cărți.
- **AgentCatalog**: Caută cărți în catalog.
- **AgentÎmprumut**: Verifică și gestionează împrumuturile de cărți.
- **AgentNotificare**: Trimite notificări utilizatorilor.
- **AgentStatistici**: Generează statistici de utilizare a sistemului.
- **AgentUtilizator**: Înregistrează utilizatori noi și gestionează informațiile utilizatorilor.
- **AgentMain**: Coordonează activitățile tuturor agenților și oprește sistemul după o perioadă prestabilită.

## Exemple de ieșiri

```sh
AgentMain - started
AgentBibliotecar - started
AgentUtilizator - started
AgentCatalog - started
AgentÎmprumut - started
AgentNotificare - started
AgentStatistici - started
AgentMain - tasks sent to respective agents
AgentBibliotecar - task found: Update catalog with new books
AgentBibliotecar - updating catalog with new books
AgentCatalog - book found: book_456
...
AgentMain - shutting down...
AgentMain - terminating platform...
AgentBibliotecar - shutting down...
AgentUtilizator - shutting down...
AgentCatalog - shutting down...
AgentÎmprumut - shutting down...
AgentNotificare - shutting down...
AgentStatistici - shutting down...
```