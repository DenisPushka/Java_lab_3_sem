package lab.lab_3;

import lab.Interface.IBook;
import lab.Interface.IHall;
import lab.Interface.ILibrary;

public class ChildrenLibrary implements ILibrary {
    private final IHall[] chilrenLibrHall;

    //Конструкторы
    //Принимающий кол-во залов и массив количеств книг по залам
    public ChildrenLibrary(int counterHall, int[] childrenBooks) {
        chilrenLibrHall = new IHall[counterHall];
        for (int i = 0; i < counterHall; i++)
            chilrenLibrHall[i] = new ChildrenLibraryHall(childrenBooks[i]);
    }

    //Принимающий массив залов
    public ChildrenLibrary(IHall[] chilrenLibrBook) {
        this.chilrenLibrHall = chilrenLibrBook;
    }

    public ChildrenLibrary(int countHall) {
        chilrenLibrHall = new IHall[countHall];
    }

    //Методы
    //Получения количества залов
    public int getCountHall() {
        return chilrenLibrHall.length;
    }

    //Получения количества книг
    public int getCountBook() {
        int sum = 0;
        for (IHall item : chilrenLibrHall) {
            sum += item.getCountBook();
        }
        return sum;
    }

    //Получения суммы всех книг в библиотеке
    public int getPriceAllBook() {
        int sum = 0;
        for (IHall b : chilrenLibrHall) {
            sum += b.getCountBook();
        }
        return sum;
    }

    //Получения массива залов библиотеки
    public IHall[] getArrayHall() {
        return chilrenLibrHall;
    }

    //Получения объекта зала по его номеру в библиотеке
    public IHall getHall(int numberHall) {
        return chilrenLibrHall[numberHall];
    }

    //Получения объекта книги по его номеру в библиотеке
    public IBook getBook(int numberBooks) {
        int count = 0;
        for (int i = 0; i < chilrenLibrHall.length; i++) {
            for (int j = 0; j < chilrenLibrHall[i].getCountBook(); j++) {
                if (count == numberBooks) {
                    return chilrenLibrHall[i].getBook(j);
                }
                count++;
            }
        }
        return null;
    }

    //Получения отсортированного по убыванию цены массива книг библиотеки
    public IBook[] sortBooks() {
        if (chilrenLibrHall[0] == null) return null;
        boolean flag = true;
        int count = 0;
        IBook[] max_Arr = new IBook[getCountBook()];

        for (int i = 0; i < chilrenLibrHall.length; i++) {
            for (int j = 0; j < chilrenLibrHall[i].getCountBook(); j++, count++) {
                max_Arr[count] = chilrenLibrHall[i].getBook(j);
            }
        }
        count = 0;

        while (flag) {
            flag = false;
            for (int i = 0; i < max_Arr.length - 1; i++) {
                if (max_Arr[i].getPrice() < max_Arr[i + 1].getPrice()) {
                    IBook tmp = max_Arr[i];
                    max_Arr[i] = max_Arr[i + 1];
                    max_Arr[i + 1] = tmp;
                    flag = true;
                }
            }
        }

        for (int i = 0; i < chilrenLibrHall.length; i++) {
            for (int j = 0; j < chilrenLibrHall[i].getCountBook(); j++, count++) {
                chilrenLibrHall[i].changeBook(j, max_Arr[count]);
            }
        }
        return max_Arr;
    }

    //Выводящий на экран список названий всех залов с количеством книг в них
    public void show() {
        int count = 0;
        for (IHall ch : chilrenLibrHall) {
            System.out.printf("Зал: %s\t Количество книг: %x\n", count + 1, ch.getCountBook());
            count++;
        }
    }

    //Замена зала по его номеру на другой (номер зала — первый параметр,
    //ссылка на новый зал передается вторым параметром)
    public void changeHall(int numberHall, IHall hall) {
        chilrenLibrHall[numberHall] = hall;
    }

    //Замена книги по ее номеру на другую (номер книги — первый
    //параметр, ссылка на другую книгу передается вторым параметром)
    public void changeBook(int numberBook, IBook book) {
        int count = 0;
        for (int i = 0; i < chilrenLibrHall.length; i++) {
            for (int j = 0; j < chilrenLibrHall[i].getCountBook(); j++) {
                if (count == numberBook) {
                    chilrenLibrHall[i].changeBook(j, book);
                    return;
                }
                count++;
            }
        }
    }

    //Добавление книги в библиотеку по ее номеру в библиотеке
    public boolean addBook(int numberNewBook, IBook newBook) {
        int count = 0;
        for (int i = 0; i < chilrenLibrHall.length; i++) {
            for (int j = 0; j < chilrenLibrHall[i].getCountBook(); j++) {
                if (count == numberNewBook) {
                    chilrenLibrHall[i].addBook(j, newBook);
                    return true;
                }
                count++;
            }
        }
        return false;
    }

    //Удаление книги по ее номеру в библиотеке
    public boolean removeBook(int numberNewBook) {
        int count = 0;
        for (int i = 0; i < chilrenLibrHall.length; i++) {
            for (int j = 0; j < chilrenLibrHall[i].getCountBook(); j++) {
                if (count == numberNewBook) {
                    chilrenLibrHall[i].deleteBook(j);
                    return true;
                }
                count++;
            }
        }
        return false;
    }

    //Получение самой дорогой книги в библиотеке
    public IBook getBestBook() {
        return sortBooks()[0];
    }

    public String toString() {
        String txt = "\n";
        for (int i = 0; i < chilrenLibrHall.length; i++) {
            txt += "\nЗал: " + (i + 1) +
                    "\n\tКниги: " + chilrenLibrHall[i].toString();
        }
        return txt;
    }

    public ILibrary clone() {
        ILibrary newObj = new ChildrenLibrary(getCountHall());
        for (int i = 0; i < newObj.getCountHall(); i++) {
            newObj.changeHall(i, this.getHall(i).clone());
        }
        return newObj;
    }
}
