package lab.lab_4;

import lab.Interface.IBook;
import lab.Interface.IHall;
import lab.Interface.ILibrary;

public class ScientificLibrary implements ILibrary<IHall, IBook> {
    private final ListLibraryHall hall;

    // Конструкторы
    // Принимающий количество залов и массив количеств книг по залам
    public ScientificLibrary(int count, int[] arrayBook) {
        hall = new ListLibraryHall();
        for (int i = 0; i < count; i++) {
            hall.add(new ScientificLibraryHall("", arrayBook[i]), i);
        }
    }

    // Принимающий массив залов
    public ScientificLibrary(IHall[] arrayHall) {
        hall = new ListLibraryHall(); //??
        for (int q = 0; q < arrayHall.length; q++) {
            hall.add(arrayHall[q], q + 1);
        }
    }

    // Методы получения
    // Количества залов
    public int getCountHall() {
        return hall.countItem();
    }

    // Количества книг
    public int getCountBook() {
        int countBook = 0;
        for (int r = 0; r < hall.countItem(); r++) {
            countBook += hall.returnItem(r).data.getCountBook();
        }
        return countBook;
    }

    // Сумму всех книг в библиотеке
    public int getPriceAllBook() {
        int sum = 0;
        for (int z = 0; z < hall.countItem(); z++) {
            sum += hall.returnItem(z).data.priceAllBook();
        }
        return sum;
    }

    // Массива залов библиотеки
    public IHall[] getArrayHall() {
        IHall[] arr = new IHall[hall.countItem()];
        for (int s = 0; s < hall.countItem(); s++) {
            arr[s] = getHall(s);
        }
        return arr;
    }

    // Объекта зала по его номеру в библиотеке
    public IHall getHall(int number) {
        return hall.returnItem(number).data;
    }

    // Объекта книги по его номеру в библиотеке
    public IBook getBook(int number) {
        return (IBook) hall.returnItem(cycle(number)[0]).data.getBook(cycle(number)[1]);
    }

    // Отсортированного по убыванию цены массива книг библиотеки
    public IBook[] sortBooks() {
        boolean needIteration = true;
        int count = 0;
        IBook[] arr = new IBook[getCountBook()];
        for (int f = 0; f < hall.countItem(); f++) {
            for (int t = 0; t < hall.returnItem(f).data.getCountBook(); t++) {
                arr[count] = (IBook) hall.returnItem(f).data.getBook(t);
                count++;
            }
        }

        while (needIteration) {
            needIteration = false;
            for (int v = 0; v < arr.length - 1; v++) {
                if (arr[v].getPrice() < arr[v + 1].getPrice()) {
                    IBook buff = arr[v];
                    arr[v] = arr[v + 1];
                    arr[v + 1] = buff;
                    needIteration = true;
                }
            }
        }
        return arr;
    }

    // Выводящий на экран список названий всех залов с количеством книг в них
    public void show() {
        for (int c = 0; c < hall.countItem(); c++) {
            System.out.println(
                    "\nЗал: " + c +
                            "\tКол-во книг: " + hall.returnItem(c).data.getCountBook());
        }
    }

    // Замена зала по его номеру на другой
    public void changeHall(int number, IHall newHall) {
        if (hall.getSize() < number || number < 0) {
            System.out.println("\nЭлемент не входит в числовой отрезок от 0 до size\n");
        }
        hall.returnItem(number).data = newHall;
//        hall.remove(number);      //альтернатива
//        hall.add(newHall, number);
        System.out.println("\nЗал добавлен");
    }

    // Замена книги по ее номеру на другую
    public void changeBook(int number, IBook newBook) {
        hall.returnItem(cycle(number)[0]).data.changeBook(cycle(number)[1], newBook);
    }

    // Добавление книги в библиотеку по ее номеру в библиотеке
    public boolean addBook(int number, IBook newBook) {
        hall.returnItem(cycle(number)[0]).data.addBook(cycle(number)[1], newBook);
        return true;
    }

    // Удаление книги по ее номеру в библиотеке
    public boolean removeBook(int number) {
        hall.returnItem(cycle(number)[0]).data.deleteBook(cycle(number)[1]);
        return true;
    }

    // Получение самой лучшей книги в библиотеке
    //(с самой большой ценой)
    public IBook getBestBook() {
        return sortBooks()[0];
    }

    // Цикл
    public int[] cycle(int needNumb) {
        int[] arr = new int[2];
        int count = 0;
        for (int q = 0; q < hall.countItem(); q++) {
            for (int j = 0; j < hall.returnItem(q).data.getCountBook(); j++) {
                if (count == needNumb) {
                    arr[0] = q;
                    arr[1] = j;
                    return arr;
                }
                count++;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String txt = "\n";
        for (int k = 0; k < hall.countItem(); k++) {
            txt += "\nЗал: " + k +
                    "\n\tКниги: " + hall.returnItem(k).data.toString();
        }
        return txt;
    }

    public ILibrary clone() {
        ILibrary newObj = null;
        return newObj;
    }
}