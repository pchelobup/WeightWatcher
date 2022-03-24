package ru.alina.configs;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "ru.alina.repository")
@Profile("default")
public class DataJpaPostgresConfig {

    @Bean
    public DataSource dataSourcePostgres() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/weight");
        dataSource.setUsername( "postgres" );
        dataSource.setPassword( "1234" );
        return dataSource;
    }



    @Bean
    public JpaVendorAdapter jpaVendorAdapterPostgres() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setGenerateDdl(true);
        return adapter;
    }



    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEMF(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("ru.alina.model");// JPA entity classes will be loaded from this package
        return emf;
    }
}
