import java.util.Arrays;
import java.util.Comparator;

class Book {
    private final int bookId;
    private final String title;
    private final String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + "]";
    }
}

class LibraryManagementSystem {
    private final Book[] books;
    private int count;

    public LibraryManagementSystem(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        }
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = count - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle));
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(10);

        Book b1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald");
        Book b2 = new Book(2, "1984", "George Orwell");
        Book b3 = new Book(3, "To Kill a Mockingbird", "Harper Lee");

        lms.addBook(b1);
        lms.addBook(b2);
        lms.addBook(b3);

        System.out.println("All Books:");
        for (int i = 0; i < 3; i++) {
            System.out.println(lms.books[i]);
        }

        System.out.println("Search by Title (Linear Search):");
        System.out.println(lms.linearSearchByTitle("1984"));

        lms.sortBooksByTitle();

        System.out.println("Search by Title (Binary Search):");
        System.out.println(lms.binarySearchByTitle("1984"));
    }
}
