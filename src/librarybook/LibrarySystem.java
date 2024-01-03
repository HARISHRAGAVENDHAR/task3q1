package librarybook;
import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private Book[] books;
    private int totalBooks;

    public Library(int capacity) {
        books = new Book[capacity];
        totalBooks = 0;
    }

    public void addBook(Book book) {
        if (totalBooks < books.length) {
            books[totalBooks] = book;
            totalBooks++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void removeBook(int bookID) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getBookID() == bookID) {
                books[i].setAvailable(false);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBook(int bookID) {
        for (Book book : books) {
            if (book != null && book.getBookID() == bookID) {
                System.out.println("Book found:");
                System.out.println("Book ID: " + book.getBookID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        if (totalBooks == 0) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("Books in the library:");
        for (Book book : books) {
            if (book != null) {
                System.out.println("Book ID: " + book.getBookID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                System.out.println("--------------");
            }
        }
    }
}
public class LibrarySystem {
	public static void main(String[] args) {
		 Scanner Scanner = new Scanner(System.in);

	        System.out.println("Enter the capacity of the library:");
	        int capacity = Scanner.nextInt();
	        Library library = new Library(capacity);

	        while (true) {
	            System.out.println("\nLibrary System Menu:");
	            System.out.println("1. Add Book");
	            System.out.println("2. Remove Book");
	            System.out.println("3. Search Book");
	            System.out.println("4. Display Books");
	            System.out.println("5. Exit");

	            System.out.println("Enter your choice:");
	            int choice = Scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter Book ID:");
	                    int bookID = Scanner.nextInt();
	                    System.out.println("Enter Title:");
	                    String title = Scanner.next();
	                    System.out.println("Enter Author:");
	                    String author = Scanner.next();
	                    Book newBook = new Book(bookID, title, author);
	                    library.addBook(newBook);
	                    break;

	                case 2:
	                    System.out.println("Enter Book ID to remove:");
	                    int removeBookID = Scanner.nextInt();
	                    library.removeBook(removeBookID);
	                    break;

	                case 3:
	                    System.out.println("Enter Book ID to search:");
	                    int searchBookID = Scanner.nextInt();
	                    library.searchBook(searchBookID);
	                    break;

	                case 4:
	                    library.displayBooks();
	                    break;

	                case 5:
	                    System.out.println("Exiting Library System. Goodbye!");
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }
	

	}


