package lab.Interface;

public interface IHall {
    //Получения общего кол-ва книг в зале
    int getCountBook();

    //Выводящий на экран список названий всех книг в зале
    void showBook();

    //Получения общей стоимости всех книг в зале
    double priceAllBook();

    //Получения книги по ее номеру в зале
    IBook getBook(int number);

    //Изменения книги по ее номеру
    void changeBook(int numberBook, IBook newObject);

    //Добавления книги по номеру
    boolean addBook(int numberBook, IBook newObject);

    //Удаление книги по номеру
    boolean deleteBook(int numberBook);

    IHall clone();

    boolean equals(IHall hall);

    int hashCode();

    String toString();
}
