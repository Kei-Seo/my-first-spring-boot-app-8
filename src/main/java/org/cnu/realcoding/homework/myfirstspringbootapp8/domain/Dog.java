package org.cnu.realcoding.homework.myfirstspringbootapp8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {

    private String name;
    private String kind;
    private String ownerName;
    private String ownerPhoneNumber;
    private List<String> medicalRecords;

}
