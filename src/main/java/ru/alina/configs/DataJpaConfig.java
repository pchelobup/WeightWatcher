package ru.alina.configs;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "ru.alina.repository")
@PropertySource("classpath:db.properties")
public class DataJpaConfig {
    @Autowired
    private Environment env;


    @Bean
    @Profile("default")
    public DataSource dataSourcePostgres() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername( env.getProperty("db.username") );
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }



    @Bean
    @Profile("default")
    public JpaVendorAdapter jpaVendorAdapterPostgres() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    @Profile("hsql")
    public DataSource dataSourceHSQL() {
        EmbeddedDatabaseBuilder dataSource = new EmbeddedDatabaseBuilder();
        return dataSource.setType(EmbeddedDatabaseType.HSQL).addScript("classpath:db/initHSQL.sql").build();
    }

    @Bean
    @Profile("hsql")
    public JpaVendorAdapter jpaVendorAdapterHsql() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.HSQL);
        adapter.setGenerateDdl(true);
        return adapter;
    }



    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEMF(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.format_sql", true);
        jpaProperties.put("hibernate.use_sql_comments", true);

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("ru.alina.model");// JPA entity classes will be loaded from this package
        emf.setJpaProperties(jpaProperties);

        return emf;
    }
}
