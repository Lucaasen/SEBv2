
public interface OpdrachtStrategie {
//    boolean controleerAntwoord();
//    void toonResultaat();
//    void geefFeedback();
    boolean voerUit();
    void toonUitdaging(); // deze moet overal worden geïmplementeerd


    boolean controleerAntwoord(String antwoord);

    void toonResultaat();

    void geefFeedback();
}

//class InvulVraagStrategie implements OpdrachtStrategie {
//    private String vraag;
//    private String correctAntwoord;
//
//    public InvulVraagStrategie(String vraag, String correctAntwoord) {
//        this.vraag = vraag;
//        this.correctAntwoord = correctAntwoord;
//    }
//
//    @Override
//    public boolean voerUit() {
//        System.out.println(vraag);
//        System.out.print("Jouw antwoord: ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
//        return antwoord.equals(correctAntwoord.toLowerCase());
//    }
//}
//
//class MeerkeuzeVraagStrategie implements OpdrachtStrategie {
//    private String vraag;
//    private String[] opties;
//    private String correctAntwoord;
//
//    public MeerkeuzeVraagStrategie(String vraag, String[] opties, String correctAntwoord) {
//        this.vraag = vraag;
//        this.opties = opties;
//        this.correctAntwoord = correctAntwoord.toLowerCase();
//    }
//
//    @Override
//    public boolean voerUit() {
//        System.out.println(vraag);
//        for (int i = 0; i < opties.length; i++) {
//            System.out.println((i + 1) + ". " + opties[i]);
//        }
//        System.out.print("Kies een optie (1-" + opties.length + "): ");
//        Scanner scanner = new Scanner(System.in);
//        String keuze = scanner.nextLine().trim();
//        try {
//            int index = Integer.parseInt(keuze) - 1;
//            return opties[index].trim().toLowerCase().equals(correctAntwoord);
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
//
//class MatchVraagStrategie implements OpdrachtStrategie {
//    @Override
//    public boolean voerUit() {
//        System.out.println("Koppel de juiste Scrum-termen met hun definities (tekstmatig, dus type het juiste koppel):");
//        System.out.println("A: Sprint       1: Periode waarin werk wordt afgerond");
//        System.out.println("B: Backlog      2: Lijst met taken");
//        System.out.println("C: Review       3: Presentatie van werk");
//
//        System.out.print("Jouw antwoord (voorbeeld: A1, B2, C3): ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toUpperCase();
//        return antwoord.contains("A1") && antwoord.contains("B2") && antwoord.contains("C3");
//    }
//}
//
//class PuzzelVraagStrategie implements OpdrachtStrategie {
//    @Override
//    public boolean voerUit() {
//        System.out.println("Puzzel: Welk Scrum-event komt het vaakst voor?");
//        System.out.print("Jouw antwoord: ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
//        return antwoord.contains("daily") || antwoord.contains("daily scrum");
//    }
//}
//
//
//
