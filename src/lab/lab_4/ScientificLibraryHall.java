package lab.lab_4;

import lab.Errors.BookIndexOutOfBoundsException;
import lab.Interface.IBook;
import lab.Interface.IHall;
import lab.lib.ScientificBook;

public class ScientificLibraryHall implements IHall {
    private String nameHall;
    private List scienceBook;

    // Геттеры и сеттеры
    public List getScienceBook() {
        return scienceBook;
    }

    public void setScienceBook(List scienceBook) {
        this.scienceBook = scienceBook;
    }

    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    // Конструкторы
    // По умолчанию
    public ScientificLibraryHall(){
        nameHall = "";
        scienceBook = new List();
    }

    // Принимает имя зала и кол-во книг в зале
    public ScientificLibraryHall(String nameHall, int count) {
        this.nameHall = nameHall;
        scienceBook = new List();
        for (int i = 0; i < count; i++) {
            scienceBook.add(new ScientificBook("", 0), i);
        }
    }

    public ScientificLibraryHall(int count) {
        nameHall = "";
        scienceBook = new List();
        for (int i = 0; i < count; i++) {
            scienceBook.add(new ScientificBook("", 0), i);
        }
    }

    public ScientificLibraryHall(IBook[] books) {
        scienceBook = new List();
        for (int i = 0; i < books.length; i++) {
            scienceBook.add(books[i], i + 1);
        }
    }

    // Принимает имя зала и массив книг
    public ScientificLibraryHall(String nameHall, IBook[] book) {
        this.nameHall = nameHall;
        scienceBook = new List();
        for (int i = 0; i < book.length; i++) {
            scienceBook.add(book[i], i + 1);
        }
    }

    // Методы
    // получения количества книг в зале
    public int getCountBook() {
        return scienceBook.countItem();
    }

    // Выводящий на экран список названий всех книг в зале
    public void showBook() {
        for (int i = 0; i < scienceBook.countItem(); i++) {
            System.out.println(scienceBook.returnItem(i).data.getAuthor());
        }
    }

    // Получения общей стоимости всех книг в зале
    public double priceAllBook() {
        double sum = 0;
        for (int i = 0; i < scienceBook.countItem(); i++) {
            sum += scienceBook.returnItem(i).data.getPrice();
        }
        return sum;
    }

    // Получение книги по ее номеру в зале номеру
    public IBook getBook(int number) {
        return scienceBook.returnItem(number).data;
    }

    // Изменения книги по ее номеру
    public void changeBook(int number, IBook newBook) {
        if (number > scienceBook.getSize() + 1 || number < 0) {
            System.out.println("\nЭлемент не входит в числовой отрезок от 0 до size\n");
            throw new BookIndexOutOfBoundsException();
        }
        scienceBook.returnItem(number).data = newBook;
        System.out.println("Данные изменены");
    }

    // Добавления книги по номеру
    public boolean addBook(int number, IBook book) {
        if (number > scienceBook.getSize() + 1 || number < 0) {
            System.out.println("\nЭлемент не входит в числовой отрезок от 0 до size\n");
            throw new BookIndexOutOfBoundsException();
        }

        if (scienceBook.add(book, number)) {
            System.out.println("\nКнига добавлена");
            return true;
        }
        return false;
        //альтернатива: return scienceBook.add(book,number);
    }

    // Удаления книги по номеру
    public boolean deleteBook(int number) {
        if (scienceBook.remove(number)) {
            System.out.println("\nКнига успешно удалена");
            return true;
        }
        return false;
    }

    // Книга с самой высокой стоимостью
    public IBook getBestBook() {
        IBook maxPrice = scienceBook.returnItem(0).data;
        for (int n = 0; n < scienceBook.getSize(); n++) {
            if (maxPrice.getPrice() < scienceBook.returnItem(n).data.getPrice()) {
                maxPrice = scienceBook.returnItem(n).data;
            }
        }
        return maxPrice;
    }

    @Override
    public String toString() {
        String txt = "";
        for (int k = 0; k < scienceBook.countItem(); k++) {
            txt += "\n\t\tНзвание: " + scienceBook.returnItem(k).data.getNameBook();
            txt += "\tАвтор: " + scienceBook.returnItem(k).data.getAuthor();
            txt += "\t\tЦена: " + scienceBook.returnItem(k).data.getPrice();
            txt += "\t\tГод издания: " + scienceBook.returnItem(k).data.getYear();
        }
        return txt;
    }

    public IHall clone() {
        IHall newObj = new ScientificLibraryHall(getCountBook());
        for (int i = 0; i < newObj.getCountBook(); i++) {
            newObj.changeBook(i, this.getBook(i).clone());
        }
        return newObj;
    }
}