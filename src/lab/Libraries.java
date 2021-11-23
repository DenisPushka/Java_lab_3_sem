package lab;


import lab.Interface.IBook;
import lab.Interface.IHall;
import lab.Interface.ILibrary;
import lab.lab_3.Book;
import lab.lab_3.ChildrenLibrary;
import lab.lab_3.ScientificBook;
import lab.lab_4.ScientificLibraryHall;

import java.io.*;
import java.util.Scanner;

import static java.io.StreamTokenizer.TT_WORD;


public class Libraries {

    private static final int TABULATION = '\t';
    private static final int END_OF_LINE = '\n';

    // Записи данных о библиотеке в байтовый поток
    public static void outputLibrary(ILibrary lib, OutputStream out) throws IOException {
        DataOutputStream outData = new DataOutputStream(out);
        outData.writeInt(lib.getCountHall());
        for (int i = 0; i < lib.getCountHall(); i++) {
            outData.writeInt(lib.getHall(i).getCountBook());
            for (int j = 0; j < lib.getHall(i).getCountBook(); j++) {
                outData.writeBytes(lib.getHall(i).getBook(j).getAuthor());
                outData.writeBytes(lib.getHall(i).getBook(j).getNameBook());
                outData.writeDouble(lib.getHall(i).getBook(j).getPrice());
                outData.writeInt(lib.getHall(i).getBook(j).getYear());
            }
        }
    }

    // Чтения данных о библиотеке из байтового потока
    public static ILibrary inputLibrary(InputStream in) throws IOException {
        DataInputStream inData = new DataInputStream(in);
        IHall[] hallArr = new IHall[inData.readInt()];
        for (int i = 0; i < hallArr.length; i++) {
            IBook[] bookArr = new IBook[inData.readInt()];
            for (int j = 0; j < bookArr.length; j++) {
                bookArr[j] = new Book();
                bookArr[j].setAuthor(inData.readUTF());
                bookArr[j].setNameBook(inData.readUTF());
                bookArr[j].setPrice(inData.readDouble());
                bookArr[j].setYear(inData.readInt());
            }
            hallArr[i] = new ScientificLibraryHall(bookArr);
        }
        return new ChildrenLibrary(hallArr);
    }

    // Записи библиотеки в символьный поток
    public static void writeLibrary(ILibrary lib, Writer out) throws IOException {
        PrintWriter prOut = new PrintWriter(out);
        prOut.write(lib.getCountHall() + "\n");
        for (int i = 0; i < lib.getCountHall(); i++) {
            prOut.write(lib.getHall(i).getCountBook() + "\n");
            for (int j = 0; j < lib.getHall(i).getCountBook(); j++) {
                prOut.write(lib.getHall(i).getBook(j).getNameBook() + "\t" +
                        lib.getHall(i).getBook(j).getPrice() + "\t" +
                        lib.getHall(i).getBook(j).getAuthor() + "\t" +
                        lib.getHall(i).getBook(j).getYear() + "\n");
            }
        }
        out.flush();
    }

    // Чтения библиотеки из символьного потока
    public static ILibrary readLibrary(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        IHall[] halls = new IHall[(int) tokenizer.nval];
        String strBuff = "";
        for (int i = 0; i < halls.length; i++) {
            tokenizer.nextToken();
            IBook[] books = new IBook[(int) tokenizer.nval];
            for (int j = 0; j < books.length; j++) {
                books[j] = new ScientificBook();
                tokenizer.nextToken();
                // Считываем словосочетание
                while (tokenizer.ttype == TT_WORD &&
                        tokenizer.ttype != TABULATION &&
                        tokenizer.ttype != END_OF_LINE) {
                    strBuff += tokenizer.sval + " ";
                    tokenizer.nextToken();
                }
                books[j].setNameBook(strBuff);
                strBuff = "";

                tokenizer.nextToken();
                books[j].setPrice(tokenizer.nval);
                // Считываем словосочетание
                while (tokenizer.ttype == TT_WORD &&
                        tokenizer.ttype != TABULATION &&
                        tokenizer.ttype != END_OF_LINE) {
                    strBuff += tokenizer.sval + " ";
                    tokenizer.nextToken();
                }
                books[j].setAuthor(strBuff);
                strBuff = "";
                books[j].setYear((int) tokenizer.nval);
            }
            halls[i] = new ScientificLibraryHall(books);
        }
        return new ChildrenLibrary(halls);
    }

    // Метод сериализация библиотеки в байтовый поток
    public static void serializeLibrary(ILibrary library, OutputStream out) throws IOException {
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject(library);
        objOut.flush();
    }

    // Метод десериализации библиотеки из байтового потока
    public static ILibrary deserializeLibrary(InputStream in) throws IOException, ClassNotFoundException {
        return (ILibrary) new ObjectInputStream(in).readObject();
    }

    //метод текстовой записи
    public static void writeLibraryFormat(ILibrary library, Writer out) {
        PrintWriter formOut = new PrintWriter(out);
        formOut.print(library.getCountHall());
        for (int i = 0; i < library.getCountHall(); i++) {
            formOut.print(library.getHall(i).getCountBook());
            for (int j = 0; j < library.getHall(i).getCountBook(); j++) {
                formOut.print(library.getHall(i).getBook(j).getAuthor());
                formOut.print(library.getHall(i).getBook(j).getNameBook());
                formOut.print(library.getHall(i).getBook(j).getPrice());
                formOut.print(library.getHall(i).getBook(j).getYear());
            }
        }
    }

    public static ILibrary readLibrary(Scanner in) throws FileNotFoundException {
        IHall[] halls = new IHall[in.nextInt()];
        for (int i = 0; i < halls.length; i++) {
            IBook[] books = new IBook[in.nextInt()];
            for (int j = 0; j < books.length; i++) {
                books[j] = new Book();
                books[j].setAuthor(in.next());
                books[j].setNameBook(in.next());
                books[j].setPrice(in.nextDouble());
                books[j].setYear(in.nextInt());
            }
            halls[i] = new ScientificLibraryHall(books);
        }
        return new ChildrenLibrary(halls);
    }
}