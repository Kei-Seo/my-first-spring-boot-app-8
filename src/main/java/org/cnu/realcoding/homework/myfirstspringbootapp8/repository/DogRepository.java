package org.cnu.realcoding.homework.myfirstspringbootapp8.repository;

import org.cnu.realcoding.homework.myfirstspringbootapp8.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public Dog findDogByName(String name) {
        return mongoTemplate
                .findOne(Query.query(Criteria.where("name").is(name)),
                        Dog.class
                );
    }

    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
    }

    public List<Dog> findAllDog() {
        return mongoTemplate.findAll(Dog.class);
    }

    public Dog findDogByOwnerName(String ownerName) {
        return mongoTemplate
                .findOne(Query.query(Criteria.where("ownerName").is(ownerName)),
                        Dog.class
                );
    }

    public Dog findDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        return mongoTemplate
                .findOne(Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                        Dog.class
                );
    }

    public void updateDog(Dog dog, Dog dog_after){
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("name").is(dog.getName()));
        query.addCriteria(Criteria.where("kind").is(dog.getKind()));
        query.addCriteria(Criteria.where("ownerName").is(dog.getOwnerName()));
        query.addCriteria(Criteria.where("ownerPhoneNumber").is(dog.getOwnerPhoneNumber()));

        update.set("name", dog_after.getName());
        update.set("kind", dog_after.getKind());
        update.set("ownerName", dog_after.getOwnerName());
        update.set("ownerPhoneNumber", dog_after.getOwnerPhoneNumber());

        mongoTemplate.updateMulti(query, update, Dog.class);

    }

    public void updateKind(Dog dog, String kind){
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("kind").is(dog.getKind()));

        update.set("kind", kind);
        mongoTemplate.updateFirst(query, update, Dog.class);
    }

    public void DogMedicalRecordUpdate(Dog dog){
        Query query = new Query();
        Update update = new Update();

        query.addCriteria(Criteria.where("name").is(dog.getName()));
        query.addCriteria(Criteria.where("kind").is(dog.getKind()));
        query.addCriteria(Criteria.where("ownerName").is(dog.getOwnerName()));
        query.addCriteria(Criteria.where("ownerPhoneNumber").is(dog.getOwnerPhoneNumber()));

        update.set("medicalRecords", dog.getMedicalRecords());

        mongoTemplate.updateMulti(query, update, Dog.class);
    }

}