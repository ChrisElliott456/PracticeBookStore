import java.sql.Connection;
import java.util.List;

public class BookDaoImpl implements BookDao{
    private Connection connection;
    public BookDaoImpl(Connection connection){
        this.connection = connection;

    }
    @Override
    public void addBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(int id) {

    }

    @Override
    public Book getBookById(int BookId) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }
}
