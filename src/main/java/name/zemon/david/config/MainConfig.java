package name.zemon.david.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import name.zemon.david.pojo.Person;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by david on 9/8/15.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {
        name.zemon.david.dao.SpringMarker.class,
        name.zemon.david.service.SpringMarker.class})
public class MainConfig {
    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://david.zemon.name:3306/intelliclipse");
        dataSource.setUser("intelliclipse");
        dataSource.setPassword("idea&eclipse");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(final DataSource dataSource, final Properties properties) {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan(Person.class.getPackage().getName());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public Properties properties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.driver", "com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://david.zemon.name:3306/intelliclipse");
        return properties;
    }
}
