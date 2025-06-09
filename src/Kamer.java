import java.util.Scanner;

abstract class Kamer {
    protected String naam;
    protected String beschrijving;
    private boolean voltooid = false;

    //constructor voor de kamer
    public Kamer(String naam, String beschrijving) {
        this.naam = naam;
        this.beschrijving = beschrijving;
    }

    public void voerOpdrachtUit(Speler speler) {
        if (!voltooid) {
            toonIntroductie(speler);
            presenteerUitdaging(speler);
            if (valideerAntwoord(speler)) {
                toonResultaat(speler);
                geefFeedback(speler);
                voltooid = true;
            } else {
                System.out.println("Probeer het opnieuw...");
            }
        } else {
            System.out.println("Je hebt deze kamer al voltooid.");
        }
    }

    public boolean isVoltooid() {
        return voltooid;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    protected abstract void toonIntroductie(Speler speler);
    protected abstract void presenteerUitdaging(Speler speler);
    protected abstract boolean valideerAntwoord(Speler speler);
    protected abstract void toonResultaat(Speler speler);
    protected abstract void geefFeedback(Speler speler);

//    public final void speelKamer(Speler speler) {
//        toonIntroductie(speler);
//        presenteerUitdaging(speler);
//        boolean correct = valideerAntwoord(speler);
//
//        if (correct) {
//            toonResultaat(speler);
//            geefFeedback(speler);
//        } else {
//            System.out.println("Verkeerd antwoord. probeer het opnieuw.");
//            speelKamer(speler);
//        }
//    }

//        beschrijving();
//        toonIntroductie(speler);
//        presenteerUitdaging(speler);
//        valideerAntwoord(speler);
//        toonResultaat(speler);
//        geefFeedback(speler);

//    public final void betreed(Speler speler) {
//        System.out.println("Je betreedt: " + naam);
//        beschrijving();
//        speelKamer(speler);
//    }
//
//    public void beschrijving() {
//        System.out.println(beschrijving);
//    }

    //getters
//    public String getNaam() {
//        return naam;
//    }

//    public String getOmschrijving() {
//        return omschrijving;
//    }
//
//    //toon de naam en de beschrijving van de kamer
//    public void beschrijving() {
//        System.out.println("Kamer: " + naam);
//        System.out.println("Omschrijving: " + omschrijving);
//    }

//    public void betreed(Speler speler){
//        speelKamer(speler);
//    }

//    public abstract void voerOpdrachtUit(Speler speler);

}

class SprintPlanningKamer extends Kamer {
    public SprintPlanningKamer() {
        super("Sprint Planning", "Welke taken passen in de komende sprint?");
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("In deze kamer plan je het werk voor de sprint.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        System.out.println("Opdracht: Welke taken passen in de sprint.");
    }

//    @Override
//    protected void valideerAntwoord(Speler speler) {
//        System.out.println("Je hebt gekozen: ");
//    }
    @Override
    protected boolean valideerAntwoord(Speler speler) {
        System.out.print("Jouw antwoord: ");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();

        if (antwoord.equals("user login implementeren")) {
            return true;
        } else {
            Monster monster = new Monster("Scope Creep", "Je hebt te veel werk of onrealistische taken gekozen.");
            monster.verschijn();
            monster.losOp();
            return false;
        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goed gekozen taak! Dit is realistisch voor een sprint.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Probeer altijd klein en haalbaar te plannen.");
    }

//    @Override
//    public void voerOpdrachtUit(Speler speler) {
//        speelKamer(speler);
//    }

//    @Override
//    public void betreed(Speler speler) {
//        beschrijving();
//        voerOpdrachtUit(speler);
//    }
}

class DailyScrumKamer extends Kamer {
    public DailyScrumKamer() {
        super("Daily Scrum", "Dagelijkse vergadering van 15 minuten.");
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("De Daily Scrum is begonnen. Wat bespreek je?");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        System.out.println("Opdracht: Noem één ding dat je deelt tijdens een Daily Scrum.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        System.out.print("Jouw antwoord: ");
        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
        if (antwoord.equals("stand-up verslag") || antwoord.equals("wat je gisteren deed")) {
            return true;
        } else {
            new Monster("Tijdverspilling", "Je hebt iets irrelevants gezegd!").verschijn();
            return false;
        }
    }

        @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Kort en krachtig! Precies wat nodig is.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Houd het bij fijten en voortgang. Goed bezig!");
    }

//    @Override
//    public void betreed(Speler speler) {
//        beschrijving();
//        voerOpdrachtUit(speler);
//    }

//    @Override
//    public void voerOpdrachtUit(Speler speler) {
//        speelKamer(speler);
////        System.out.println("Opdracht: In de lijst van teamleden moet je aangeven wie welke status-update zou geven.");
//    }
}

class ScrumBoardKamer extends Kamer {
      public ScrumBoardKamer() {
        super("Scrum Board", "Hier beheer je de voortgang van taken.");
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Je kijkt naar het Scrum Board.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        System.out.println("Opdracht: Noem twee elementen die je terugvindt op een Scrum Board.");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        System.out.print("Jouw antwoord: ");
        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
        if (antwoord.contains("user stories") && antwoord.contains("taken")) {
            return true;
        } else {
            new Monster("Chaos", "Je scrum board is onduidelijk en rommelig!").verschijn();
            return false;
        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goed overzicht! Taken en stories duidelijk weergegeven.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Een visueel board helpt het team effectief te blijven.");
    }

//    @Override
//    public void betreed(Speler speler) {
//        beschrijving();
//        voerOpdrachtUit(speler);
//    }

//    @Override
//    public void voerOpdrachtUit(Speler speler) {
//          speelKamer(speler);
////        System.out.println("Opdracht: Je moet een bord correct inrichten met taken, user stories en epics");
//    }
}

class SprintReviewKamer extends Kamer {
      public SprintReviewKamer() {
        super("Sprint Review", "Hier presenteer je wat er is voltooid.");
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("De sprint is voorbij. Tijd om te evalueren.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        System.out.println("Opdracht: Wat wordt besproken met stakeholders tijdens een Sprint Review?");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        System.out.print("Jouw antwoord: ");
        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
        if (antwoord.equals("klantfeedback")) {
            return true;
        } else {
            new Monster("Onverschillige Klant", "Je negeert de eindgebruiker!").verschijn();
            return false;
        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Feedback ontvangen! Belangrijk voor toekomstige sprints.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Betrek stakeholders voor meer waarde in het product.");
    }

//    @Override
//    public void betreed(Speler speler) {
//        beschrijving();
//        voerOpdrachtUit(speler);
//    }

//    @Override
//    public void voerOpdrachtUit(Speler speler) {
//          speelKamer(speler);
////        System.out.println("Opdracht: Je moet feedback van stakeholders interpreteren en de impact ervan inschatten");
//    }
}

class RetrospectiveKamer extends Kamer {
    public RetrospectiveKamer() {
        super("Sprint Retrospective", "Tijd om te reflecteren als team.");
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Je team bespreekt hoe het is gegaan.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        System.out.println("Opdracht: Wat is het doel van een retrospective?");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        System.out.print("Jouw antwoord: ");
        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
        if (antwoord.equals("team reflecteert") || antwoord.contains("verbeteren")) {
            return true;
        } else {
            new Monster("Herhaling van fouten", "Zonder reflectie herhaal je je fouten!").verschijn();
            return false;
        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goed reflectiemoment, team groeit ervan!");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Leer van je fouten en successen. Dat maakt je sterker.");
    }

//    @Override
//    public void betreed(Speler speler) {
//        beschrijving();
//        voerOpdrachtUit(speler);
//    }

//    @Override
//    public void voerOpdrachtUit(Speler speler) {
//        speelKamer(speler);
////        System.out.println("Opdracht: je krijgt situaties die zich in een team voordoen en je moet aangeven wat het team hiervan kan leren.");
//    }
}

class TIAKamer extends Kamer {
    public TIAKamer() {
        super("Scrum Principes: TIA", "Je moet nu aantonen dat je de basisprincipes van Scrum kent.");
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("De kern van Scrum draait om drie pijlers.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        System.out.println("Opdracht: Noem de drie Scrum-pijlers (TIA).");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        System.out.print("Jouw antwoord (gescheiden door komma's): ");
        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
        if (antwoord.contains("transparantie") && antwoord.contains("inspectie") && antwoord.contains("aanpassing")) {
            return true;
        } else {
            new Monster("Scrum-Amnesie", "Je mist de kernwaarden van Scrum!").verschijn();
            return false;
        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Perfect! Je kent de fundamenten van Scrum.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Met deze kennis kun je elk Scrum-team versterken.");
    }

//    @Override
//    public void betreed(Speler speler) {
//        beschrijving();
//        voerOpdrachtUit(speler);
//    }

//    @Override
//    public void voerOpdrachtUit(Speler speler) {
//        speelKamer(speler);
////        System.out.println("Opdracht: Wat betekend 'TIA'?");
//    }
}