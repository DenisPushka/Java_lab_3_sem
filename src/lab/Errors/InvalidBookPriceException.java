package lab.Errors;

public class InvalidBookPriceException extends InvalidBookCountException {
    public InvalidBookPriceException() {
        System.err.println("\nОшибка некорректной стоимости книги");
    }
}
