import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Speler speler;
    private Scanner scanner = new Scanner(System.in);
    private List<Kamer> kamers = new ArrayList<>();
    private int huidigeIndex = 0;

    public void start() {
        this.speler = new Speler("Startkamer");
        speler.vraagNaamIn();
        notifyObservers(speler.getNaam() + " heeft het spel gestart.");
        System.out.println("Welkom bij het Scrum Avontuur!");

        kamers.add(new SprintPlanningKamer());
        kamers.add(new DailyScrumKamer());
        kamers.add(new ScrumBoardKamer());
        kamers.add(new SprintReviewKamer());
        kamers.add(new RetrospectiveKamer());
        kamers.add(new TIAKamer());

        while (huidigeIndex < kamers.size()) {
            Kamer kamer = kamers.get(huidigeIndex);
            notifyObservers(speler.getNaam() + " betreedt kamer: " + kamer.getNaam());
            kamer.voerOpdrachtUit(speler);
            huidigeIndex++;
//            Actie();
        }
    }

    public void Actie() {
        System.out.println("\nWelke actie wil je doen?");
        System.out.print("beweeg, interacteer, menu, inventaris: ");
        String actie = scanner.nextLine();

        if (actie.equalsIgnoreCase("exit")) {
            System.out.println("Bedankt voor het spelen! Tot de volgende keer.");
            System.out.println("Afsluiten...");
            System.exit(0);
        }

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

    private List<SpelEventObserver> observers = new ArrayList<>();
    
    public void addObserver(SpelEventObserver observer) {
    observers.add(observer);
    }

    private void notifyObservers(String event) {
        for (SpelEventObserver obs : observers) {
            obs.onEvent(event);
        }
    }
}
