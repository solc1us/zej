package com.example.zej.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.zej.model.RPP;

public interface RPPRepo extends MongoRepository<RPP, String> {

  @Query("{id:'?0'}")
  RPP findItemById(String id);

  @Query(value = "{id:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
  List<RPP> findAll(String id);

}
