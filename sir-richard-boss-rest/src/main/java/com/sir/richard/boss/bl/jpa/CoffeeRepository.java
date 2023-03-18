package com.sir.richard.boss.bl.jpa;

import com.sir.richard.boss.bl.entity.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
