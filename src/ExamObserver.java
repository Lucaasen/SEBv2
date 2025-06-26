import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class ExamObserver implements SpelEventObserver {
    private Map<String, KamerData> kamerDataMap = new HashMap<>();

    @Override
    public void onEvent(String event) {
        if (event.startsWith("EINDRESULTAAT:")) {
            String kamerNaam = event.substring("EINDRESULTAAT:".length());
            registreerKamer(kamerNaam);
        } else if (event.startsWith("HINT_USED:")) {
            String kamerNaam = event.substring("HINT_USED:".length());
            kamerDataMap.get(kamerNaam).verhoogHints();
        } else if (event.startsWith("ANTWOORD_JUIST:")) {
            String kamerNaam = event.substring("ANTWOORD_JUIST:".length());
            kamerDataMap.get(kamerNaam).zetJuist(true);
        } else if (event.startsWith("ANTWOORD_FOUT:")) {
            String kamerNaam = event.substring("ANTWOORD_FOUT:".length());
            kamerDataMap.get(kamerNaam).verhoogFouten();
        } else if (event.startsWith("VERBRUIKTE_BEURTEN:")) {
            String[] parts = event.substring("VERBRUIKTE_BEURTEN:".length()).split(";");
            String kamerNaam = parts[0];
            int beurten = Integer.parseInt(parts[1]);
            kamerDataMap.get(kamerNaam).zetBeurten(beurten);
        }
    }


    public void registreerKamer(String kamerNaam) {
        kamerDataMap.put(kamerNaam, new KamerData(kamerNaam));
    }

    public Collection<KamerData> getAlleResultaten() {
        return kamerDataMap.values();
    }
}

