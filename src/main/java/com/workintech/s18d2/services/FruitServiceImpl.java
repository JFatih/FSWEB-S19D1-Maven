package com.workintech.s18d2.services;

import com.workintech.s18d2.Validation;
import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit getById(long id) {
        if(fruitRepository.findById(id).isEmpty()){
            Validation.isIdExist();
        }
        return fruitRepository.findById(id).get();
    }

    @Override
    public Fruit save(Fruit fruit) {
        Optional<Fruit> foundFruit = fruitRepository.findById(fruit.getId());
            return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if (optionalFruit.isEmpty()) {
            Validation.isIdExist();
        }
        Fruit deletedFruit = optionalFruit.get();
        fruitRepository.deleteById(id);

        return deletedFruit;
    }
}
