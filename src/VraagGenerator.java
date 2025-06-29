import java.util.List;
import java.util.function.Supplier;

public class VraagGenerator {
    private static Supplier<VervolgVraag> vraagLeverancier = VraagGenerator::defaultVraag;

    public static VervolgVraag genereerVervolgVraag() {
        return vraagLeverancier.get();
    }

    private static VervolgVraag defaultVraag() {
        if (Math.random() < 0.5) {
            return new OpenVraag("Wat is het nut van een Daily Scrum?");
        } else {
            return new MeerkeuzeVraag(
                "Wat is een artefact in Scrum?",
                List.of("De Scrum Master", "Het Product Backlog", "De Sprint Review"),
                1 
            );
        }
    }

    public static void setVraagLeverancier(Supplier<VervolgVraag> supplier) {
        vraagLeverancier = supplier;
    }
}
