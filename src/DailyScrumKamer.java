public class DailyScrumKamer extends Kamer {
    public DailyScrumKamer() {
        super("Daily Scrum", "Iedere ochtend komt je team bijeen.",
                new InvulVraagStrategie("Wat is het hoofddoel van de Daily Scrum?", "afstemming"));
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Dagelijkste stand-up tijd!");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Beantwoord de vraag over het doel van de Daily Scrum.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) new Monster("Verwarring", "Zonder duidelijk doel raken teamleden de weg kwijt.").verschijn();
        return juist;
    }

        @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Precies! Dagelijkse afstemming is essentieel.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("De Daily Scrum helpt om iedereen op dezelfde lijn te houden.");
    }

}
