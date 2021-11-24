package lab.lab_3;

import lab.Interface.IBook;

public class ChildrenBook extends Book implements IBook, Cloneable {
    private int yearChildren;

    //Конструкторы
    //по умолчанию
    public ChildrenBook() {
        yearChildren = 0;
    }

    //С двумя параметрами
    public ChildrenBook(String author, int year) {
        super(author, year);
        yearChildren = 0;
    }

    //Со всеми параметрами
    public ChildrenBook(String author, String nameBook, double price, int year, int yearChildren) {
        super(author, nameBook, price, year);
        this.yearChildren = yearChildren;

    }

    public int getYearChildren() {
        return yearChildren;
    }

    public void setYearChildren(int yearChildren) {
        this.yearChildren = yearChildren;
    }

    @Override
    public String getAuthor() {
        return super.getAuthor();
    }

    @Override
    public String getNameBook() {
        return super.getNameBook();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public IBook clone() {
        IBook newObj = null;
        newObj = super.clone();
        return newObj;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append(super.toString() + "\t| Возраст: " + getYearChildren());
        return txt.toString();
    }

    @Override
    public boolean equals(IBook book) {
        return book.getClass() == this.getClass()
                && ((ChildrenBook) book).yearChildren == this.yearChildren
                && book.getAuthor().equals(this.getAuthor())
                && book.getNameBook().equals(this.getNameBook())
                && book.getPrice() == this.getPrice()
                && book.getYear() == this.getYear();
    }

    @Override
    public int hashCode() {
        final int constant = 29;
        int author = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(this.getAuthor())));
        int nameBook = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(this.getNameBook())));
        int price = Integer.parseInt(Integer.toBinaryString((int) this.getPrice()));
        int year = Integer.parseInt(Integer.toBinaryString(this.getYear()));
        int yearChildren = Integer.parseInt(Integer.toBinaryString(this.yearChildren));
        return constant * (author ^ nameBook ^ price ^ year ^ yearChildren);
    }
}
