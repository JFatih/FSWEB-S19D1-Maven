package com.workintech.s18d2;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class Validation {

    public static void stringIsValid(String data){
        if(data == null || data.isEmpty()){
            throw new PlantException( data + " cannot be null or empty.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdValid(long id){
        if(id == 0){
            throw new PlantException("Value cannot be zero", HttpStatus.BAD_REQUEST);
        }else if(id < 0){
            throw new PlantException("Value cannot be less than zero", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdExist() {
        throw new PlantException("Id cannot exist", HttpStatus.BAD_REQUEST);
    }

    public static void isVariablesExist(Object obj){
        if(obj instanceof Fruit fruit){
            if(fruit.getName().isEmpty() || fruit.getFruitType() == null || fruit.getPrice() == 0){
                throw new PlantException("Variables cannot be null or empty", HttpStatus.BAD_REQUEST);
            }
        } else if (obj instanceof Vegetable vegetable) {
            if(vegetable.getName().isEmpty() || vegetable.getPrice() == 0){
                throw new PlantException("Variables cannot be null or empty", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
