package lab.Errors;

public class HallIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public HallIndexOutOfBoundsException() {
        System.err.println("\nВыхода за границы номеров холлов!");
    }
}
