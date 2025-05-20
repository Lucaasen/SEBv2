public class AlgemeneKamer implements Kamer {
    @Override
    public void betreed(Speler speler) {
        System.out.println("Je bent in een algemene kamer.");
        Opdracht opdracht = new Opdracht();
        opdracht.start(speler);
    }
}
