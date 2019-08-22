package healthAndFitAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * Hello world!
 *
 */

@SpringBootApplication
public class Main
{
    public static void main( String[] args )
    {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://w1kr9ijlozl9l79i.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/r0pstcle29tb3ap0");
//        dataSource.setUsername("lhmq3ojllwqjef06");
//        dataSource.setUserPassword("q4rxd1nkz3755e0e");
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource);
//        jdbcTemplate.execute("SELECT * FROM r0pstcle29tb3ap0.users;");
        SpringApplication.run(Main.class, args);
    }
}
