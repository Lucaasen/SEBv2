import java.util.*;

public class ExamSystemTest1 {
    public static void main(String[] args) {
        ExamObserver stubObserver = new ExamObserver() {
            @Override
            public Collection<KamerData> getAlleResultaten() {
                KamerData kamer = new KamerData("Sprint Review");
                kamer.zetJuist(false);
                kamer.verhoogHints();
                kamer.verhoogFouten();
                kamer.zetBeurten(3); 
                return List.of(kamer);
            }
        };

        VraagGenerator.setVraagLeverancier(() -> new MeerkeuzeVraag(
            "Wat is een retrospectieve?",
            List.of("Een planning", "Een evaluatie", "Een test"), 1));

        ExamSystem system = new ExamSystem(stubObserver);
        system.start();
    }
}


