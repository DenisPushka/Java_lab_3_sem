package lab.lab_3;

import lab.Interface.IBook;

public class ScientificBook extends Book implements IBook, Cloneable {
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

    @Override
    public boolean equals(IBook book) {
        return book.getClass() == this.getClass()
                && ((ScientificBook) book).index == this.index
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
        int index = Integer.parseInt(Integer.toBinaryString((int) this.index));
        return constant * (author ^ nameBook ^ price ^ year ^ index);
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append(super.toString() + "\tИндекс: " + getIndex());
        return txt.toString();
    }
}
