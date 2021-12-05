package lab.Interface;

public interface ILibrary {
    // Количества залов
    int getCountHall();

    // Количества книг
    int getCountBook();

    // Сумму всех книг в библиотеке
    int getPriceAllBook();

    // Массива залов библиотеки
    IHall[] getArrayHall();

    // Объекта зала по его номеру в библиотеке
    IHall getHall(int number);

    // Объекта книги по его номеру в библиотеке
    IBook getBook(int number);

    // Отсортированного по убыванию цены массива книг библиотеки
    IBook[] sortBooks();

    // Выводящий на экран список названий всех залов с количеством книг в них
    void show();

    // Замена зала по его номеру на другой
    void changeHall(int number, IHall newHall);

    // Замена книги по ее номеру на другую
    void changeBook(int number, IBook newBook);

    // Добавление книги в библиотеку по ее номеру в библиотеке
    boolean addBook(int number, IBook newBook);

    // Удаление книги по ее номеру в библиотеке
    boolean removeBook(int number);

    // Получение самой лучшей книги в библиотеке
    //(с самой большой ценой)
    IBook getBestBook();

    Object clone();

    boolean equals(ILibrary library);

    int hashCode();

    String toString();
}
