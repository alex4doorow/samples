package ru.skillfactory.demo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.skillfactory.demo.tgbot.config.JpaConfig;
import ru.skillfactory.demo.tgbot.entity.MyObj;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class MyObjRepositoryTest {

    // некий dao-сервис с нашим объектом, просто абстрактно, для примера
    @Resource
    private MyObjRepository myObjRepository;

    @Test
    public void givenObj_whenSave_thenGetOk() {
        // создали объект, чем-то его заполнили
        MyObj myObj = new MyObj(1L, "hello");
        // сохранили в базу
        myObjRepository.save(myObj);
        // нашли объект в базе
        MyObj myObjFound = myObjRepository.findById(1L).get();
        // проверили, что это действительно он
        assertEquals("hello", myObjFound.getMessage());
    }
}
