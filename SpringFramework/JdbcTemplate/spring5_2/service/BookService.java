package spring5_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring5_2.dao.BookDao;
import spring5_2.entity.Book;

@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }

    public void updateBook(Book book){
        bookDao.update(book);
    }

    public void deleteBook(int id){
        bookDao.delete(id);
    }

    public int selectBookCount(int id){
        return bookDao.selectCount(id);
    }

    public Book selectBookInfo(int id){
        return bookDao.selectBookInfo(id);
    }
}
