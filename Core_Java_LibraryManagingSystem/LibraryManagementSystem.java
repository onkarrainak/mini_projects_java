package onkar.Core_Java_LibraryManagingSystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("java book", "Rabindranath Tagore");
        Book book2 = new Book("Python book", "George S. Calson");
        Book book3 = new Book("Do Epic Shit", "Ankur Warikoo");

        // Create a library
        Library library = new Library();

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Create a member
        Member member1 = new Member("Onkar Rainak");
        Member member2 = new Member("Raj");

        // Member borrows a book
        member1.borrowBook(book1, new String());
        System.out.println();
        member1.borrowBook(book2, new String());
        System.out.println();

        // Member try to borrow the same book again
        member2.borrowBook(book1, new String());
        System.out.println();

        // Member returns a book
        member1.returnBook(book2);
        System.out.println();
        
        member2.borrowBook(book2, new String());
        System.out.println();
    }
}
