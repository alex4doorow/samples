package com.skillfactory.modules.java.nosql.m23;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // Добавялем несколько пользователей
        saveUser("Tester", "Testerov","test@test.com","+1005224");
        saveUser("SecondUser", "His latName","test@test.com","+795001");
        saveUser("User", "ForUpdateAndDelete","rr@rr.com","+000000");
        updateUser("User","TERETRT");
        deleteUser("TERETRT");
        // Находим всех пользователей
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println();

        // Ищем конкретного пользователя
        System.out.println("Customer found with findByFirstName('Tester'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Tester"));

        System.out.println("Customers found with findByEmail('test@test.com'):");
        System.out.println("--------------------------------");
        for (User User : repository.findByEmail("test@test.com")) {
            System.out.println(User);
        }
    }

    void saveUser(String firstName, String lastName, String email, String phone) {
        repository.save(new User(firstName, lastName, email, phone));
    }

    void updateUser(String oldfirstName, String newfirstName) {
        User user = repository.findByFirstName(newfirstName);
        user.firstName = oldfirstName;
        repository.save(user);
    }

    void deleteUser(String firstName){
        repository.deletePersonByFirstName(firstName);
    }
}

