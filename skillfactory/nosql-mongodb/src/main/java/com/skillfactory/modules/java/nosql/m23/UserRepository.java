package com.skillfactory.modules.java.nosql.m23;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByFirstName(String firstName);
    public List<User> findByEmail(String email);
    Long deletePersonByFirstName(String firstName);

}
