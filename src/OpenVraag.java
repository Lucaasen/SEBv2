public class OpenVraag implements VervolgVraag {
    private String vraag;

    public OpenVraag(String vraag) {
        this.vraag = vraag;
    }

    @Override
    public void stelVraag() {
        System.out.println("Open vraag: " + vraag);
    }
}
