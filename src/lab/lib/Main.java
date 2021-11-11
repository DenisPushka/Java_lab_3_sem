package lab.lib;

public class Main {
    public static void main(String[] lab) {
        Book book1 = new Book("Достоевский", "Идиот", 450, 2001);
        ChildrenBook[] bo = new ChildrenBook[2];
        bo[0] = new ChildrenBook("Достоевский", "Идиот", 450, 2001, 12);
        bo[1] = new ChildrenBook("Лингред", "Карлсон", 550, 2011, 8);
        //ChildrenLibraryHall ch1 = new ChildrenLibraryHall("12+", bo);
        //ch1.showBook();
        //System.out.println(ch1.priceAllBook());
    }
}