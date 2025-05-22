//regelt het spelverloop
public class Game {
    private Speler speler;  //welke speler actief is

    //start het spel
    public void start() {

        //nieuwe speler maken, begin in de startkamer
        speler = new Speler("Startkamer");

        //welkomsbericht
        System.out.println("Welkom bij het Scrum Avontuur!");

        // Voorbeeldkamer laden
        Kamer kamer = new AlgemeneKamer();

        //laat de speler de kamer betreden(enter)
        kamer.betreed(speler);
    }
}
