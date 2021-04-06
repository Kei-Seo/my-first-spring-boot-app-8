package org.cnu.realcoding.homework.myfirstspringbootapp8.controller;

import org.cnu.realcoding.homework.myfirstspringbootapp8.domain.Dog;
import org.cnu.realcoding.homework.myfirstspringbootapp8.service.DogManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//스프링에게 객체 생성을 위임한다.
@RestController
public class DogController {

    //필드로 선언되었는데 사용된적 없음
    @Autowired
    private DogManagementService dogManagementService;
    //자원을 생성한다.
    //스프링아 내가 Dog라는 자바 클래스를 만들었으니까 이걸로 제이슨을 만들어줘
    //service class로 전달해줘야한다.
    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDog(@RequestBody Dog dog){
        dogManagementService.insertDog(dog);
    }
    @GetMapping("/dogs")
    public List<Dog> getAllDogs(){
        return dogManagementService.getAllDogs();
    }

    //강아지 이름 가지고 호출
    @GetMapping("/dogs/{name}")
    public Dog getDogByName(@PathVariable String name){
        return dogManagementService.getDogByName(name);
    }

}
