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

}

class ScrumBoardKamer extends Kamer {

}

class SprintReviewKamer extends Kamer {

}

class RetrospectiveKamer extends Kamer {
    public RetrospectiveKamer() {
        super("Retrospective", "Reflecteer op de afgelopen sprint.");
    }

    @Override
    public void betreed(Speler speler) {
        beschrijving();
        voerOpdrachtUit(speler);
    }

    @Override
    public void voerOpdrachtUit(Speler speler) {
        System.out.println("Opdracht: Wat ging goed en wat kan beter?");
    }
}
