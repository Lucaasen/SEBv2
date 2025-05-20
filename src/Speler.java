public class Speler {
    private String locatie;
    private String status;

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
}
