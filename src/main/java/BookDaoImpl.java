import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
    private Connection connection;
    public BookDaoImpl(Connection connection){
        this.connection = connection;

    }
    @Override
    public void addBook(Book book) {
        try(PreparedStatement statement = connection.prepareStatement("INSERT * FROM books(title,author,price) VALUES (?,?,?)")){
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(int id) {

    }

    @Override
    public Book getBookById(int BookId) {
        Book book = null;
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE bookId = ?")){
            statement.setInt(1, BookId);
            try(ResultSet rs = statement.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("bookId");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    double price = rs.getDouble("price");
                    book = new Book(id, title, author, price);
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE bookId = ?")){

            try(ResultSet rs = statement.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("bookId");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    double price = rs.getDouble("price");
                    Book book = new Book(id, title, author, price);
                    books.add(book);
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }
}
