public class Game {
    private Speler speler;

    public void start() {
        Speler speler = new Speler("Startkamer");
        speler.Naam();
        System.out.println("Welkom bij het Scrum Avontuur!");
        Kamer kamer = new SprintPlanningKamer(); 
        kamer.betreed(speler);
    }
}