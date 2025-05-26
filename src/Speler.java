import java.util.ArrayList;
import java.util.List;

public class Speler {
    private String locatie;
    private String status;
    private List<String> bezochteKamers = new ArrayList<>();

    public Speler(String startLocatie) {
        this.locatie = startLocatie;
        this.status = "Beginnend";
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void voegBezochteKamerToe(String kamerNaam) {
        if (!bezochteKamers.contains(kamerNaam)) {
            bezochteKamers.add(kamerNaam);
        }
    }

    public void toonStatus() {
        System.out.println("📍 Huidige locatie: " + locatie);
        System.out.println("📈 Voortgang/status: " + status);
    }

    public void toonVoortgang() {
        int totaalKamers = 6; 
        int bezochteKamersCount = this.bezochteKamers.size();
        int percentage = (int) ((bezochteKamersCount / (double)totaalKamers) * 100);
        System.out.println("📊 Voortgang: " + percentage + "% voltooid.");
    }
}
