package name.zemon.david.common.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import name.zemon.david.common.dao.SpringMarker;
import name.zemon.david.common.pojo.Person;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by david on 9/13/15.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = SpringMarker.class)
@PropertySource("classpath:${environment}.properties")
public class DaoConfig {
    @Inject
    private Environment env;

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://david.zemon.name:3306/intelliclipse");
        dataSource.setUser("intelliclipse");
        dataSource.setPassword(this.env.getRequiredProperty("jdbc.password"));
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
