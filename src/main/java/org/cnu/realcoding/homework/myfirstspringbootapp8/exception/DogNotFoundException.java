package org.cnu.realcoding.homework.myfirstspringbootapp8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogNotFoundException extends RuntimeException{

}
