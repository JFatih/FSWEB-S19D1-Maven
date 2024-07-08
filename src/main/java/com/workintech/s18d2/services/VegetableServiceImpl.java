package com.workintech.s18d2.services;

import com.workintech.s18d2.Validation;
import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository){
        this.vegetableRepository = vegetableRepository;
    }


    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable getById(long id) {
        if(vegetableRepository.findById(id).isEmpty()){
            Validation.isIdExist();
            return null;
        }else{
            return vegetableRepository.findById(id).get();
        }
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        if (optionalVegetable.isEmpty()) {
            Validation.isIdExist();
        }
        Vegetable deletedVegetable = optionalVegetable.get();
        vegetableRepository.deleteById(id);

        return deletedVegetable;
    }
}
