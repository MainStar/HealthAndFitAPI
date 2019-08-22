package healthAndFitAPI.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MySQLConfigs {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String mysqlHost;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DatabaseConection databaseConection(){
        DatabaseConection databaseConection = new DatabaseConection();
        databaseConection.setDriverClassName(driverClassName);
        databaseConection.setHost(mysqlHost);
        databaseConection.setUserName(userName);
        databaseConection.setPassword(password);
        return databaseConection;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
