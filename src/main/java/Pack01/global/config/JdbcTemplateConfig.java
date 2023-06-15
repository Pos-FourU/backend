package Pack01.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.yml")
public class JdbcTemplateConfig {

    private final String url;
    private final String user;
    private final String password;
    private final String driveClassName;

    public JdbcTemplateConfig(@Value("${datasource.url}")String url
            ,@Value("${datasource.username}") String user
            ,@Value("${datasource.password}") String password
            ,@Value("${datasource.driveClassName}") String driveClassName) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.driveClassName = driveClassName;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/fouru?serverTimezon=UTC");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}