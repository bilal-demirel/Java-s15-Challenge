import com.library.app.Book;
import com.library.app.Library;
import com.library.app.Member;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book lotr = new Book(1, "J.R.R Tolkien", "Yüzüklerin Efendisi: Yüzük Kardeşliği", "Roman", 100);
        Book harryPotter = new Book(2, "J.K. Rowling", "Harry Potter: Felsefe Taşı", "Roman",125);
        Book dune = new Book(3, "Frank Herbert", "Dune", "Roman",180);
        Book faydaliBeslenme = new Book(4, "Bilal Demirel", "Faydalı Beslenme", "Eğitici",50);
        Book lotrII = new Book(5, "J.R.R Tolkien", "Yüzüklerin Efendisi: İki Kule", "Roman", 135);
        Book beyazDis = new Book(6, "Jack London", "Beyaz Diş", "Roman", 80);
        Book inci = new Book(7, "John Steinbeck", "İnci", "Roman", 110);
        Book mutfakSirlari = new Book(8, "Anthony Bourdain", "Mutfak Sırları", "Eğitici", 300);

        Member bilal = new Member(1, "Bilal");
        Member ecem = new Member(2, "Ecem");
        Member dogancan = new Member(3, "Doğancan");
        Member isis = new Member(4, "Isis");
        Member medusa = new Member(5,"Medusa");
        Member soboi = new Member(6, "Soboi");

        // 5 kitapı da kütüphanemize ekliyoruz.
        library.addBook(lotr);
        library.addBook(dune);
        library.addBook(harryPotter);
        library.addBook(faydaliBeslenme);
        library.addBook(lotrII);
        library.addBook(beyazDis);
        library.addBook(inci);
        library.addBook(mutfakSirlari);

        library.displayBooks();
        library.removeBookByID(3);
        library.displayBooks();
        library.displayBookByID(1); // Olan kitap.
        library.displayBookByID(2); // Olan kitap.
        library.displayBookByID(3); // Olmayan kitap.
        library.displayBooksByAuthor("J.R.R Tolkien"); // Olan yazar.
        library.displayBooksByAuthor("Lionel Messi"); // Olmayan yazar.
        library.displayBookByName("İnci"); // Olan kitap.
        library.displayBookByName("Dune"); // Olmayan kitap.
        library.displayBookByCategory("Roman"); // Olan kategori.
        library.displayBookByCategory("Çizgi Roman"); // Olmayan kategori.
        lotr.setPrice(250);
        library.removeByCategory("Eğitici"); // Olan kategori
        library.removeByCategory("Çizgi Roman"); // Olmayan kategori
        library.displayBooks(); // Kalan kitapların kotnrolü

        //Ödünç alma sistemi
        bilal.borrowBookByBook(library, lotr);
        ecem.borrowBookByBook(library, lotr);
        ecem.borrowBookByBook(library, lotrII);
        isis.borrowBookByBook(library, dune);
        isis.borrowBookByBook(library, beyazDis);
        ecem.returnBook(library, lotrII); // Kitabın geri iadesi.
        ecem.returnBook(library, dune); // Elinde olmayan kitabın iade edilmeye çalışılması.
        library.displayBookBorrowerMap(); // Ödünç alınan kitaplar

        //faturalar
        library.displayBills();
    }
}