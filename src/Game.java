public class Game {
    private Speler speler;

    public void start() {
        speler = new Speler("Startkamer");
        System.out.println("Welkom bij het Scrum Avontuur!");
        // Voorbeeldkamer laden
        Kamer kamer = new AlgemeneKamer();
        kamer.betreed(speler);
    }
}
