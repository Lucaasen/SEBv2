import java.util.List;
import java.util.Scanner;

public class MeerkeuzeVraag implements VervolgVraag {
    private String vraag;
    private List<String> opties;
    private int juisteIndex;

    public MeerkeuzeVraag(String vraag, List<String> opties, int juisteIndex) {
        this.vraag = vraag;
        this.opties = opties;
        this.juisteIndex = juisteIndex;
    }

    @Override
    public void stelVraag() {
        System.out.println(vraag);
        for (int i = 0; i < opties.size(); i++) {
            System.out.println((i + 1) + ". " + opties.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Jouw antwoord (1-" + opties.size() + "): ");
        int keuze = scanner.nextInt();

        if (keuze - 1 == juisteIndex) {
            System.out.println("Correct!");
        } else {
            System.out.println("Helaas, dat is niet correct.");
        }
    }
}