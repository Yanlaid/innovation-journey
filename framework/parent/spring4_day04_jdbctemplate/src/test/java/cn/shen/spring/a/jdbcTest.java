package cn.shen.spring.a;

import cn.shen.spring.dao.BookDao;
import cn.shen.spring.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class jdbcTest {

    @Autowired
    /* private JdbcTemplate jdbcTemplate;*/
    private BookDao bookDao;

    @Test
    public void test1() {
        // jdbcTemplate.execute("create table test004(name varchar(20) )");
        Book book = new Book();
        book.setName("入门到删库");
        book.setPrice(99.8);
        bookDao.save(book);
    }

    @Test
    public void test2(){
        bookDao.queryAllBook();
    }
}
