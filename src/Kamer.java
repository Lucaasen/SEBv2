abstract class Kamer {
    protected String naam;
    protected String omschrijving;

    public Kamer(String naam, String omschrijving) {
        this.naam = naam;
        this.omschrijving = omschrijving;
    }

    public String getNaam() {
        return naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public final void betreed(Speler speler) {
        introductie();
        opdracht(speler);
        controleAntwoord(speler);
        toonResultaat(speler);
        geefFeedback(speler);
    }

    protected void introductie() {
        System.out.println("Kamer: " + naam);
        System.out.println("Omschrijving: " + omschrijving);
    }

    protected abstract void opdracht(Speler speler);
    protected abstract void controleAntwoord(Speler speler);
    protected abstract void toonResultaat(Speler speler);
    protected abstract void geefFeedback(Speler speler);
}

class SprintPlanningKamer extends Kamer {
    public SprintPlanningKamer() {
        super("Sprint Planning", "Je moet inschatten welke taken passen binnen een sprint.");
    }

    @Override
    protected void opdracht(Speler speler) {
        System.out.println("Opdracht: Kies de juiste taken voor de sprint!");
    }

    @Override
    protected void controleAntwoord(Speler speler) {
        System.out.println("Controle: Je keuze wordt gecontroleerd...");
    }

    @Override
    protected void toonResultaat(Speler speler) {
        
    }

    @Override
    protected void geefFeedback(Speler speler) {
        
    }
}

class DailyScrumKamer extends Kamer {
    public DailyScrumKamer() {
        super("Daily Scrum", "Je krijgt een lijst teamleden en moet aangeven wie welke status-update zou geven.");
    }

    @Override
    protected void opdracht(Speler speler) {
        System.out.println("Opdracht: Geef aan wie welke status-update zou geven.");
    }

    @Override
    protected void controleAntwoord(Speler speler) {
        System.out.println("Controle: Je keuze wordt gecontroleerd...");
    }

    @Override
    protected void toonResultaat(Speler speler) {
        
    }

    @Override
    protected void geefFeedback(Speler speler) {
        
    }
}

class ScrumBoardKamer extends Kamer {
    public ScrumBoardKamer() {
        super("Scrum Board", "Je krijgt een opdracht om een bord correct in te richten met taken, user stories en epics.");
    }

    @Override
    protected void opdracht(Speler speler) {
        System.out.println("Opdracht: Richt de scrumbord correct in met taken, user stories en epics");
    }

    @Override
    protected void controleAntwoord(Speler speler) {
        System.out.println("Controle: Je keuze wordt gecontroleerd...");
    }

    @Override
    protected void toonResultaat(Speler speler) {
        
    }

    @Override
    protected void geefFeedback(Speler speler) {
        
    }
}

class SprintReviewKamer extends Kamer {
    public SprintReviewKamer() {
        super("Sprint Review", "Je moet feedback van stakeholders interpreteren en de impact ervan inschatten.");
    }

    @Override
    protected void opdracht(Speler speler) {
        System.out.println("Opdracht: Bekijk de feedback van de stakeholders en schat de impact ervan in.");
    }

    @Override
    protected void controleAntwoord(Speler speler) {
        System.out.println("Controle: Je keuze wordt gecontroleerd...");
    }

    @Override
    protected void toonResultaat(Speler speler) {
        
    }

    @Override
    protected void geefFeedback(Speler speler) {
        
    }
}

class SprintRetrospectiveKamer extends Kamer {
    public SprintRetrospectiveKamer() {
        super("Sprint Retrospective", "Je krijgt situaties die zich in een team voordoen en moet aangeven wat het team hiervan kan leren.");
    }

    @Override
    protected void opdracht(Speler speler) {
        System.out.println("Opdracht: Geef aan wat een team kan leren van situaties die er zich voordoen.");
    }

    @Override
    protected void controleAntwoord(Speler speler) {
        System.out.println("Controle: Je keuze wordt gecontroleerd...");
    }

    @Override
    protected void toonResultaat(Speler speler) {
        
    }

    @Override
    protected void geefFeedback(Speler speler) {
        
    }
}

class FinaleKamer extends Kamer {
    public FinaleKamer() {
        super("TIA Kamer", "In deze kamer het eindspel. Pas als je hier doorheen komt, heb je gewonnen!");
    }

    @Override
    protected void opdracht(Speler speler) {
        System.out.println("Opdracht: Zoek uit wat TIA is.");
    }

    @Override
    protected void controleAntwoord(Speler speler) {
        System.out.println("Controle: Je keuze wordt gecontroleerd...");
    }

    @Override
    protected void toonResultaat(Speler speler) {
        
    }

    @Override
    protected void geefFeedback(Speler speler) {
        
    }
}


