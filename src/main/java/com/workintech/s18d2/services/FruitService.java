package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FruitService {

    List<Fruit> getByPriceDesc();

    List<Fruit> getByPriceAsc();

    List<Fruit> searchByName(String name);

    Fruit getById(long id);

    Fruit save(Fruit fruit);

    Fruit delete(long id);
}
