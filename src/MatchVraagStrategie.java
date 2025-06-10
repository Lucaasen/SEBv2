import java.util.Scanner;

public class MatchVraagStrategie implements OpdrachtStrategie {

    @Override
    public void toonUitdaging() {
        System.out.println("Koppel de juiste Scrum-termen met hun beschrijvingen (Placeholder).");
    }

    @Override
    public boolean voerUit() {
        toonUitdaging();
        System.out.println("Typ 'ja' als je klaar bent: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("ja");
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        // Placeholder implementatie - vergelijk met verwacht antwoord
        return antwoord.equalsIgnoreCase("ja");
    }

    @Override
    public void toonResultaat() {
        // Lege implementatie - wordt waarschijnlijk door Opdracht.java afgehandeld
    }

    @Override
    public void geefFeedback() {
        // Lege implementatie - wordt waarschijnlijk door Opdracht.java afgehandeld
    }
}

//        System.out.println("Match de termen met de juiste definities:");
//        System.out.println("1. Product Owner");
//        System.out.println("2. Scrum Master");
//        System.out.println("3. Development Team");
//        System.out.println("A. Ondersteunt het team en verwijdert obstakels");
//        System.out.println("B. Verantwoordelijk voor het bouwen van het product");
//        System.out.println("C. Beheert de product backlog");
//
//        System.out.print("Wat is de juiste match voor 1? ");
//        String a1 = scanner.nextLine().trim().toUpperCase();
//        System.out.print("Wat is de juiste match voor 2? ");
//        String a2 = scanner.nextLine().trim().toUpperCase();
//        System.out.print("Wat is de juiste match voor 3? ");
//        String a3 = scanner.nextLine().trim().toUpperCase();
//
//        return a1.equals("C") && a2.equals("A") && a3.equals("B");



