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

    public void beschrijving() {
        System.out.println("Kamer: " + naam);
        System.out.println("Omschrijving: " + omschrijving);
    }

    public abstract void betreed(Speler speler);
    public abstract void voerOpdrachtUit(Speler speler);
}

class SprintPlanningKamer extends Kamer {
    public SprintPlanningKamer() {
        super("Sprint Planning", "Je moet inschatten welke taken passen binnen een sprint.");
    }

    @Override
    public void betreed(Speler speler) {
        beschrijving();
        voerOpdrachtUit(speler);
    }

    @Override
    public void voerOpdrachtUit(Speler speler) {
        System.out.println("Opdracht: Kies de juiste taken voor de sprint!");
    }
}

class DailyScrumKamer extends Kamer {
    public DailyScrumKamer() {
        super("Daily Scrum", "Je krijgt een lijst teamleden em je moet aangeven wie welke status-update zou geven.");
    }

    @Override
    public void betreed(Speler speler) {
        beschrijving();
        voerOpdrachtUit(speler);
    }

    @Override
    public void voerOpdrachtUit(Speler speler) {
        System.out.println("Opdracht: Kies welke teamlid welke status-update zou geven.");
    }
}

class ScrumBoard extends Kamer {
    public ScrumBoard() {
        super("Scrum Board", "Je krijgt een opdracht om een bord correct in te richten met taken, user stories en epics.");
    }

    @Override
    public void betreed(Speler speler) {
        beschrijving();
        voerOpdrachtUit(speler);
    }

    @Override
    public void voerOpdrachtUit(Speler speler) {
        System.out.println("Opdracht: Richt de scrumboard correct in met taken, user stories en epics");
    }
}