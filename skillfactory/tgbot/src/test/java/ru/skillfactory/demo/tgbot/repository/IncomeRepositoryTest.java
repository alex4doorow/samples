package ru.skillfactory.demo.tgbot.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.skillfactory.demo.tgbot.entity.Income;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IncomeRepositoryTest {

    @Autowired
    private IncomeRepository incomeRepository;

    @BeforeEach
    public void beforeEach() {
        incomeRepository.deleteAll();
    }

    @Test
    public void testRepo() {
        //noinspection StatementWithEmptyBody
        for (int i = 0; i < 10; i++, incomeRepository.save(new Income()));
        final List<Income> found = incomeRepository.findAll();
        assertEquals(10, found.size());
    }

    @Test
    public void testDataScripts() {
        Optional<Income> income = incomeRepository.findById(12345L);
        assertTrue(income.isPresent());
        assertEquals(new BigDecimal(3800), income.get().getIncome());
    }
}