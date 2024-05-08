package onkar.Core_Java_LibraryManagingSystem;


class Loan {
    private Book book;
    private String dueDate;
    private boolean isReturned;

    public Loan(Book book, String dueDate) {
        this.book = book;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public Book getBook() {
        return book;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}