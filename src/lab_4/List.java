package lab_4;

import libraries.ScientificBook;

public class List {
    private Item head;
    private int size ;

    //Геттер
    public int getSize() {
        return size;
    }

    //Конструктор
    // По умолчанию
    public List() {
        head = new Item(new ScientificBook());
        head.next = head;
    }

    // Методы
    // Пустой список или нет
    public boolean isEmpty() {
        return size == 0;
    }

    // Возвращающий количество элементов
    public int countItem() {
        return size;
    }

    // Возвращающий ссылку на элемент по номеру (возвращает null, если
    //элемент не найден)
    public Item returnItem(int number) {
        if (number > size || number < 0) {
            System.out.println("\nЭлемент в списке отсутствует\n");
            return null;
        }

        Item element = head.next;
        for (int i = 0; i <= size; i++) {
            if (number == i) {
                return element;
            }
            element = element.next;
        }
        return null;
    }

    // Добавление элемента по заданному номеру возвращает (true/false)
    public boolean add(ScientificBook book, int number) {
        if (number > size + 1 || number < 0) {
            System.out.println("\nЭлемент не входит в числовой отрезок от 0 до size\n");
            return false;
        }

        Item newBook = new Item(book);
        Item buff = head;
        for (int i = 0; i < number - 1; ++i) {
            buff = buff.next;
        }
        newBook.next = buff.next;
        buff.next = newBook;
        size++;
        return true;
    }

    // Удаление элемента по заданному номеру возвращает (true/false)
    public boolean remove(int number) {
        if (number > size || number < 0) {
            System.out.println("\nЭлемент не входит в числовой отрезок от 0 до size\n");
            return false;
        }

        Item buff = head;
        for (int i = 0; i < number - 1; ++i) {
            buff = buff.next;
        }
        buff.next = returnItem(number).next;
        size--;
        return true;
    }

    @Override
    public String toString() {
        String txt = "";
        Item element = head.next;
        for (int k = 0; k <= size; k++) {
            txt += element.data.getNameBook() + "\n";
            element = element.next;
        }
        return txt;
    }
}
