public class TIAKamer extends Kamer {
    public TIAKamer() {
        super("Scrum Pilaren", "Test je kennis over de 3 Scrum-pilaren.",
                new InvulVraagStrategie("Wat zijn de drie kernpilaren van Scrum?", "transparantie, inspectie, aanpassing"));
    }


    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("De basis van Scrum rust op 3 pijlers...");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Noem de drie Scrum-pilaren.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) new Monster("Instabiliteit", "Zonder de juiste basis valt alles uit elkaar.").verschijn();
        return juist;
    }


    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Perfect! Je kent de fundamenten.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Transparantie, Inspectie en Aanpassing houden je team wendbaar.");
    }
}
