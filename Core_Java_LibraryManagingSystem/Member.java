package onkar.Core_Java_LibraryManagingSystem;

import java.util.ArrayList;

class Member {
    private String name;
    private ArrayList<Loan> loans;

    public Member(String name) {
        this.name = name;
        this.loans = new ArrayList<>();
    }

    public void borrowBook(Book book, String dueDate) {
        if (book.isAvailable()) {
            loans.add(new Loan(book, dueDate));
            book.setAvailable(false);
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, the book is not available.");
        }
    }

    public void returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loans.remove(loan);
                book.setAvailable(true);
                System.out.println(name + " returned the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("You haven't borrowed this book.");
    }
}