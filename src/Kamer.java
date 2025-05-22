//bevat gemeenschappelijke logica voor alle kamers
abstract class Kamer {
    protected String naam; //kamer naam
    protected String omschrijving; //beschrijving/opdracht

    //constructor voor de kamer
    public Kamer(String naam, String omschrijving) {
        this.naam = naam;
        this.omschrijving = omschrijving;
    }

    //getters
    public String getNaam() {
        return naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    //toon de naam en de beschrijving van de kamer
    public void beschrijving() {
        System.out.println("Kamer: " + naam);
        System.out.println("Omschrijving: " + omschrijving);
    }

    //methodes die subklassen moet implementeren
    public abstract void betreed(Speler speler);
    public abstract void voerOpdrachtUit(Speler speler);
}

//sprint planning kamer
class SprintPlanningKamer extends Kamer {
    //constructor stelt naam en opdrachttekst in
    public SprintPlanningKamer() {
        super("Sprint Planning", "Je moet inschatten welke taken passen binnen een sprint.");
    }

    @Override
    public void betreed(Speler speler) {
        //toon de kamerbeschrijving
        beschrijving();
        //start de opdracht
        voerOpdrachtUit(speler);
    }

    @Override
    //specifieke opdracht voor deze kamer
    public void voerOpdrachtUit(Speler speler) {
        System.out.println("Opdracht: Kies de juiste taken voor de sprint!");
    }
}
