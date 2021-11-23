package lab.Interface;

public interface ILibrary<T, Y> {
    // Количества залов
    int getCountHall();

    // Количества книг
    int getCountBook();

    // Сумму всех книг в библиотеке
    int getPriceAllBook();

    // Массива залов библиотеки
    T[] getArrayHall();

    // Объекта зала по его номеру в библиотеке
    T getHall(int number);

    // Объекта книги по его номеру в библиотеке
    Y getBook(int number);

    // Отсортированного по убыванию цены массива книг библиотеки
    Y[] sortBooks();

    // Выводящий на экран список названий всех залов с количеством книг в них
    void show();

    // Замена зала по его номеру на другой
    void changeHall(int number, T newHall);

    // Замена книги по ее номеру на другую
    void changeBook(int number, Y newBook);

    // Добавление книги в библиотеку по ее номеру в библиотеке
    boolean addBook(int number, Y newBook);

    // Удаление книги по ее номеру в библиотеке
    boolean removeBook(int number);

    // Получение самой лучшей книги в библиотеке
    //(с самой большой ценой)
    Y getBestBook();

    ILibrary clone();
}
