package lab.lib;

import lab.Interface.IBook;
import lab.Interface.IHall;

public class Main {
    public static void main(String[] lab) {
        IBook book1 = new Book("Достоевский", "Идиот", 450, 2001);
        ChildrenBook[] bo = new ChildrenBook[2];
        bo[0] = new ChildrenBook("Достоевский", "Идиот", 450, 2001, 12);
        bo[1] = new ChildrenBook("Лингред", "Карлсон", 550, 2011, 8);
        IBook cloneBk1 = book1.clone();
        System.out.println(book1.getNameBook() + " " + book1.getPrice());
        System.out.println(cloneBk1.getNameBook() + " " + cloneBk1.getPrice());
        cloneBk1.setNameBook("as");
        cloneBk1.setPrice(21);
        System.out.println(book1.getNameBook() + " " + book1.getPrice());
        System.out.println(cloneBk1.getNameBook() + " " + cloneBk1.getPrice());

        IHall ch1 = new ChildrenLibraryHall("12+", bo);
        ch1.showBook();
        IHall clHall1 = ch1.clone();
        clHall1.showBook();
        System.out.println("-----------------------");
        clHall1.changeBook(1, cloneBk1);
        ch1.showBook();
        clHall1.showBook();

    }
}