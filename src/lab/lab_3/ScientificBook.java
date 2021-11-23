package lab.lab_3;

import lab.Interface.IBook;

public class ScientificBook extends Book implements IBook {
    private float index;

    // Конструкторы
    // По умолчанию
    public ScientificBook() {
        index = 0;
    }

    //С двумя параметрами
    public ScientificBook(String author, int year) {
        super(author, year);
        index = 0;
    }

    //Со всеми параметрами
    public ScientificBook(String author, String nameBook, double price, int year, float index) {
        super(author, nameBook, price, year);
        this.index = index;
    }

    public float getIndex() {
        return index;
    }

    public void setIndex(float index) {
        this.index = index;
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
