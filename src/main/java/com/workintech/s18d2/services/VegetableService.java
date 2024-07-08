package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VegetableService {

    List<Vegetable> getByPriceDesc();

    List<Vegetable> getByPriceAsc();

    List<Vegetable> searchByName(String name);

    Vegetable getById(long id);

    Vegetable save(Vegetable vegetable);

    Vegetable delete(long id);

}
