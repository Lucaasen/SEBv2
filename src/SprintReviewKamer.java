public class SprintReviewKamer extends Kamer {
      public SprintReviewKamer() {
        super("Sprint Review", "Sprint is voorbij - tijd om te revieuwen.",
                new MatchVraagStrategie());
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Welkom bij de Sprint Review. Laat zien wat je hebt bereikt.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
          strategie.toonUitdaging();
//          System.out.println("Koppel de juiste Scrum-termen met hun definities.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) new Monster("Onbegrip", "Je presentatie was onduidelijk.").verschijn();
        return juist;
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goed gedaan! De stakeholders zijn tevreden.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Duidelijke koppelingen tussen termen tonen je begrip.");
    }

}
