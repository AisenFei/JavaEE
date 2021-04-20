package spring5_2.entity;

public class Book {
    private int bookId;
    private String bookName;
    private int bookCount;

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookCount=" + bookCount +
                '}';
    }

}
