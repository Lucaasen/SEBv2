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
                setOpdrachtVoltooid(true);
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

    private boolean opdrachtVoltooid = false;

    public boolean isOpdrachtVoltooid() {
        return opdrachtVoltooid;
    }

    public void setOpdrachtVoltooid(boolean voltooid) {
        this.opdrachtVoltooid = voltooid;
    }

    protected abstract void toonIntroductie(Speler speler);
    protected abstract void presenteerUitdaging(Speler speler);
    protected abstract boolean valideerAntwoord(Speler speler);
    protected abstract void toonResultaat(Speler speler);
    protected abstract void geefFeedback(Speler speler);

}

