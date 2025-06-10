import java.util.Scanner;

abstract class Kamer {
    protected String naam;
    protected String beschrijving;
    private boolean voltooid = false;
    protected OpdrachtStrategie strategie;

    //constructor voor de kamer
    public Kamer(String naam, String beschrijving, OpdrachtStrategie strategie) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.strategie = strategie;
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
        super("Sprint Planning", "Welke taken passen in de komende sprint?", new InvulVraagStrategie("Welke taak is geschikt voor de sprint?", "user login implementeren"));
    }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("In deze kamer plan je het werk voor de sprint.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Opdracht: Welke taken passen in de sprint.");
    }

    //    @Override
//    protected void valideerAntwoord(Speler speler) {
//        System.out.println("Je hebt gekozen: ");
//    }
    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) {
            new Monster("Scope Creep", "Je hebt te veel werk of onrealistische taken gekozen.").verschijn();
        }
        return juist;
//        System.out.print("Jouw antwoord: ");
//        Scanner scanner = new Scanner(System.in);
//        String antwoord = scanner.nextLine().trim().toLowerCase();
//
//        if (antwoord.equals("user login implementeren")) {
//            return true;
//        } else {
//            Monster monster = new Monster("Scope Creep", "Je hebt te veel werk of onrealistische taken gekozen.");
//            monster.verschijn();
//            monster.losOp();
//            return false;
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
//        System.out.print("Jouw antwoord: ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
//        if (antwoord.equals("stand-up verslag") || antwoord.equals("wat je gisteren deed")) {
//            return true;
//        } else {
//            new Monster("Tijdverspilling", "Je hebt iets irrelevants gezegd!").verschijn();
//            return false;
//        }
    }

        @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Precies! Dagelijkse afstemming is essentieel.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("De Daily Scrum helpt om iedereen op dezelfde lijn te houden.");
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
          super("Scrum Board", "Je staat voor een digitaal Scrum board.",
                  new MeerkeuzeVraagStrategie(
                          "Wat hoort NIET thuis op een Scrum Board?",
                          new String[]{"To do", "In progress", "Done", "Gebruikerstevredenheid"},
                          "Gebruikerstevredenheid"
                  ));
      }

    @Override
    protected void toonIntroductie(Speler speler) {
        System.out.println("Het Scrum Board geeft je overzicht over je werk.");
    }

    @Override
    protected void presenteerUitdaging(Speler speler) {
        strategie.toonUitdaging();
//        System.out.println("Welke term hoort hier niet thuis?");
    }

    @Override
    protected boolean valideerAntwoord(Speler speler) {
        boolean juist = strategie.voerUit();
        if (!juist) new Monster("Chaos", "Je bord is onoverzichtelijk geworden!").verschijn();
        return juist;
//        System.out.print("Jouw antwoord: ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
//        if (antwoord.contains("user stories") && antwoord.contains("taken")) {
//            return true;
//        } else {
//            new Monster("Chaos", "Je scrum board is onduidelijk en rommelig!").verschijn();
//            return false;
//        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Correct! Dat hoort niet op het Scrum Board.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Gebruik duidelijke categorieën zoals To Do, In Progress, en Done.");
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
//        System.out.print("Jouw antwoord: ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
//        if (antwoord.equals("klantfeedback")) {
//            return true;
//        } else {
//            new Monster("Onverschillige Klant", "Je negeert de eindgebruiker!").verschijn();
//            return false;
//        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goed gedaan! De stakeholders zijn tevreden.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Duidelijke koppelingen tussen termen tonen je begrip.");
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
//        System.out.print("Jouw antwoord: ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
//        if (antwoord.equals("team reflecteert") || antwoord.contains("verbeteren")) {
//            return true;
//        } else {
//            new Monster("Herhaling van fouten", "Zonder reflectie herhaal je je fouten!").verschijn();
//            return false;
//        }
    }

    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Goede reflectie! Je weet waar verbetering nodig is.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Gebruik de Retrospective om het teamproces te optimaliseren.");
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
//        System.out.print("Jouw antwoord (gescheiden door komma's): ");
//        String antwoord = new Scanner(System.in).nextLine().trim().toLowerCase();
//        if (antwoord.contains("transparantie") && antwoord.contains("inspectie") && antwoord.contains("aanpassing")) {
//            return true;
//        } else {
//            new Monster("Scrum-Amnesie", "Je mist de kernwaarden van Scrum!").verschijn();
//            return false;
//        }
    }


    @Override
    protected void toonResultaat(Speler speler) {
        System.out.println("Perfect! Je kent de fundamenten.");
    }

    @Override
    protected void geefFeedback(Speler speler) {
        System.out.println("Transparantie, Inspectie en Aanpassing houden je team wendbaar.");
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