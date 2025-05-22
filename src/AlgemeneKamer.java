//een kamer die de speler kan betreden
public class AlgemeneKamer implements Kamer {
    @Override
    public void betreed(Speler speler) {
        //print een text wanneer de speler de kamer binnenkomt
        System.out.println("Je bent in een algemene kamer.");

        //start een opdracht voor de speler
        Opdracht opdracht = new Opdracht();
        opdracht.start(speler);
    }
}
