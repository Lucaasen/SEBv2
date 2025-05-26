import java.util.Scanner;

public class Game {
    private Speler speler;

    public void start() {
        speler = new Speler("Startkamer");
        System.out.println("Welkom bij het Scrum Avontuur!");

        Kamer kamer = new AlgemeneKamer();
        kamer.betreed(speler);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("status")) {
                speler.toonStatus();
            } else if (input.equalsIgnoreCase("stop")) {
                System.out.println("Bedankt voor het spelen!");
                break;
            } else {
                System.out.println("Onbekend commando. Typ 'status' of 'stop'.");
            }
        }

        scanner.close();
    }
}
