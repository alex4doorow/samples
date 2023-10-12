package ru.skillfactory.demo.tgbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.demo.tgbot.entity.MyObj;

@Repository
public interface MyObjRepository extends JpaRepository<MyObj, Long> {
}
