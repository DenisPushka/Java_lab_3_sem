package lab.Interface;

public interface IBook {
    String getAuthor();

    void setAuthor(String author);

    String getNameBook();

    void setNameBook(String nameBook);

    double getPrice();

    void setPrice(double price);

    int getYear();

    void setYear(int year);

    IBook clone();
}
