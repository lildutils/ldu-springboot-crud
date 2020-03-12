package com.lildutils.springboot.crud.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LDuMongoCrudRepository<TMODEL, TID> extends MongoRepository<TMODEL, TID>
{

}
