class GameLogger implements SpelEventObserver {
    @Override
    public void onEvent(String event) {
        System.out.println("[EVENT] " + event);
    }
}