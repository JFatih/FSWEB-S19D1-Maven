package com.workintech.s18d2.controller;

import com.workintech.s18d2.Validation;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getFruitList(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getFruitById(@PathVariable("id") long id){
        Validation.isIdValid(id);
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitOrderDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit){
        Validation.isIdValid(fruit.getId());
        Validation.isVariablesExist(fruit);
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{fruit}")
    public List<Fruit> nameFilter(@PathVariable("fruit") String name){
        Validation.stringIsValid(name);
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable("id") long id){
        Validation.isIdValid(id);
        return fruitService.delete(id);
    }
}
