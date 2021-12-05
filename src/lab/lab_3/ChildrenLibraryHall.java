package lab.lab_3;

import lab.Interface.IBook;
import lab.Interface.IHall;

public class ChildrenLibraryHall implements IHall {
    private IBook[] childrenBook;
    private String nameHall;

    //Конструкторы
    //Принимает имя зала и кол-во книг
    public ChildrenLibraryHall(int counter) {
        nameHall = "";
        childrenBook = new IBook[counter];
    }

    public ChildrenLibraryHall(String nameHall, int counter) {
        this.nameHall = nameHall;
        childrenBook = new IBook[counter];
    }

    //Принимает имя зала и массив книг
    public ChildrenLibraryHall(String nameHall, IBook[] book) {
        this.nameHall = nameHall;
        this.childrenBook = book;
    }

    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    //Методы
    //Получения общего кол-ва книг в зале
    public int getCountBook() {
        return childrenBook.length;
    }

    //Выводящий на экран список названий всех книг в зале
    public void showBook() {
        for (IBook a : childrenBook)
            System.out.printf("Автор: %s\t Книга: %s\n", a.getAuthor(), a.getNameBook());
    }

    //Получения общей стоимости всех книг в зале
    public double priceAllBook() {
        double summ = 0;
        for (IBook a : childrenBook) {
            summ += a.getPrice();
        }
        return summ;
    }

    //Получения книги по ее номеру в зале
    public IBook getBook(int number) {
        if (childrenBook[number] == null)
            return null;
        return childrenBook[number];
    }

    //Изменения книги по ее номеру
    public void changeBook(int numberBook, IBook newObject) {
        childrenBook[numberBook] = newObject;
    }

    //Добавления книги по номеру
    public boolean addBook(int numberBook, IBook newObject) {
        IBook[] newChildrenBook = new IBook[childrenBook.length + 1];
        for (int i = 0; i < numberBook; i++) {
            newChildrenBook[i] = childrenBook[i];
        }
        newChildrenBook[numberBook] = newObject;
        for (int i = numberBook; i < childrenBook.length; i++) {
            newChildrenBook[i + 1] = childrenBook[i];
        }
        childrenBook = newChildrenBook;
        return true;
    }

    //Удаление книги по номеру
    public boolean deleteBook(int numberBook) {
        IBook[] newChildrenBook = new IBook[childrenBook.length + 1];
        for (int i = 0; i < numberBook; i++) {
            newChildrenBook[i] = childrenBook[i];
        }
        for (int i = numberBook; i < childrenBook.length - 1; i++) {
            newChildrenBook[i] = childrenBook[i + 1];
        }
        childrenBook = newChildrenBook;
        return true;
    }

    //Поиск книги с самой высокой стоимостью
    public IBook highPrice() {
        if (childrenBook[0] == null)
            return null;
        IBook obj = childrenBook[0];
        for (IBook i : childrenBook) {
            if (obj.getPrice() > i.getPrice()) {
                obj = i;
            }
        }
        return obj;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append("\n\t\tНазвание: " + getNameHall());
        for (int k = 0; k < childrenBook.length; k++) {
            txt.append(childrenBook[k].toString());
        }
        return txt.toString();
    }

    @Override
    public Object clone() {
        IHall newObj = new ChildrenLibraryHall(getCountBook());
        for (int i = 0; i < this.childrenBook.length; i++) {
            newObj.changeBook(i, (IBook) this.getBook(i).clone());
        }
        return newObj;
    }

    @Override
    public boolean equals(IHall hall) {
        if (hall == null)
            return false;
        if (hall.getClass() == this.getClass() && ((ChildrenLibraryHall) hall).nameHall == this.nameHall &&
                ((ChildrenLibraryHall) hall).childrenBook.length == this.childrenBook.length) {
            for (int i = 0; i < childrenBook.length; i++) {
                if (!childrenBook[i].equals(this.childrenBook[i]))
                    return false;
               /* if (((ChildrenLibraryHall) hall).childrenBook[i].getClass() != this.childrenBook[i].getClass() ||
                        ((ChildrenLibraryHall) hall).childrenBook[i].getNameBook().equals(this.childrenBook[i].getNameBook()) ||
                        ((ChildrenLibraryHall) hall).childrenBook[i].getAuthor().equals(this.childrenBook[i].getAuthor()) ||
                        ((ChildrenLibraryHall) hall).childrenBook[i].getPrice() != this.childrenBook[i].getPrice() ||
                        ((ChildrenLibraryHall) hall).childrenBook[i].getYear() != this.childrenBook[i].getYear())
                    return false;*/
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int constant = 29;
        int result = 0;
        for (int i = 0; i < this.childrenBook.length; i++) {
            result += this.childrenBook[i].hashCode();
        }
        return constant * result;
    }
}
