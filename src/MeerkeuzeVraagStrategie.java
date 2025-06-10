import java.util.Scanner;

public class MeerkeuzeVraagStrategie implements OpdrachtStrategie {
    private String vraag;
    private String[] opties;
    private String correctAntwoord;

    public MeerkeuzeVraagStrategie(String vraag, String[] opties, String correctAntwoord) {
        this.vraag = vraag;
        this.opties = opties;
        this.correctAntwoord = correctAntwoord.toLowerCase();
    }

    @Override
    public void toonUitdaging() {
        System.out.println(vraag);
        for (int i = 0; i < opties.length; i++) {
            System.out.println((i + 1) + ". " + opties[i]);
        }
    }

    @Override
    public boolean voerUit() {
        toonUitdaging();
        System.out.print("Jouw keuze (nummer): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        try {
            int keuze = Integer.parseInt(input);
            if (keuze >= 1 && keuze <= opties.length) {
                return opties[keuze - 1].equalsIgnoreCase(correctAntwoord);
            }
        } catch (NumberFormatException e) {
            // ongeldige input
        }

        return false;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return antwoord.equalsIgnoreCase(correctAntwoord);
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

//import java.util.Scanner;
//
//public class MeerkeuzeVraagStrategie implements OpdrachtStrategie {
//    private final Scanner scanner = new Scanner(System.in);
//    private final String vraag;
//    private final String[] opties;
//    private final String correctAntwoord;
//
//    public MeerkeuzeVraagStrategie(String vraag, String[] opties, String correctAntwoord) {
//        this.vraag = vraag;
//        this.opties = opties;
//        this.correctAntwoord = correctAntwoord;
//    }
//
//    @Override
//    public void toonUitdaging() {
//        System.out.println(vraag);
//        for (int i = 0; i < opties.length; i++) {
//            System.out.println((char)('A' + i) + ": " + opties[i]);
//        }
//    }
//
//    @Override
//    public boolean controleerAntwoord() {
//        System.out.print("Jouw keuze: ");
//        String invoer = scanner.nextLine().trim().toUpperCase();
//        int index = invoer.charAt(0) - 'A';
//        if (index >= 0 && index < opties.length && opties[index].equalsIgnoreCase(correctAntwoord)) {
//            return true;
//        } else {
//            new Monster("Verkeerde keuze", "Je koos het verkeerde antwoord.").verschijn();
//            return false;
//        }
//    }
//
//    @Override
//    public void toonResultaat() {
//        System.out.println("Juist beantwoord!");
//    }
//
//    @Override
//    public void geefFeedback() {
//        System.out.println("Meerkeuzevragen kunnen je inzicht in Scrum toetsen.");
//    }
//}
//
