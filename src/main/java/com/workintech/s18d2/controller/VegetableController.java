package com.workintech.s18d2.controller;

import com.workintech.s18d2.Validation;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getList(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetable(@PathVariable("id") long id){
        Validation.isIdValid(id);
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getDescList(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable){
        Validation.isVariablesExist(vegetable);
        return vegetableService.save(vegetable);
    }

    @GetMapping("/name/{vegetable}")
    public List<Vegetable> findByName(@PathVariable("vegetable") String name){
        Validation.stringIsValid(name);
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable("id") long id){
        Validation.isIdValid(id);
        return vegetableService.delete(id);
    }
}
