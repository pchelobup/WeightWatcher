package ru.alina.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.alina.configs.DataJpaConfig;
import ru.alina.configs.RootConfig;

@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ContextConfiguration(classes = {DataJpaConfig.class, RootConfig.class})
@ActiveProfiles("hsql")
@ExtendWith(SpringExtension.class)
public abstract class ServiceTest {

}
