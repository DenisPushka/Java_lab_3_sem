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

    public IBook clone() {
        IBook newObj = null;
        try {
            newObj = (IBook) super.clone();
        } catch (CloneNotSupportedException ex) {
        }
        return newObj;
    }
}
