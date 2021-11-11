package lab.lib;

import lab.lab_4.IBook;

public class Book implements IBook {
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

    //Сеттеры
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
