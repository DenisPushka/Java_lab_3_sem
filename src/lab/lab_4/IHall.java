package lab.lab_4;

public interface IHall<T> {
    //Получения общего кол-ва книг в зале
    int getCountBook();

    //Выводящий на экран список названий всех книг в зале
    void showBook();

    //Получения общей стоимости всех книг в зале
    double priceAllBook();

    //Получения книги по ее номеру в зале
    T getBook(int number);

    //Изменения книги по ее номеру
    void changeBook(int numberBook, T newObject);

    //Добавления книги по номеру
    boolean addBook(int numberBook, T newObject);

    //Удаление книги по номеру
    boolean deleteBook(int numberBook);
}
