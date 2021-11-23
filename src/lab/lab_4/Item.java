package lab.lab_4;

import lab.Interface.IBook;

class Item {
    public IBook data; // данные
    public Item next; // ссылка на такой же следующий элемент

    // Конструктор
    public Item(IBook data) {
        this.data = data;
        next = null;
    }
}