public interface Kamer {
    void betreed(Speler speler);
}

public abstract class Kamer {
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

    public abstract void betreed(Speler speler);
}

public class SprintPlanningKamer extends Kamer {
    public SprintPlanningKamer() {
        super("Sprint Planning", "Je moet inschatten welke taken passen binnen een sprint.");
    }

    @Override
    public void betreed(Speler speler) {
        System.out.println("Welkom in de kamer: " + naam);
        System.out.println(omschrijving);
    }
}

