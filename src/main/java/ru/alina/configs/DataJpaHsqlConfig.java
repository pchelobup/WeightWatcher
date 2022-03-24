package ru.alina.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "ru.alina.repository")
@Profile("hsql")
public class DataJpaHsqlConfig {

    @Bean
    public DataSource dataSourceHSQL() {
        EmbeddedDatabaseBuilder dataSource = new EmbeddedDatabaseBuilder();
        return dataSource.setType(EmbeddedDatabaseType.HSQL).addScript("classpath:db/initHSQL.sql").build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapterHsql() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.HSQL);
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
