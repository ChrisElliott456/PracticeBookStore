import java.util.List;

public interface BookDao {
    void addBook (Book book);
    void updateBook (Book book);
    void deleteBook (int id);
    Book getBookById (int BookId);
    List<Book> getAllBooks ();

}
