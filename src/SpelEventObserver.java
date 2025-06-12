import java.util.ArrayList;
import java.util.List;

interface SpelEventObserver {
    void opSpelerActie();
}

class SpelEventSubject {
    private List<SpelEventObserver> observers = new ArrayList<>();

    public void voegObserverToe(SpelEventObserver observer) {
        observers.add(observer);
    }

    public void verwijderObserver(SpelEventObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (SpelEventObserver observer : observers) {
            observer.opSpelerActie();
        }
    }
}
