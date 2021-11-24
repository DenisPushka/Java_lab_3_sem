package lab.lab_3;

import lab.Errors.InvalidBookPriceException;
import lab.Interface.IBook;

public class Book implements IBook, Cloneable {
    private String author;
    private String nameBook;
    private double price;
    private int year;

    //Конструкторы
    //По умолчанию
    public Book() {
        this.author = null;
        nameBook = null;
        price = 0;
        year = 0;
    }

    //Принимает 4 параметра
    public Book(String author, String nameBook, double price, int year) {
        if (price < 0) {
            throw new InvalidBookPriceException();
        }

        this.author = author;
        this.nameBook = nameBook;
        this.price = price;
        this.year = year;
    }

    //Принимает 2 параметра
    public Book(String author, int year) {
        this();
        this.author = author;
        this.year = year;
    }

    //Геттеры
    public String getAuthor() {
        return author;
    }

    public String getNameBook() {
        return nameBook;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    //Сеттеры
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new InvalidBookPriceException();
        }
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(IBook book) {
        return book.getClass() == this.getClass()
                && ((Book) book).author.equals(this.author)
                && ((Book) book).nameBook.equals(this.nameBook)
                && ((Book) book).price == this.price
                && ((Book) book).year == this.year;
    }

    @Override
    public IBook clone() {
        IBook newObj = null;
        try {
            newObj = (IBook) super.clone();
        } catch (CloneNotSupportedException ex) {
        }
        return newObj;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append("\n\t| Автор: " + getAuthor() + "\t| Название: " + getNameBook() + "\t| Цена: " + getPrice() +
                "\t| Год издания" + getYear());
        return txt.toString();
    }

    @Override
    public int hashCode() {
        final int constant = 29;
        int author = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(this.author)));
        int nameBook = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(this.nameBook)));
        int price = Integer.parseInt(Integer.toBinaryString((int) this.price));
        int year = Integer.parseInt(Integer.toBinaryString(this.year));
        return constant * (author ^ nameBook ^ price ^ year);
    }
}
