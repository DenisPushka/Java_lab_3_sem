package lab_4;

public class ListLibraryHall {
    private Item2 head;
    private Item2 tail;
    private int size;

    // Геттер
    public int getSize() {
        return size;
    }

    // Конструктор
    // По умолчанию
    public ListLibraryHall() {
        head = new Item2(new ScientificLibraryHall());
        tail = new Item2(new ScientificLibraryHall());
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
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
    // элемент не найден
    public Item2 returnItem(int number) {
        if (number > size || number < 0) {
            System.out.println("\nЭлемент в списке отсутствует\n");
            return null;
        }

        Item2 element = head.next;
        for (int i = 0; i <= size; i++) {
            if (number == i) {
                return element;
            }
            element = element.next;
        }
        return null;
    }

    // Добавление элемента по заданному номеру возвращает (true/false)
    public boolean add(ScientificLibraryHall hall, int number) {
        if (number > size + 1 || number < 0) {
            System.out.println("\nЭлемент не входит в числовой отрезок от 0 до size\n");
            return false;
        }

        Item2 newHall = new Item2(hall);
        Item2 buff = head;
        for (int i = 0; i < number - 1; i++) {
            buff = buff.next;
        }
        newHall.next = buff.next;
        newHall.prev = buff;
        buff.next.prev = newHall;
        buff.next = newHall;
        size++;
        return true;
    }

    // Удаление элемента по заданному номеру возвращает (true/false)
    public boolean remove(int number) {
        if (number > size || number < 0) {
            System.out.println("\nЭлемент не входит в числовой отрезок от 0 до size\n");
            return false;
        }

        Item2 buff = head;
        for (int i = 0; i < number - 1; ++i) {
            buff = buff.next;
        }
        buff.next.next.prev = returnItem(number).prev;
        buff.next = returnItem(number).next;
        size--;
        return true;
    }

}
