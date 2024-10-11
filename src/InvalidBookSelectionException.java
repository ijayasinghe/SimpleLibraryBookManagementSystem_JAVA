public class InvalidBookSelectionException extends Exception {
    public int getChoice() {
        return choice;
    }

    private int choice;
    public InvalidBookSelectionException(int choice) {
        super();
        this.choice = choice;
    }
}
