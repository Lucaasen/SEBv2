class KamerData {
    private String kamerNaam;
    private int aantalHints = 0;
    private int aantalFouten = 0;
    private boolean juistBeantwoord = false;

    public KamerData(String kamerNaam) {
        this.kamerNaam = kamerNaam;
    }

    public void verhoogHints() {
        aantalHints++;
    }

    public void verhoogFouten() {
        aantalFouten++;
    }

    public void zetJuist(boolean juist) {
        this.juistBeantwoord = juist;
    }

    public String getKamerNaam() {
        return kamerNaam;
    }

    public int getAantalHints() {
        return aantalHints;
    }

    public int getAantalFouten() {
        return aantalFouten;
    }

    public boolean isJuistBeantwoord() {
        return juistBeantwoord;
    }

    public void zetBeurten(int beurten) {
        this.beurten = beurten;
    }
}
