package lab_4;

import libraries.ScientificBook;

class Item {
    public ScientificBook data; // данные
    public Item next; // ссылка на такой же следующий элемент

    // Конструктор
    public Item(ScientificBook data){
        this.data = data;
        next = null;
    }
}