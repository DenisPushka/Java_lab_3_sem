package lab.Errors;

public class InvalidBookCountException extends IllegalArgumentException {
    public InvalidBookCountException() {
        System.err.println("\nВыхода за границы номеров холлов!");
    }
}
