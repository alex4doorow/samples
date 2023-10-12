package ru.skillfactory.demo.tgbot.repository;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.skillfactory.demo.tgbot.MyPostgresqlContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRepositoryTestContainersTest {

    // получаем контейнер для использования в тестах
    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = MyPostgresqlContainer.getInstance();

    // и пишем наши тесты!
}
