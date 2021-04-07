package org.cnu.realcoding.homework.myfirstspringbootapp8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DogFindDuplication extends RuntimeException{

}
