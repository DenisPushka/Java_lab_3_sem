
package lab;

import lab.Interface.IBook;
import lab.Interface.IHall;
import lab.Interface.ILibrary;
import lab.lab_4.ScientificLibrary;
import lab.lab_4.ScientificLibraryHall;
import lab.lib.ChildrenBook;
import lab.lib.ScientificBook;

public class main {
    public static <hall3> void main(String[] ar) {
        IBook book = new ScientificBook("Овечкин", "математика", 300, 2001, 3);
        IBook i = new ScientificBook("Петров", "химия", 100, 2001, 3);
        IBook q = new ScientificBook("Козлов", "география", 100, 2001, 2);

        IBook[] chBook1 = new IBook[5];

        chBook1[0] = new ScientificBook("Редьярд Киплинг", "Книга джунглей", 450, 2001, 12);
        chBook1[1] = new ScientificBook("Лингред", "Карлсон", 550, 2011, 8);
        chBook1[2] = book;
        chBook1[3] = i;
        chBook1[4] = q;

        IBook[] chBook2 = new ScientificBook[2];
        chBook2[0] = new ScientificBook("Роберт Стивенсон", "Остров сокровищ.", 450, 2001, 12);
        chBook2[1] = new ScientificBook("Антуан де Сент-Экзюпери", "Маленький принц", 550, 2011, 8);

        IBook[] chBook3 = new ScientificBook[3];
        chBook3[0] = new ScientificBook("Дэн Слотт", "Человек паук", 390, 2013, 6);
        chBook3[1] = new ScientificBook("Джефф Джонс", "Аквамен", 675, 2011, 6);
        chBook3[2] = new ScientificBook("Джек Кирби", "Железный человек", 1090, 1985, 6);


        IHall hall1 = new ScientificLibraryHall("Научный зал №1", chBook1);
        IHall hall2 = new ScientificLibraryHall("Научный зал №2", chBook2);
        IHall hall3 = new ScientificLibraryHall("Научный зал №3", chBook3);
        hall1.showBook();
        ChildrenBook childrenBook1 = new ChildrenBook("Карлсон", 2020);
        hall1.addBook(1, childrenBook1);

        System.out.println(hall1);
        System.out.println(hall2);
        System.out.println(hall3);
        hall1.changeBook(4, chBook2[0]);
        System.out.println(hall1);
        System.out.println(hall2);
        System.out.println(hall3);

        IHall[] arr = new IHall[]{hall1, hall2, hall3};

        ILibrary library = new ScientificLibrary(arr);
        System.out.println(library);
        library.sortBooks();
        System.out.println("Отсортировано");
        System.out.println(library.getBestBook().getNameBook() + " " + library.getBestBook().getPrice());
        System.out.println(library);
    }
}
