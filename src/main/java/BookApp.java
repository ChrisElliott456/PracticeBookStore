import java.util.Scanner;

public class BookApp {
    private static BookDao bookDao = new BookDaoImpl(JDBConnection.getConnection());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    Welcome to the Book Store App!
                    Please choose one of the following:
                    1. Add a new book
                    2. Update a book
                    3. Delete a book
                    4. Display a book
                    5. Display all books
                    6. Exit Application
                    """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBook(sc);
                    break;
                case 3:
                    deleteBook(sc);
                    break;
                case 4:
                    getBookById(sc);
                    break;
                case 5:
                    getAllBooks(sc);
                    break;
                case 6:
                    System.out.println("Exiting application...");
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void getAllBooks(Scanner sc) {
        for (Book book : bookDao.getAllBooks()){
            System.out.println(book);
        }
    }

    private static void getBookById(Scanner sc) {
        System.out.println("Please enter Book ID: ");
        int bookId = sc.nextInt();
        Book book = bookDao.getBookById(bookId);
        if (book == null){
            System.out.println("Book not found.");
        }
        System.out.println(book);
    }

    private static void deleteBook(Scanner sc) {
    }

    private static void updateBook(Scanner sc) {
    }

    private static void addBook(Scanner sc) {
        System.out.println("Enter book title: ");
        String title = sc.nextLine();
        System.out.println("Enter book author: ");
        String author = sc.nextLine();
        System.out.println("Enter book price: ");
        double price = sc.nextDouble();

        Book book = new Book(title, author, price);
        bookDao.addBook(book);
        System.out.println("Successfully added book.");
    }
}
