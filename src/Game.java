public class Game {
    private Speler speler;

    public void start() {
        speler = new Speler("Startkamer");
        System.out.println("Welkom bij het Scrum Avontuur!");
        Kamer kamer = new Kamer();
        kamer.betreed(speler);
    }
}
