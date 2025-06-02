import java.util.Scanner;

public class Game {
    private Speler speler;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        this.speler = new Speler("Startkamer");  // correcte initialisatie
        speler.Naam();
        System.out.println("Welkom bij het Scrum Avontuur!");
        Kamer kamer = new SprintPlanningKamer();
        kamer.betreed(speler);

        while (true) { // loop voor continue acties
            Actie();
        }
    }

    public void Actie() {
        System.out.println("\nWelke actie wil je doen?");
        System.out.print("beweeg, interacteer, menu, inventaris: ");
        String actie = scanner.nextLine();
        verwerkActie(actie);
    }

    public void verwerkActie(String actie) {
        switch (actie.toLowerCase()) {
            case "beweeg":
                speler.setLocatie("DailyScrumKamer"); // voorbeeld
                System.out.println("Je beweegt naar: " + speler.getLocatie());
                break;
            case "interacteer":
                Kamer kamer = bepaalKamer(speler.getLocatie());
                kamer.voerOpdrachtUit(speler);
                break;
            case "menu":
                System.out.println("Toon menu-opties...");
                break;
            case "inventaris":
                System.out.println("Je hebt nog geen items.");
                break;
            default:
                System.out.println("Ongeldige actie.");
        }
    }
    public Kamer bepaalKamer(String locatie) {
        switch (locatie) {
            case "Startkamer":
                return new SprintPlanningKamer();
            case "DailyScrumKamer":
                return new DailyScrumKamer();
            case "ScrumBoardKamer":
                return new ScrumBoardKamer();
            default:
                return new SprintPlanningKamer(); // fallback
        }
    }

}
