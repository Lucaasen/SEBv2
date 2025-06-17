public class RetrospectiveKamer extends Kamer {
    public RetrospectiveKamer() {
        super("Retrospective", "Even stilstaan bij de samenwerking.",
                new PuzzelVraagStrategie());
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Refelctie is de sleutel tot verbetering.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Los de Scrum-puzzel op.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) new Monster("Herhaling", "Je blijft dezelfde fouten maken.").verschijn();
        return juist;
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goede reflectie! Je weet waar verbetering nodig is.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Gebruik de Retrospective om het teamproces te optimaliseren.");
    }
}
