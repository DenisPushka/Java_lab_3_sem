package lab.Errors;

public class BookIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public BookIndexOutOfBoundsException() {
        System.err.println("\nВыход за границы номеров книг");
    }
}
