import java.util.*;

public class ExamSystemTest2 {
    public static void main(String[] args) {
        ExamObserver stubObserver = new ExamObserver() {
            @Override
            public Collection<KamerData> getAlleResultaten() {
                KamerData kamer1 = new KamerData("Sprint Planning");
                kamer1.zetJuist(true);
                kamer1.zetBeurten(1);

                KamerData kamer2 = new KamerData("Sprint Review");
                kamer2.zetJuist(true);
                kamer2.zetBeurten(2);

                return List.of(kamer1, kamer2);
            }
        };

        ExamSystem system = new ExamSystem(stubObserver);
        system.start();
    }
}
