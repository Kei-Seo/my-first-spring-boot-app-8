package org.cnu.realcoding.homework.myfirstspringbootapp8.service;
import lombok.Getter;
import org.cnu.realcoding.homework.myfirstspringbootapp8.exception.DogNotFoundException;
import org.cnu.realcoding.homework.myfirstspringbootapp8.domain.Dog;
import org.cnu.realcoding.homework.myfirstspringbootapp8.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//new 키워트를 자동으로 붙여줘
@Service
public class DogManagementService {
    @Getter
    @Autowired
    private DogRepository dogRepository;


    //강아지를 찾아서 리턴해준다.
    public Dog getDogByName(String name) {
        Dog dog = dogRepository.findDogByName(name);
        if(dog == null)
        throw new DogNotFoundException();
        return dog;
    }

    public Dog getDogByOwnerName(String ownerName) {
        Dog dog = dogRepository.findDogByOwnerName(ownerName);
        if(dog == null)
            throw new DogNotFoundException();
        return dog;
    }

    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        Dog dog = dogRepository.findDogByOwnerPhoneNumber(ownerPhoneNumber);
        if(dog == null)
            throw new DogNotFoundException();
        return dog;
    }

    public Dog getDogByAllInfo(String name, String ownerName, String ownerPhoneNumber) {
        List<Dog> dogs=dogRepository.findAllDog();
        Dog dog=null;
        for(Dog value : dogs) {
            if(value.getOwnerPhoneNumber().equals(ownerPhoneNumber)&&
            value.getName().equals(name)&&value.getOwnerName().equals(ownerName)){
                dog=value;
                break;
            }
        }

        if(dog == null)
            throw new DogNotFoundException();
        return dog;
    }

    public void insertDog(Dog dog) {
        List<Dog> dogs = dogRepository.findAllDog();
        Dog find_dog = null;
        for(Dog value : dogs) {
            if(value.getOwnerPhoneNumber().equals(dog.getOwnerPhoneNumber())&&
                    value.getName().equals(dog.getName())&&value.getOwnerName().equals(dog.getOwnerName())){
                throw new DogNotFoundException();
            }
        }
        dogRepository.insertDog(dog);
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAllDog();
    }


}
