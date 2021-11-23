package lab.lib;

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
}
