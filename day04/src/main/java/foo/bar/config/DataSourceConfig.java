package foo.bar.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by blvp on 10.04.15.
 */
@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("postgres");
        comboPooledDataSource.setPassword("postgres");
        comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/eventdb");
        comboPooledDataSource.setDriverClass("org.postgresql.Driver");
        return comboPooledDataSource;
    }
}
