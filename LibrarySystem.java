import java.util.*;
import java.lang.Override;
/**
 * Represents a Library system allowing different book operations.
 */
public class Library {
    /**
     *the action to list all available books.
     */
    static final int LIST_BOOKS = 1;
    /**
     *the action to check out a book.
     */
    static final int CHECKOUT_BOOK = 2;
    /**
     *the action to return a book.
     */
    static final int RETURN_BOOK = 3;
    static final int QUERY_AUTHOR = 4;
    static final int QUERY_CATEGORY = 5;
    static final int QUIT = 6;
    /**
     * Stores the books in a map with their titles as keys and the Book objects as values.
     */
    static Map<String, Book> books = new HashMap<>();
    /**
     * Represents a book in the library with its author, category, and the number of copies.
     */
    public static class Book {
        String author;
        BookTypes type;
        int copies;
        /**
         * Initializes a Book object with provided author, category, and copies.
         */
        public Book(String author, BookTypes type, int copies) {
            this.author = author;
            this.type = type;
            this.copies = copies;
        }
        /**
         * Returns the author of the book.
         */
        public String getAuthor() {
            return author;
        }
        /**
         * Returns the category of the book.  
         */
        public BookTypes getCategory() {
            return type;
        }
        /**
         * Retrieves the number of copies available for the book.
         */
        public int getCopies() {
            return this.copies;
        }
        /**
         * Decrements the count of available copies when a book is checked out.
         */
        public void checkOut() {
            copies--;
        }
        /**
         * Increments the count of available copies when a book is returned.
         */
        public void returnTitle() {
            copies++;
        }
        /**
         * Return the book information in a string format.
         */
        @Override
        public String toString() {
            return "Author: " + author + "; " + "Category: " + type + "; " + "Copies: " + copies;
        }

        // These are only allowed values for BookType
        enum BookTypes { FICTION, NONFICTION, REFERENCE }
    }
    /**
     * Lists all available books in the library with their available copies.
     */
    static void listBooks() {
        for (Map.Entry<String, Book> book : books.entrySet()) {
            System.out.println("Book: " + book.getKey() + ", Copies of book available: " + book.getValue().getCopies());
        }
        System.out.println();
    }
    /**
     * Allows a user to check out a book based on its title.
     */
    static void checkoutBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to check out: ");
        String title = scanner.nextLine();

        if (books.containsKey(title)) {
            Book book1 = books.get(title);
            if (book1.getCopies() > 0) {
                book1.checkOut();
                System.out.println("Book '" + title + "' checked out successfully.");
            } else {
                System.out.println("Sorry, no copies of '" + title + "' available for checkout.");
            }
        } else {
            System.out.println("Book '" + title + "' not found in the library.");
        }
        System.out.println();
    }
    /**
     * Allows a user to return a book based on its title.
     */
    static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book you would like to return: ");
        String title = scanner.nextLine();

        if (books.containsKey(title)) {
            Book book1 = books.get(title);
            book1.returnTitle();
            System.out.println("Book '" + title + "' is in the library.");
        } else {
            System.out.println("Book '" + title + "' is not in the library.");
        }
        System.out.println();
    }
    /**
     * Displays all books by a particular author entered by the user.
     */
    static void queryAuthorBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the author's name: ");
        String author = scanner.nextLine();

        boolean found = false;
        for (Map.Entry<String, Book> book : books.entrySet()) {
            if (book.getValue().getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Title: " + book.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for author " + author);
        }
        System.out.println();
    }
    /**
     * Displays all books based on a specific category entered by the user.
     */
    static void queryType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category (FICTION, NONFICTION, REFERENCE): ");
        String categoryInput = scanner.nextLine().toUpperCase(); 

        boolean found = false;

        for (Book book : books.values()) {
            if (book.getCategory().toString().equals(categoryInput)) {
                for (Map.Entry<String, Book> entry : books.entrySet()) {
                    if (entry.getValue().equals(book)) {
                        System.out.println("Title: " + entry.getKey());
                        found = true;
                        break; // Once found it doesn't need to keep going
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No books found for category '" + categoryInput + "'.");
        }
        System.out.println();
    }
    /**
     * Populates the library with books.
     */
    static void catalogBooks() {
        books.put( "The Hobbit", new Book("Tolkien", Book.BookTypes.FICTION, 3 ));
        books.put( "The Fellowship of the Ring", new Book("Tolkien", Book.BookTypes.FICTION, 2 ));
        books.put( "The Two Towers", new Book("Tolkien", Book.BookTypes.FICTION, 1 ));
        books.put( "The Return of the King", new Book("Tolkien", Book.BookTypes.FICTION, 3 ));
        books.put( "Brief History of Time", new Book("Hawking", Book.BookTypes.NONFICTION, 2));
        books.put( "1984", new Book("Orwell", Book.BookTypes.FICTION, 10));
        books.put( "Animal Farm", new Book("Orwell", Book.BookTypes.FICTION, 8));
        books.put( "Catch-22", new Book("Heller", Book.BookTypes.FICTION, 6));
        books.put( "Anna Karenina", new Book("Tolstoy", Book.BookTypes.FICTION, 7));
        books.put( "War and Peace", new Book("Tolstoy", Book.BookTypes.FICTION, 6));
        books.put( "A Confession", new Book("Tolstoy", Book.BookTypes.FICTION, 5));
        books.put( "How to Win Friends and Influence People", new Book("Carnegie", Book.BookTypes.NONFICTION, 1));
        books.put( "Freakonomics", new Book("Levitt", Book.BookTypes.NONFICTION, 7));
        books.put( "Super Freakonomics", new Book("Levitt", Book.BookTypes.NONFICTION, 2));
        books.put( "Think like a freak", new Book("Levitt", Book.BookTypes.NONFICTION, 6));
        books.put( "Gray's Anatomy", new Book("Gray", Book.BookTypes.REFERENCE, 1));
    }
    /**
     * Displays the menu of choices for the user.
     */
    static void displayMenu() {
        System.out.println("Library choices: ");
        System.out.printf("%d: List available books\n", LIST_BOOKS);
        System.out.printf("%d: Checkout a book\n", CHECKOUT_BOOK);
        System.out.printf("%d: Return a book\n", RETURN_BOOK);
        System.out.printf("%d: Query an author\n", QUERY_AUTHOR);
        System.out.printf("%d: Query a category\n", QUERY_CATEGORY);
        System.out.printf("%d: Quit\n", QUIT);
    }
    /**
     * Main method that manages the library using user input.
     * It provides a menu and handles user's choices.
     */
    public static void main(String[] args) {
        catalogBooks();

        Scanner keyboard = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            boolean error = false;
            int choice = 0;
            try {
                choice = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, enter a valid choice.");
                keyboard.nextLine();
                error = true;
            }
            if (!error) {
                switch (choice) {
                    case LIST_BOOKS:
                        listBooks();
                        break;
                    case CHECKOUT_BOOK:
                        checkoutBook();
                        break;
                    case RETURN_BOOK:
                        returnBook();
                        break;
                    case QUERY_AUTHOR:
                        queryAuthorBooks();
                        break;
                    case QUERY_CATEGORY:
                        queryType();
                        break;
                    case QUIT:
                        quit = true;
                        break;
                    default:
                        System.out.println("Error: Please enter a valid choice.");
                }
            }
        }
        keyboard.close();
    }
}
