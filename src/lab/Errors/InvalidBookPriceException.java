package lab.Errors;

public class InvalidBookPriceException extends IllegalArgumentException {
    public InvalidBookPriceException() {
        System.err.println("\nОшибка некорректной стоимости книги");
    }
}
