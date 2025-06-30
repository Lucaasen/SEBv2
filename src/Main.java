public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addObserver(new GameLogger());

        ExamObserver observer = new ExamObserver();
        game.addObserver(observer); 
        game.start(); 
        ExamSystem exam = new ExamSystem(observer);
        exam.start();
    }
}
