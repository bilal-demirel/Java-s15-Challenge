import com.library.app.Book;
import com.library.app.Library;
import com.library.app.Member;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book lotr = new Book(1, "J.R.R Tolkien", "Yüzüklerin Efendisi: Yüzük Kardeşliği", "Bilim Kurgu", 100);
        Book harryPotter = new Book(2, "J.K. Rowling", "Harry Potter: Felsefe Taşı", "Bilim Kurgu",125);
        Book dune = new Book(3, "Frank Herbert", "Dune", "Bilim Kurgu",180);
        Book faydaliBeslenme = new Book(4, "Bilal Demirel", "Faydalı Beslenme", "Eğitici",50);
        Book lotrII = new Book(1, "J.R.R Tolkien", "Yüzüklerin Efendisi: İki Kule", "Bilim Kurgu", 135);

        library.addBook(lotr);
        library.addBook(dune);
        library.addBook(harryPotter);
        library.addBook(faydaliBeslenme);
        library.addBook(lotrII);

        System.out.println(library.getBooks());

        //library.removeBookByID(1);

        System.out.println(library.getBooks());
        System.out.println(library.getBookByID(2));
        System.out.println("Tolkien'e ait kitaplar: " + library.getBooksByAuthor("J.R.R Tolkien"));
        System.out.println(library.getBookByName("Dune"));
        System.out.println("Bilim Kurgu kategorisine ait kitaplar: " + library.getBooksByCategory("Bilim Kurgu"));

        lotr.setPrice(250);

        library.removeByCategory("Bilim Kurgu");
        System.out.println("Kalan Kitaplar: " + library.getBooks());

        Member bilal = new Member(1, "Bilal");
        Member ecem = new Member(2, "Ecem");
        bilal.borrowBookByBook(library, lotr);
        ecem.borrowBookByBook(library, lotr);
        ecem.borrowBookByBook(library, lotrII);
        ecem.returnBook(library, lotrII);
        System.out.println("Ödünç Alınan Kitaplar: ");

        library.displayBookBorrowerMap(library);

    }
}