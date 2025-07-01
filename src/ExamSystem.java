import java.util.Scanner;

public class ExamSystem {
    private ExamObserver observer;
    private Scanner scanner = new Scanner(System.in);

    public ExamSystem(ExamObserver observer) {
        this.observer = observer;
    }

    public void start() {
        System.out.println(">> Examensysteem gestart...");
        int voldoendeKamers = 0;

        for (KamerData data : observer.getAlleResultaten()) {
            boolean voldoende = beoordeel(data);
            System.out.println("Kamer: " + data.getKamerNaam() + " → " + (voldoende ? "Voldoende" : "Onvoldoende"));
            
            if (!voldoende) {
                VervolgVraag vraag = VraagGenerator.genereerVervolgVraag();
                vraag.stelVraag();
            } else {
                voldoendeKamers++;
            }
        }

        toonEindRapport(voldoendeKamers);
    }

    private boolean beoordeel(KamerData data) {
        return data.isJuistBeantwoord() && data.getAantalHints() <= 1 && data.getBeurten() <= 2;
    }

    private void toonEindRapport(int voldoendeKamers) {
        int totalKamers = 6;
        double cijfer = (voldoendeKamers / totalKamers) * 10;
        System.out.printf("Je eindcijfer is een %.1f\n", cijfer);
    }
}