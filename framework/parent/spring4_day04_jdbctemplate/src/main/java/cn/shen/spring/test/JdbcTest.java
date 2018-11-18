package cn.shen.spring.test;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTest {
    public static void main(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///itcastspring");
        dataSource.setUsername("root");
        dataSource.setPassword("1998");

        //2.创建jdbctemplate实例
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //等同于
//		jdbcTemplate.setDataSource(dataSource)

        //3.执行sql，创建表test001
        jdbcTemplate.execute("create table test001(id int,name varchar(20))");
    }
}
