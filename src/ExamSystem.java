class ExamSystem {
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
            System.out.println("Kamer: " + data.naam + " → " + (voldoende ? "Voldoende" : "Onvoldoende"));

            if (!voldoende) {
                VervolgVraag vraag = VraagGenerator.genereerVervolgVraag(); // polymorfisme hier
                vraag.stelVraag();
            } else {
                voldoendeKamers++;
            }
        }

        toonEindRapport(voldoendeKamers);
    }

    private boolean beoordeel(KamerData data) {
        return data.goedBeantwoord && data.hintsGebruikt <= 1 && data.pogingen <= 2;
    }

    private void toonEindRapport(int voldoendeKamers) {
        double cijfer = (voldoendeKamers / 6.0) * 10;
        System.out.printf("Je eindcijfer is een %.1f\n", cijfer);
    }
}
