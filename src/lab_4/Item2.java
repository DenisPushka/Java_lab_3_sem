package lab_4;

class Item2 {
    public ScientificLibraryHall data; // данные
    public Item2 prev; // ссылка на такой же предыдущий элемент
    public Item2 next; // ссылка на такой же следующий элемент

    // Конструктор
    public Item2(ScientificLibraryHall data){
        this.data = data;
        prev = null;
        next = null;
    }
}
