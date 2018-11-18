package cn.shen.spring.dao;

import cn.shen.spring.pojo.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


public class BookDao extends JdbcDaoSupport {



    /*private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    public void save(Book book) {
        super.getJdbcTemplate().update("insert into Book values (null ,?,?)", book.getName(), book.getPrice());
    }


    public void queryAllBook(){
        List<Book> query = super.getJdbcTemplate().query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
        for (Book book : query) {

            System.out.println(book);
        }
    }
}
