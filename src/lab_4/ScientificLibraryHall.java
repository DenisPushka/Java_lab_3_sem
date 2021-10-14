package lab_4;

import libraries.ScientificBook;

public class ScientificLibraryHall {
    private String nameHall;
    private List scienceBook; // = new List();?

    // Геттеры и сеттеры
    public List getScienceBook() {
        return scienceBook;
    }

    public void setScienceBook(List scienceBook) {
        this.scienceBook = scienceBook;
    }

    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    // Конструкторы
    // По умолчанию
    public ScientificLibraryHall(){
        nameHall = "";
        scienceBook = new List();
    }

    // Принимает имя зала и кол-во книг в зале
    public ScientificLibraryHall(String nameHall, int count) {
        this.nameHall = nameHall;
        scienceBook = new List();
        for (int i = 0; i < count; i++) {
            scienceBook.add(new ScientificBook(), i);
        }
    }

    // Принимает имя зала и массив книг
    public ScientificLibraryHall(String nameHall, ScientificBook[] book) {
        this.nameHall = nameHall;
        scienceBook = new List();
        for (int i = 0; i < book.length; i++) {
            scienceBook.add(book[i], i + 1);
        }
    }

    // Методы
    // получения количества книг в зале
    public int countBook() {
        return scienceBook.countItem();
    }

    // Выводящий на экран список названий всех книг в зале
    public void showNameBook() {
        for (int i = 0; i < scienceBook.countItem(); i++) {
            System.out.println(scienceBook.returnItem(i).data.getAuthor());
        }
    }

    // Получения общей стоимости всех книг в зале
    public double allPriceBook() {
        double sum = 0;
        for (int i = 0; i < scienceBook.countItem(); i++) {
            sum += scienceBook.returnItem(i).data.getPrice();
        }
        return sum;
    }

    // Получения книги по ее номеру в зале номеру (возвращает null, если
    //элемент не найден)
    public ScientificBook getScientificBook(int number) { return scienceBook.returnItem(number).data; }

    // Изменения книги по ее номеру
    public void changeBook(int number, ScientificBook newBook) {
        scienceBook.returnItem(number).data = newBook;
        System.out.println("Данные изменены");
    }

    // Добавления книги по номеру
    public boolean addBook(ScientificBook book, int number) {
        if (scienceBook.add(book,number)){
            System.out.println("\nКнига добавлена");
            return true;
        }
        return false;
        //альтернатива: return scienceBook.add(book,number);
    }

    // Удаления книги по номеру
    public boolean removeBook(int number){
        if (scienceBook.remove(number)){
            System.out.println("\nКнига успешно удалена");
            return true;
        }
        return false;
    }

    // Книга с самой высокой стоимостью
    public ScientificBook getBestBook(){
        ScientificBook maxPrice = scienceBook.returnItem(0).data;
        for (int n = 0;n < scienceBook.getSize();n++){
            if(maxPrice.getPrice()<scienceBook.returnItem(n).data.getPrice()){
                maxPrice = scienceBook.returnItem(n).data;
            }
        }
        return maxPrice;
    }

    @Override
    public String toString() {
        String txt = "";
        for (int k = 0; k < scienceBook.countItem(); k++) {
            txt += "\n\t\tНзвание: " + scienceBook.returnItem(k).data.getNameBook() ;
            txt += "\tАвтор: " + scienceBook.returnItem(k).data.getAuthor() ;
            txt += "\t\tЦена: " + scienceBook.returnItem(k).data.getPrice() ;
            txt += "\t\tГод издания: " + scienceBook.returnItem(k).data.getYear() ;
        }
        return txt;
    }
}