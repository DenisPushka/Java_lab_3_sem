
package lab_4;

import libraries.ScientificBook;

import java.util.ArrayList;

public class main {
    public static <hall3> void main(String ar[]) {
        ScientificBook book = new ScientificBook("Овечкин", "математика", 300, 2001, 3);
        ScientificBook i = new ScientificBook("Петров", "химия", 100, 2001, 3);
        ScientificBook q = new ScientificBook("Козлов", "география", 100, 2001, 2);

        ScientificBook[] chBook1 = new ScientificBook[5];

        chBook1[0] = new ScientificBook("Редьярд Киплинг", "Книга джунглей", 450, 2001, 12);
        chBook1[1] = new ScientificBook("Лингред", "Карлсон", 550, 2011, 8);
        chBook1[2] = book;
        chBook1[3] = i;
        chBook1[4] = q;

        ScientificBook[] chBook2 = new ScientificBook[2];
        chBook2[0] = new ScientificBook("Роберт Стивенсон", "Остров сокровищ.", 450, 2001, 12);
        chBook2[1] = new ScientificBook("Антуан де Сент-Экзюпери", "Маленький принц", 550, 2011, 8);

        ScientificBook[] chBook3 = new ScientificBook[3];
        chBook3[0] = new ScientificBook("Дэн Слотт", "Человек паук", 390, 2013, 6);
        chBook3[1] = new ScientificBook("Джефф Джонс", "Аквамен", 675, 2011, 6);
        chBook3[2] = new ScientificBook("Джек Кирби", "Железный человек", 1090, 1985, 6);

        ScientificLibraryHall hall1 = new ScientificLibraryHall("Научный зал №1", chBook1);
        ScientificLibraryHall hall2 = new ScientificLibraryHall("Научный зал №2", chBook2);
        ScientificLibraryHall hall3 = new ScientificLibraryHall("Научный зал №3", chBook3);
        hall1.showNameBook();
        System.out.println(hall1);
        System.out.println(hall2);
        System.out.println(hall3);
        hall1.changeBook(4,chBook2[0]);
        System.out.println(hall1);
        System.out.println(hall2);
        System.out.println(hall3);

        ScientificLibraryHall[] arr = new ScientificLibraryHall[]{hall1, hall2, hall3};

        ScientificLibrary library = new ScientificLibrary(arr);
        System.out.println(library);
//        System.out.println("\nНазвание: " + library.getBestBook().getAuthor() + "\tКнига: " +
//                library.getBestBook().getNameBook() + "\t\tЦена: " +
//                library.getBestBook().getPrice());

    }
}
