package spring5_2.dao;

import org.springframework.stereotype.Repository;
import spring5_2.entity.Book;

import java.util.List;

@Repository
public interface BookDao {
    //添加的方法
    public void add(Book book);

    //修改方法
    public void update(Book book);

    //删除方法
    public void delete(int id);

    //查询某一特定值
    public int selectCount(int id);

    //查询返回对象
    public Book selectBookInfo(int id);

    //批量修改
    public void batchAddBook(List<Object[]> batchArgs);
}
