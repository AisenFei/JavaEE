package spring5_2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring5_2.entity.Book;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImp1 implements BookDao{

    //注入jabcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book){
        //1.创建sql语句
        String sql = "insert into book values(?,?,?)";
        //2.调用方法实现
        Object[] args = {book.getBookId(),book.getBookName(),book.getBookCount()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void update(Book book) {
        //1.创建SQL语句
        String sql = "update book set bookName=?,bookCount=? where bookId=?";
        //2.调用方法实现
        //按照占位符顺序写数组
        Object[] objs = {book.getBookName(),book.getBookCount(),book.getBookId()};
        int update = jdbcTemplate.update(sql, objs);
        System.out.println(update);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from book where bookId=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int selectCount(int id){
        String sql = "select count(*) from book where bookId=?";
        int res = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return res;
    }

    @Override
    public Book selectBookInfo(int id) {
        String sql = "select * from book where bookId=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        System.out.println(book);
        return null;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
